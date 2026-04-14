package com.example.exchange.business.mall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchange.base.storage.StorageHolder
import com.example.exchange.business.mall.data.CartLine
import com.example.exchange.business.mall.data.FakeStoreClient
import com.example.exchange.business.mall.data.LoginRequest
import com.example.exchange.business.mall.data.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class MallUiState(
    val isLoggedIn: Boolean = false,
    val loading: Boolean = false,
    val products: List<Product> = emptyList(),
    val cartLines: List<CartLine> = emptyList(),
    val error: String? = null,
)

class MallViewModel : ViewModel() {

    private val kv = StorageHolder.kv
    private val gson = Gson()
    private val api = FakeStoreClient.api

    private val _uiState = MutableStateFlow(
        MallUiState(isLoggedIn = kv.getString(KEY_TOKEN).isNotEmpty()),
    )
    val uiState: StateFlow<MallUiState> = _uiState.asStateFlow()

    init {
        loadCartFromStorage()
        if (_uiState.value.isLoggedIn) {
            loadProducts()
        }
    }

    fun consumeError() {
        _uiState.update { it.copy(error = null) }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true, error = null) }
            runCatching {
                api.login(LoginRequest(username = username, password = password))
            }.onSuccess { res ->
                kv.putString(KEY_TOKEN, res.token)
                _uiState.update { it.copy(isLoggedIn = true, loading = false) }
                loadProducts()
            }.onFailure { e ->
                _uiState.update {
                    it.copy(loading = false, error = e.message ?: "登录失败")
                }
            }
        }
    }

    fun logout() {
        kv.remove(KEY_TOKEN)
        _uiState.update { it.copy(isLoggedIn = false, products = emptyList()) }
    }

    fun loadProducts() {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true, error = null) }
            runCatching { api.products() }
                .onSuccess { list ->
                    _uiState.update { it.copy(products = list, loading = false) }
                }
                .onFailure { e ->
                    _uiState.update {
                        it.copy(loading = false, error = e.message ?: "加载商品失败")
                    }
                }
        }
    }

    fun addToCart(product: Product) {
        val lines = _uiState.value.cartLines.toMutableList()
        val idx = lines.indexOfFirst { it.productId == product.id }
        if (idx >= 0) {
            val old = lines[idx]
            lines[idx] = old.copy(quantity = old.quantity + 1)
        } else {
            lines.add(
                CartLine(
                    productId = product.id,
                    title = product.title,
                    price = product.price,
                    image = product.image,
                    quantity = 1,
                ),
            )
        }
        _uiState.update { it.copy(cartLines = lines) }
        persistCart(lines)
    }

    fun setQuantity(productId: Int, quantity: Int) {
        if (quantity <= 0) {
            removeLine(productId)
            return
        }
        val lines = _uiState.value.cartLines.map {
            if (it.productId == productId) it.copy(quantity = quantity) else it
        }
        _uiState.update { it.copy(cartLines = lines) }
        persistCart(lines)
    }

    fun removeLine(productId: Int) {
        val lines = _uiState.value.cartLines.filter { it.productId != productId }
        _uiState.update { it.copy(cartLines = lines) }
        persistCart(lines)
    }

    fun cartTotal(): Double =
        _uiState.value.cartLines.sumOf { it.price * it.quantity }

    private fun loadCartFromStorage() {
        val json = kv.getString(KEY_CART)
        if (json.isBlank()) return
        runCatching {
            val type = object : TypeToken<List<CartLine>>() {}.type
            val list: List<CartLine> = gson.fromJson(json, type)
            _uiState.update { it.copy(cartLines = list) }
        }
    }

    private fun persistCart(lines: List<CartLine>) {
        kv.putString(KEY_CART, gson.toJson(lines))
    }

    private companion object {
        const val KEY_TOKEN = "mall_fakestore_token"
        const val KEY_CART = "mall_cart_lines_json"
    }
}
