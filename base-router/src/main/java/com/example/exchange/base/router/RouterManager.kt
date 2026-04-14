package com.example.exchange.base.router

import android.app.Application
import android.content.pm.ApplicationInfo
import com.alibaba.android.arouter.launcher.ARouter

/**
 * ARouter 初始化与调试开关（在 Application 中调用一次）。
 */
object RouterManager {

    fun init(app: Application) {
        val debug = (app.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
        if (debug) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(app)
    }
}
