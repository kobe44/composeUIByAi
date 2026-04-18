package utils

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.File
import java.io.IOException


/**
 * 单文件覆盖录音：filesDir/record_single.m4a
 * 授权通过后调用 start()；结束调用 stop()
 */
class SimpleVoiceRecorder(private val context: Context) {
    private var recorder: MediaRecorder? = null
    /** @return 输出文件；失败返回 null */
    fun start(outputName: String = "record_single.m4a"): File? {
        stop() // 避免泄漏
        val file = File(context.filesDir, outputName)
        if (file.exists()) {
            file.delete()
        }
        val mr =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                MediaRecorder(context)
            } else {
                @Suppress("DEPRECATION")
                MediaRecorder()
            }
        return try {
            mr.setAudioSource(MediaRecorder.AudioSource.MIC)
            mr.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            // 常见语音质量：可调低码率省体积
            mr.setAudioEncodingBitRate(128_000)
            mr.setAudioSamplingRate(44_100)
            mr.setOutputFile(file.absolutePath)
            mr.prepare()
            mr.start()
            recorder = mr
            file
        } catch (e: IOException) {
            e.printStackTrace()
            safeRelease(mr)
            null
        } catch (e: RuntimeException) {
            e.printStackTrace()
            safeRelease(mr)
            null
        }
    }

    fun stop() {
        val mr = recorder ?: return
        try {
            mr.stop()
        } catch (_: RuntimeException) {
            // 未正确 start / 已经被停过 等
        } finally {
            safeRelease(mr)
            recorder = null
        }
    }

    private fun safeRelease(mr: MediaRecorder?) {
        mr ?: return
        try {
            mr.reset()
        } catch (_: Exception) {
        }
        try {
            mr.release()
        } catch (_: Exception) {
        }
    }
}