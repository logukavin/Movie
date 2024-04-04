// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        //Android Libraries
        set("compileSdk_Version", 34)
        set("minSdk_Version", 24)
        set("targetSdk_Version", 34)
        set("versionCode_Version", 1)
        set("versionName_Version", "1.0")
        set("jvmTarget_Version", "1.8")
        set("appcompat_Version", "1.6.1")

        set("material_Version", "1.11.0")
        set("constraintlayout_Version", "2.1.4")
        set("multidex_Version", "2.0.1")
        set("espresso_core_Version", "3.5.1")
        set("test_junit_Version", "1.1.5")
        set("junit_Version", "4.13.2")
        set("appcompat_Version", "1.6.1")
        set("core_ktx_Version", "1.12.0")
        set("recyclerview_Version", "1.3.2")

        // Lifecycle
        set("lifecycle_livedata_Version", "2.7.0")
        set("lifecycle_viewmodel_Version", "2.7.0")
        set("lifecycle_common_Version", "1.1.1")
        set("lifecycle_runtime_Version", "2.7.0")

        //Network
        set("retrofit_Version", "2.9.0")
        set("gson_Version", "2.10.1")
        set("converter_gson_Version", "2.9.0")
        set("logging_interceptor_Version", "4.11.0")

        // Coroutines
        set("coroutines_Version", "1.7.3")
        set("coroutines_core_Version", "1.6.0")
        set("coroutines_adapter_Version", "0.9.2")

        //hilt
        set("hilt_android_Version", "2.49")
        set("hilt_compiler_Version", "2.44")

        //paging
        set("paging_Version", "3.2.1")

        //coil
        set("coil_Version", "2.5.0")

        //Firebase
        set("firebase_bom_Version", "32.8.0")


    }
}
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id("com.android.library") version "8.1.1" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.21" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("com.google.firebase.crashlytics") version "2.9.9" apply false

}



