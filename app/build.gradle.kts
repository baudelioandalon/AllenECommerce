plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply {
    plugin(Dependency.pluginKotlinApp)
    plugin(Dependency.pluginKotlinKapt)
    plugin(Dependency.pluginKotlinParcelize)
    plugin(Dependency.pluginSafeArgs)
    plugin(Dependency.pluginCrashlytics)
}

android {
    signingConfigs {
        getByName("debug") {
            val properties =
                org.jetbrains.kotlin.konan.properties.loadProperties(project.rootProject.file("local.properties").path)
            storeFile = file("../gradle/keystoreboreal.jks")
            storePassword = properties.getProperty("STORE_PASSWORD")
            keyAlias = properties.getProperty("KEY_ALIAS")
            keyPassword = properties.getProperty("KEY_PASSWORD")
        }
        create("release") {
            val properties =
                org.jetbrains.kotlin.konan.properties.loadProperties(project.rootProject.file("local.properties").path)
            storeFile = file("../gradle/keystoreboreal.jks")
            storePassword = properties.getProperty("STORE_PASSWORD")
            keyPassword = properties.getProperty("KEY_PASSWORD")
            keyAlias = properties.getProperty("KEY_ALIAS")
        }
    }

    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        applicationId = AndroidConfig.appId
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        signingConfig = signingConfigs.getByName("release")
        testInstrumentationRunner = AndroidConfig.testRunner
    }


    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":commonutils"))
    implementation(project(":library:core"))
    implementation(project(":library:ui-system"))
    implementation(project(":features:login"))
    implementation(Dependency.coreKtx)
    implementation(Dependency.appcompat)
    implementation(Dependency.material)
    implementation(Dependency.constraintlayout)
    testImplementation(Dependency.testJunit)
    androidTestImplementation(Dependency.testAndroidJunit)
    androidTestImplementation(Dependency.testAndroidJEspressoCore)
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation(Dependency.splashGoogle)
}
repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven(url = "https://www.jitpack.io")
    maven(
        url = ("https://maven.google.com")
    )
}