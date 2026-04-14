package com.example.exchange.base.storage

import com.tencent.mmkv.MMKV

class MmkvKVStore(
    private val mmkv: MMKV = MMKV.defaultMMKV()!!,
) : KVStore {

    override fun getString(key: String, default: String): String =
        mmkv.decodeString(key, default) ?: default

    override fun putString(key: String, value: String) {
        mmkv.encode(key, value)
    }

    override fun getBoolean(key: String, default: Boolean): Boolean =
        mmkv.decodeBool(key, default)

    override fun putBoolean(key: String, value: Boolean) {
        mmkv.encode(key, value)
    }

    override fun remove(key: String) {
        mmkv.removeValueForKey(key)
    }

    override fun clear() {
        mmkv.clearAll()
    }
}
