plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")

}

android {
    namespace = "com.example.movie"
    compileSdk = rootProject.extra["compileSdk_Version"] as Int?

    defaultConfig {
        applicationId = "com.example.movie"
        minSdk = rootProject.extra["minSdk_Version"] as Int?
        targetSdk = rootProject.extra["targetSdk_Version"] as Int?
        versionCode = rootProject.extra["versionCode_Version"] as Int?
        versionName = rootProject.extra["versionName_Version"].toString()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = rootProject.extra["jvmTarget_Version"].toString()
    }

    buildFeatures {
        viewBinding = true
    }

    kapt {
        correctErrorTypes= true
    }

}

dependencies {
    //Android Libraries
    implementation("androidx.core:core-ktx:${rootProject.extra["core_ktx_Version"]}")
    implementation("androidx.appcompat:appcompat:${rootProject.extra["appcompat_Version"]}")
    testImplementation("junit:junit:${rootProject.extra["junit_Version"]}")
    androidTestImplementation("androidx.test.ext:junit:${rootProject.extra["test_junit_Version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["espresso_core_Version"]}")
    implementation("androidx.multidex:multidex:${rootProject.extra["multidex_Version"]}")
    implementation("androidx.recyclerview:recyclerview:${rootProject.extra["recyclerview_Version"]}")

    // Lifecycle
    implementation("android.arch.lifecycle:common-java8:${rootProject.extra["lifecycle_common_Version"]}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${rootProject.extra["lifecycle_livedata_Version"]}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${rootProject.extra["lifecycle_viewmodel_Version"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.extra["lifecycle_runtime_Version"]}")

    // UI
    implementation("com.google.android.material:material:${rootProject.extra["material_Version"]}")
    implementation("androidx.constraintlayout:constraintlayout:${rootProject.extra["constraintlayout_Version"]}")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.extra["coroutines_core_Version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${rootProject.extra["coroutines_Version"]}")

    // Hilt
    implementation("com.google.dagger:hilt-android:${rootProject.extra["hilt_android_Version"]}")
    kapt("com.google.dagger:hilt-compiler:${rootProject.extra["hilt_android_Version"]}")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:${rootProject.extra["firebase_bom_Version"]}"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics-ktx")

    //paging
    implementation("androidx.paging:paging-runtime-ktx:${rootProject.extra["paging_Version"]}")

    // Coil
    implementation("io.coil-kt:coil:${rootProject.extra["coil_Version"]}")

    // Gson
    implementation("com.google.code.gson:gson:${rootProject.extra["gson_Version"]}")


}