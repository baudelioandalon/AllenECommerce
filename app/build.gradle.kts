plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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

//        signingConfig = signingConfigs.getByName("release")
        testInstrumentationRunner = AndroidConfig.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependency.composePlugin
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
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
    implementation(Dependency.splashGoogle)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.compose.foundation:foundation:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.compose.material:material-icons-core:1.2.1")
    implementation("androidx.compose.material:material-icons-extended:1.2.1")
    implementation("androidx.activity:activity-compose:1.6.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.2.1")
}