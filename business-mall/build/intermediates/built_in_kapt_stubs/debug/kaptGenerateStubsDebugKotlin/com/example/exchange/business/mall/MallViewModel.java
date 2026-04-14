package com.example.exchange.business.mall;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0012H\u0002J\u0016\u0010$\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006)"}, d2 = {"Lcom/example/exchange/business/mall/MallViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "kv", "Lcom/example/exchange/base/storage/KVStore;", "gson", "Lcom/google/gson/Gson;", "api", "Lcom/example/exchange/business/mall/data/FakeStoreApi;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/exchange/business/mall/MallUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "consumeError", "", "login", "username", "", "password", "logout", "loadProducts", "addToCart", "product", "Lcom/example/exchange/business/mall/data/Product;", "setQuantity", "productId", "", "quantity", "removeLine", "cartTotal", "", "loadCartFromStorage", "persistCart", "lines", "", "Lcom/example/exchange/business/mall/data/CartLine;", "Companion", "business-mall"})
public final class MallViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.exchange.base.storage.KVStore kv = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.exchange.business.mall.data.FakeStoreApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.exchange.business.mall.MallUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.exchange.business.mall.MallUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String KEY_TOKEN = "mall_fakestore_token";
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String KEY_CART = "mall_cart_lines_json";
    @org.jetbrains.annotations.NotNull()
    private static final com.example.exchange.business.mall.MallViewModel.Companion Companion = null;
    
    public MallViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.exchange.business.mall.MallUiState> getUiState() {
        return null;
    }
    
    public final void consumeError() {
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void logout() {
    }
    
    public final void loadProducts() {
    }
    
    public final void addToCart(@org.jetbrains.annotations.NotNull()
    com.example.exchange.business.mall.data.Product product) {
    }
    
    public final void setQuantity(int productId, int quantity) {
    }
    
    public final void removeLine(int productId) {
    }
    
    public final double cartTotal() {
        return 0.0;
    }
    
    private final void loadCartFromStorage() {
    }
    
    private final void persistCart(java.util.List<com.example.exchange.business.mall.data.CartLine> lines) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/exchange/business/mall/MallViewModel$Companion;", "", "<init>", "()V", "KEY_TOKEN", "", "KEY_CART", "business-mall"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}