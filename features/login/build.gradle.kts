plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}
apply {
    plugin(Dependency.pluginKotlinApp)
    plugin(Dependency.pluginKotlinKapt)
    plugin(Dependency.pluginKotlinParcelize)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = false
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
    androidTestImplementation(Dependency.testAndroidJEspressoCore)
    androidTestImplementation(Dependency.testAndroidJunit)
    androidTestImplementation(Dependency.testAndroidRules)
    androidTestImplementation(Dependency.testAndroidRunner)
    androidTestImplementation(Dependency.testTruth)
    testImplementation(Dependency.testJunit)

    api(Dependency.appcompat)
    api(Dependency.constraintlayout)
    api(Dependency.coreKtx)
    api(Dependency.gson)
    api(Dependency.kotlinxCoroutinesCore)
    api(Dependency.firebaseCrashlyticsKtx)
    api(Dependency.navigationUiKtx)
    api(Dependency.navigationFragmentKtx)
    api(Dependency.navigationRuntimeKtx)
    api(Dependency.recyclerview)
    api(Dependency.koinCore)
    api(Dependency.koinAndroid)

    implementation(Dependency.material)
    implementation(Dependency.materialAlpha)
    implementation(Dependency.viewmodelKtx)
    implementation(Dependency.workRuntime)
    implementation(Dependency.lifecycleRuntime)
    implementation(Dependency.lifecycleExtensions)
    implementation(Dependency.activityKtx)
    implementation(Dependency.lifecycleKtx)
    implementation(Dependency.playServicesAuth)

    implementation(Dependency.circularProgress)
    implementation(Dependency.realtimeBlurView)
    implementation(Dependency.kProgressHud)
    implementation(Dependency.donutLibrary)
    implementation(Dependency.picassoLibrary)
    implementation(Dependency.circleImage)

    implementation(Dependency.firebaseAuth)
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
}