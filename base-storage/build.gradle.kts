plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.exchange.base.storage"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }
    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    api(libs.mmkv)
    api(libs.androidx.security.crypto)
    api(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.core.ktx)
}
