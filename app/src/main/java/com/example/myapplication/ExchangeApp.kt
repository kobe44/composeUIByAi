package com.example.myapplication

import android.app.Application
import android.content.pm.ApplicationInfo
import com.example.exchange.base.net.NetworkClient
import com.example.exchange.base.router.RouterManager
import com.example.exchange.base.storage.StorageHolder

/**
 * 壳工程 Application：基础库初始化顺序建议 Storage → Network → Router（ARouter 需最后或按团队规范）。
 */
class ExchangeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        StorageHolder.init(this)
        val debug = (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
        NetworkClient.init(BASE_API_URL, debug)
        RouterManager.init(this)
    }

    companion object {
        /** 替换为真实交易所 API 根地址，须以 / 结尾 */
        const val BASE_API_URL = "https://api.example.com/"
    }
}
