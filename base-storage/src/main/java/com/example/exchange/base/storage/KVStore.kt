package com.example.exchange.base.storage

/**
 * 键值存储抽象，便于替换实现或 mock。
 */
interface KVStore {
    fun getString(key: String, default: String = ""): String
    fun putString(key: String, value: String)
    fun getBoolean(key: String, default: Boolean = false): Boolean
    fun putBoolean(key: String, value: Boolean)
    fun remove(key: String)
    fun clear()
}
