plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "id.neotica.rickpositorylegacy"
    compileSdk = 35

    defaultConfig {
        applicationId = "id.neotica.rickpositorylegacy"
        minSdk = 16
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
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    // RxJava 3 (from previous step)
    implementation(libs.rxjava3.core)
    implementation(libs.rxjava3.android)

    // Glide (from previous step)
    implementation(libs.glide.runtime)
    annotationProcessor(libs.glide.compiler) // For Java projects. If using Kotlin, use 'kapt libs.glide.compiler'

    // Dagger 2
    implementation(libs.dagger.core)
    annotationProcessor(libs.dagger.compiler)

    //Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)  // For JSON parsing with Gson
    implementation(libs.retrofit.adapter.rxjava3) // For RxJava 3 integration
    implementation(libs.okhttp.logging.interceptor) // Optional: For logging network requests and responses


            testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}