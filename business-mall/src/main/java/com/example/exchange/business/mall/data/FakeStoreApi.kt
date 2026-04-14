package com.example.exchange.business.mall.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * [Fake Store API](https://fakestoreapi.com) — 仅用于 Demo。
 */
interface FakeStoreApi {

    @POST("auth/login")
    suspend fun login(@Body body: LoginRequest): LoginResponse

    @GET("products")
    suspend fun products(): List<Product>

    @GET("products/{id}")
    suspend fun product(@Path("id") id: Int): Product
}
