package com.example.exchange.common.user

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.MaterialTheme
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.BaseActivity
import com.example.exchange.common.user.ui.UserMainScreen
import utils.SimpleVoiceRecorder
import java.io.File

@Route(path = RoutePath.User.PAGE)
class UserMainActivity : BaseActivity() {

    private val voiceRecorder by lazy { SimpleVoiceRecorder(this) }

    /** 播放录音用，停止播放时需 release */
    private var mediaPlayer: MediaPlayer? = null

    /** 录音权限回调 */
    private val requestMic =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                onMicGranted()
            } else {
                onMicDenied()
            }
        }

    /** 系统通知权限回调 */
    private val requestNotify =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                onNotifyGranted()
            } else {
                onNotifyDenied()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                UserMainScreen(
                    onPlayClick = { onPlayClick() },
                    onStopPlayClick = { onStopPlayClick() },
                    onRecordClick = { micPermissionForRecording() },
                    onStopRecordClick = { onStopRecordClick() },
                )
            }
        }
    }

    private fun onPlayClick() {
        val audioFile = File(filesDir, "record_single.m4a")
        if (audioFile.exists() && audioFile.length() > 0) {
            startPlayback(audioFile)
        } else {
            Toast.makeText(this, "您还没有录制音频哦，请先录制音频。。。。", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onStopPlayClick() {
        if (mediaPlayer == null) {
            Toast.makeText(this, "当前没有在播放", Toast.LENGTH_SHORT).show()
            return
        }
        releaseMediaPlayer()
        Toast.makeText(this, "已停止播放", Toast.LENGTH_SHORT).show()
    }

    private fun onStopRecordClick() {
        releaseMediaPlayer()
        voiceRecorder.stop()
        Toast.makeText(this, "已经停止录制，快去播放试试哦。。。。", Toast.LENGTH_SHORT).show()
    }

    private fun startPlayback(file: File) {
        releaseMediaPlayer()
        val mp = MediaPlayer()
        try {
            mp.setDataSource(file.absolutePath)
            mp.setOnCompletionListener { player ->
                try {
                    player.release()
                } catch (_: Exception) {
                }
                mediaPlayer = null
                Toast.makeText(this, "录音播放结束了。。。。", Toast.LENGTH_SHORT).show()
            }
            mp.prepare()
            mp.start()
            mediaPlayer = mp
        } catch (e: Exception) {
            e.printStackTrace()
            mp.release()
            mediaPlayer = null
            Toast.makeText(this, "播放失败", Toast.LENGTH_SHORT).show()
        }
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.let { mp ->
            try {
                mp.setOnCompletionListener(null)
            } catch (_: Exception) {
            }
            try {
                if (mp.isPlaying) {
                    mp.stop()
                }
            } catch (_: Exception) {
            }
            try {
                mp.release()
            } catch (_: Exception) {
            }
        }
        mediaPlayer = null
    }

    private fun onMicGranted() {
        val file = voiceRecorder.start()
        if (file == null) {
            Toast.makeText(this, "录音启动失败，请重试", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "正在录音中。。。。", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onNotifyDenied() {
        Toast.makeText(this, "授权失败，请确认授权通过再试", Toast.LENGTH_SHORT).show()
    }

    private fun onMicDenied() {
        Toast.makeText(this, "授权失败，请确认授权通过再试", Toast.LENGTH_SHORT).show()
    }

    private fun onNotifyGranted() {}


    /** mic授权判断 */
    fun micPermissionForRecording() {
        val requestOk = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.RECORD_AUDIO,
        ) == PackageManager.PERMISSION_GRANTED
        if (requestOk) {
            onMicGranted()
        } else {
            requestMic.launch(Manifest.permission.RECORD_AUDIO)
        }
    }

    /** 系统通知授权判断 */
    fun postNotificationsIfNeeded() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return
        val ok = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.POST_NOTIFICATIONS,
        ) == PackageManager.PERMISSION_GRANTED
        if (!ok) {
            requestNotify.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    fun maybeExplainThenRequestMic() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO,
            ) == PackageManager.PERMISSION_GRANTED -> onMicGranted()

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.RECORD_AUDIO,
            ) -> requestMic.launch(Manifest.permission.RECORD_AUDIO)

            else -> requestMic.launch(Manifest.permission.RECORD_AUDIO)
        }
    }

    override fun onDestroy() {
        releaseMediaPlayer()
        super.onDestroy()
    }

}
