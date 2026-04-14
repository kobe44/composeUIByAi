package com.example.exchange.business.mall.ui;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001aB\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u001a*\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0011H\u0003\u001a$\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016H\u0003\u001a\u001e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u001aL\u0010\u001a\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0003\u001a:\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u00a8\u0006&"}, d2 = {"MallApp", "", "vm", "Lcom/example/exchange/business/mall/MallViewModel;", "MallTopBar", "route", "", "cartCount", "", "onCart", "Lkotlin/Function0;", "onLogout", "onBack", "LoginRoute", "loading", "", "onLogin", "Lkotlin/Function2;", "ProductListRoute", "uiState", "Lcom/example/exchange/business/mall/MallUiState;", "onAdd", "Lkotlin/Function1;", "Lcom/example/exchange/business/mall/data/Product;", "ProductCard", "product", "CartRoute", "lines", "", "Lcom/example/exchange/business/mall/data/CartLine;", "total", "", "onQty", "onRemove", "CartLineRow", "line", "onMinus", "onPlus", "business-mall"})
public final class MallAppKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MallApp(@org.jetbrains.annotations.NotNull()
    com.example.exchange.business.mall.MallViewModel vm) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    private static final void MallTopBar(java.lang.String route, int cartCount, kotlin.jvm.functions.Function0<kotlin.Unit> onCart, kotlin.jvm.functions.Function0<kotlin.Unit> onLogout, kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void LoginRoute(boolean loading, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onLogin) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProductListRoute(com.example.exchange.business.mall.MallUiState uiState, kotlin.jvm.functions.Function1<? super com.example.exchange.business.mall.data.Product, kotlin.Unit> onAdd) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProductCard(com.example.exchange.business.mall.data.Product product, kotlin.jvm.functions.Function0<kotlin.Unit> onAdd) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CartRoute(java.util.List<com.example.exchange.business.mall.data.CartLine> lines, double total, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onQty, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onRemove) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CartLineRow(com.example.exchange.business.mall.data.CartLine line, kotlin.jvm.functions.Function0<kotlin.Unit> onMinus, kotlin.jvm.functions.Function0<kotlin.Unit> onPlus, kotlin.jvm.functions.Function0<kotlin.Unit> onRemove) {
    }
}