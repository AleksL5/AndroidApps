plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.nasa"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.nasa"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation (libs.androidx.core.ktx.v170)
    implementation (libs.androidx.appcompat.v140)
    implementation (libs.material.v140)
    implementation(libs.androidx.activity)
    implementation (libs.androidx.constraintlayout.v211)


    implementation (libs.androidx.paging.runtime)

    implementation (libs.material.v180)


    implementation (libs.retrofit)
    implementation (libs.converter.gson)


    implementation (libs.glide)
    kapt (libs.compiler)


    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.runtime.ktx)

    implementation (libs.glide.v4151)
    kapt (libs.compiler.v4151)
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")
}
