package com.example.exchange.business.mall.data;

/**
 * [Fake Store API](https://fakestoreapi.com) — 仅用于 Demo。
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2 = {"Lcom/example/exchange/business/mall/data/FakeStoreApi;", "", "login", "Lcom/example/exchange/business/mall/data/LoginResponse;", "body", "Lcom/example/exchange/business/mall/data/LoginRequest;", "(Lcom/example/exchange/business/mall/data/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "products", "", "Lcom/example/exchange/business/mall/data/Product;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "product", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "business-mall"})
public abstract interface FakeStoreApi {
    
    @retrofit2.http.POST(value = "auth/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.exchange.business.mall.data.LoginRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.exchange.business.mall.data.LoginResponse> $completion);
    
    @retrofit2.http.GET(value = "products")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object products(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.exchange.business.mall.data.Product>> $completion);
    
    @retrofit2.http.GET(value = "products/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object product(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.exchange.business.mall.data.Product> $completion);
}