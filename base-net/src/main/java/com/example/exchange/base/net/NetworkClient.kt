package com.example.exchange.base.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * OkHttp + Retrofit 单例入口，在壳工程 [App] 启动时调用 [init]。
 */
object NetworkClient {
    private const val TIMEOUT_SEC = 30L

    @Volatile
    private var retrofit: Retrofit? = null

    fun init(baseUrl: String, debug: Boolean) {
        if (retrofit != null) return
        val logging = HttpLoggingInterceptor().apply {
            level = if (debug) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        val client = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> api(service: Class<T>): T {
        val r = retrofit ?: error("NetworkClient.init() must be called in Application")
        return r.create(service)
    }

    inline fun <reified T> api(): T = api(T::class.java)
}
