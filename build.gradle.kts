buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("com.android.tools:r8:9.5.26")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}
