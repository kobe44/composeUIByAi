package com.example.exchange.business.mall.data

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val username: String,
    val password: String,
)

data class LoginResponse(
    val token: String,
)

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating? = null,
)

data class Rating(
    val rate: Double,
    val count: Int,
)

/** 本地购物车行（MMKV 持久化） */
data class CartLine(
    val productId: Int,
    val title: String,
    val price: Double,
    val image: String,
    val quantity: Int,
)
