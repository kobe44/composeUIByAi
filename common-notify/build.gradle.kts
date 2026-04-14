plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.legacy.kapt)
}

android {
    namespace = "com.example.exchange.common.notify"
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

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
    }
}

dependencies {
    implementation(project(":base-ui"))
    implementation(project(":base-router"))
    implementation(project(":base-net"))
    implementation(project(":base-storage"))
    kapt(libs.arouter.compiler)
}
