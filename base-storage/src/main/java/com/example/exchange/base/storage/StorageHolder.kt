package com.example.exchange.base.storage

import android.content.Context
import com.tencent.mmkv.MMKV

/**
 * MMKV 初始化与默认 [KVStore]（在 Application 中先调用 [init]）。
 */
object StorageHolder {

    private var _kv: KVStore? = null

    val kv: KVStore
        get() = _kv ?: error("StorageHolder.init() must be called in Application")

    fun init(context: Context) {
        if (_kv != null) return
        MMKV.initialize(context)
        _kv = MmkvKVStore()
    }
}
