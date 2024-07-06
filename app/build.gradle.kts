plugins {
    id("kotlin-kapt")
    alias(libs.plugins.hilt)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.github.smmousavi.starswar"
    compileSdk = 34

    buildFeatures {
        compose = true
    }

    defaultConfig {
        applicationId = "com.github.smmousavi.starswar"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("benchmark") {
            initWith(buildTypes.getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}


dependencies {
    implementation(project(":core:data:datasource"))
    implementation(project(":core:data:repository"))
    implementation(project(":core:database"))
    implementation(project(":core:model"))
    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:common"))
    implementation(project(":feature:home"))
    implementation(project(":feature:search"))
    implementation(project(":feature:details"))
    implementation(project(":sync:work"))

    // AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)
    androidTestImplementation(libs.androidx.compose.ui.test)

    // coil
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.svg)

    // coroutine
    implementation(libs.kotlinx.coroutines.guava)
    testImplementation(libs.kotlinx.coroutines.test)

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kapt(libs.hilt.ext.compiler)
    kaptTest(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(libs.hilt.android.testing)

    // navigation
    implementation(libs.androidx.navigation.compose)
    androidTestImplementation(libs.androidx.navigation.testing)

    // testing
    testImplementation(libs.androidx.work.testing)
    testImplementation(libs.robolectric)
    testImplementation(libs.roborazzi)
    androidTestImplementation(libs.androidx.test.espresso.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    testImplementation(libs.turbine)
    implementation(libs.androidx.test.core)
    implementation(libs.androidx.test.espresso.core)
    implementation(libs.androidx.test.ext)
    implementation(libs.androidx.test.rules)
    implementation(libs.androidx.test.runner)
    implementation(libs.androidx.test.uiautomator)

    // retrofit
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)
    implementation(libs.javax.inject)
    api(libs.kotlinx.datetime)

    // room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    // others
    api(libs.androidx.dataStore.core)
    implementation(libs.accompanist.permissions)
    api(libs.androidx.metrics)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.benchmark.macro)
    implementation(libs.truth)
    implementation(libs.google.oss.licenses)
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.androidx.window.core)
}