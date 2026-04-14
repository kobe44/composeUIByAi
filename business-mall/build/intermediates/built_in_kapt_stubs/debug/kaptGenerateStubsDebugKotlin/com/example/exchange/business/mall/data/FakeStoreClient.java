package com.example.exchange.business.mall.data;

/**
 * 独立 Retrofit 实例，根地址为 Fake Store（与壳工程 [NetworkClient] 的业务域名分离）。
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/example/exchange/business/mall/data/FakeStoreClient;", "", "<init>", "()V", "BASE_URL", "", "TIMEOUT_SEC", "", "okHttp", "Lokhttp3/OkHttpClient;", "getOkHttp", "()Lokhttp3/OkHttpClient;", "okHttp$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "api", "Lcom/example/exchange/business/mall/data/FakeStoreApi;", "getApi", "()Lcom/example/exchange/business/mall/data/FakeStoreApi;", "api$delegate", "business-mall"})
public final class FakeStoreClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://fakestoreapi.com/";
    private static final long TIMEOUT_SEC = 30L;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy okHttp$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy retrofit$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy api$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.exchange.business.mall.data.FakeStoreClient INSTANCE = null;
    
    private FakeStoreClient() {
        super();
    }
    
    private final okhttp3.OkHttpClient getOkHttp() {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.exchange.business.mall.data.FakeStoreApi getApi() {
        return null;
    }
}