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

    flavorDimensions += "version"
    productFlavors {
        create("client") {
            dimension = "version"

            val versionMajor = 1
            val versionMinor = 0
            val versionBuild = 0
            versionCode = 1

            versionName = "$versionMajor.$versionMinor.$versionBuild"
            applicationIdSuffix = ".client"
            versionNameSuffix = "-client"

            setProperty("archivesBaseName", versionName)
        }
        create("partner") {
            dimension = "version"

            val versionMajor = 1
            val versionMinor = 0
            val versionBuild = 0
            versionCode = 1

            versionName = "$versionMajor.$versionMinor.$versionBuild"
            applicationIdSuffix = ".partner"
            versionNameSuffix = "-partner"

            setProperty("archivesBaseName", versionName)
        }
        create("pointOfSale") {
            dimension = "version"

            val versionMajor = 1
            val versionMinor = 0
            val versionBuild = 0
            versionCode = 1

            versionName = "$versionMajor.$versionMinor.$versionBuild"
            applicationIdSuffix = ".pointOfSale"
            versionNameSuffix = "-pointOfSale"

            setProperty("archivesBaseName", versionName)
        }
        create("delivery") {
            dimension = "version"

            val versionMajor = 1
            val versionMinor = 0
            val versionBuild = 0
            versionCode = 1

            versionName = "$versionMajor.$versionMinor.$versionBuild"
            applicationIdSuffix = ".delivery"
            versionNameSuffix = "-delivery"

            setProperty("archivesBaseName", versionName)
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
    implementation(Dependency.coreKtx)
    implementation(Dependency.appcompat)
    implementation(Dependency.material)
    implementation(Dependency.constraintlayout)
    testImplementation(Dependency.testJunit)
    androidTestImplementation(Dependency.testAndroidJunit)
    androidTestImplementation(Dependency.testAndroidJEspressoCore)
    implementation(Dependency.splashGoogle)
    implementation(Dependency.viewmodelKtx)
    implementation(Dependency.composeUiUi)
    implementation(Dependency.composeUiUtil)
    implementation(Dependency.composeUiTooling)
    implementation(Dependency.composeFoundation)
    implementation(Dependency.composeMaterial)
    implementation(Dependency.composeIconsCore)
    implementation(Dependency.composeIconsExtended)
    implementation(Dependency.composeRuntimeLiveData)
    implementation(Dependency.composeActivity)
    implementation(Dependency.composeLifecycleViewModel)
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("com.google.accompanist:accompanist-pager:0.13.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.13.0")
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("com.google.accompanist:accompanist-flowlayout:0.23.1")
}