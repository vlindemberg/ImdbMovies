import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.imdbmovies"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.imdbmovies"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        android.buildFeatures.buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://moviesdatabase.p.rapidapi.com/\"")
            buildConfigField("String", "KEY", "\"36cdc7ede0msh7306a8efa1f227fp19ee21jsne9870b31acf2\"")
            buildConfigField("String", "HOST", "\"moviesdatabase.p.rapidapi.com\"")
        }
        debug {
            buildConfigField("String", "BASE_URL", "\"https://moviesdatabase.p.rapidapi.com/\"")
            buildConfigField("String", "KEY", "\"36cdc7ede0msh7306a8efa1f227fp19ee21jsne9870b31acf2\"")
            buildConfigField("String", "HOST", "\"moviesdatabase.p.rapidapi.com\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget= "1.8"
    }
}

kotlin {
    jvmToolchain(8)
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    runtimeOnly("androidx.constraintlayout:constraintlayout:1.1.3")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.fragment:fragment-ktx:1.5.5")
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-android-compiler:2.45")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")

    implementation("io.reactivex.rxjava2:rxjava:2.2.2")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    implementation("com.google.code.gson:gson:2.8.9")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.okhttp3:mockwebserver:4.3.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    implementation("com.github.sparrow007:carouselrecyclerview:1.2.6")
    implementation("com.github.bumptech.glide:glide:4.15.0")

    implementation("com.airbnb.android:lottie:3.4.0")
}

kapt {
    correctErrorTypes = true
}