plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.legacy.kapt)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.exchange.common.user"
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
    buildFeatures {
        compose = true
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
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    kapt(libs.arouter.compiler)
}
