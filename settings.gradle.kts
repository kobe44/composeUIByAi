pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
include(":base-net")
include(":base-ui")
include(":base-router")
include(":base-storage")
include(":common-login")
include(":common-user")
include(":common-asset")
include(":common-notify")
include(":business-market")
include(":business-mall")
include(":business-trade")
include(":business-otc")
include(":business-finance")
