object Dependency {

    const val pluginKotlinApp = "kotlin-android"
    const val pluginKotlinKapt = "kotlin-kapt"
    const val pluginKotlinParcelize = "kotlin-parcelize"
    const val pluginSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val pluginGoogleService = "com.google.gms.google-services"
    const val pluginCrashlytics = "com.google.firebase.crashlytics"
    const val pluginRealm = "realm-android"

    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompatVersion}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtxVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Version.fragmentVersion}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigationFragmentVersion}"
    const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Version.navigationUiVersion}"
    const val navigationRuntimeKtx =
        "androidx.navigation:navigation-runtime-ktx:${Version.navigationRuntime}"
    const val kotlinxCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutineCoreVersion}"
    const val material = "com.google.android.material:material:${Version.materialVersion}"
    const val materialAlpha = "com.google.android.material:material:${Version.materialAlphaVersion}"
    const val playServicesAuth =
        "com.google.android.gms:play-services-auth:${Version.googleServicesVersion}"
    const val pluginBuildTools = "com.android.tools.build:gradle:${Version.buildToolsVersion}"
    const val pluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    const val pluginSageArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.safeArgsVersion}"

    const val testAndroidJEspressoCore =
        "androidx.test.espresso:espresso-core:${Version.espressoCoreVersion}"
    const val testAndroidJunit = "androidx.test.ext:junit:${Version.androidJunitVersion}"
    const val testAndroidRunner = "androidx.test:runner:${Version.testAndroidRunnerVersion}"
    const val testAndroidRules = "androidx.test:rules:${Version.testAndroidRulesVersion}"
    const val testJunit = "junit:junit:${Version.jUnitVersion}"
    const val testTruth = "com.google.truth:truth:${Version.testTruthVersion}"
    const val viewmodelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewmodelVersion}"

    const val pluginGmsGoogleServices =
        "com.google.gms:google-services:${Version.gmsGoogleServicesVersion}"

    const val lottie = "com.airbnb.android:lottie:${Version.lottieVersion}"
    const val roundableImageView =
        "com.makeramen:roundedimageview:${Version.roundableImageViewVersion}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Version.recyclerViewVersion}"
    const val securityCrypto = "androidx.security:security-crypto:${Version.securityCryptoVersion}"

    //KOTLIN & COROUTINES
    const val workRuntime = "androidx.work:work-runtime-ktx:${Version.workRuntimeVersion}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntimeVersion}"
    const val lifecycleExtensions =
        "android.arch.lifecycle:extensions:${Version.lifecycleExtensionsVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Version.activityKtxVersion}"
    const val lifecycleKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycleKtxVersion}"

    //DESIGN
    const val circularProgress =
        "com.jackandphantom.android:circularprogressbar:${Version.circularProgressVersion}"
    const val realtimeBlurView =
        "com.github.mmin18:realtimeblurview:${Version.realtimeBlurViewVersion}"
    const val kProgressHud = "com.kaopiz:kprogresshud:${Version.kProgressHudVersion}"
    const val donutLibrary = "app.futured.donut:library:${Version.donutLibraryVersion}"
    const val picassoLibrary = "com.squareup.picasso:picasso:${Version.picassoLibraryVersion}"
    const val glideLibrary = "com.github.bumptech.glide:glide:${Version.glideLibraryVersion}"
    const val glideCompilerLibrary =
        "com.github.bumptech.glide:compiler:${Version.glideLibraryVersion}"
    const val circleImage = "de.hdodenhof:circleimageview:${Version.circleImageVersion}"
    const val stfalconImageViewer =
        "com.github.stfalcon-studio:StfalconImageViewer:${Version.stfalconImageViewerVersion}"

    //UTILS
    const val imageConverterLibrary = "com.blankj:utilcodex:${Version.imageConverterLibraryVersion}"

    //FIREBASE
    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics:${Version.firebaseAnalyticsVersion}"
    const val pluginFirebaseCrashlyticsGradle =
        "com.google.firebase:firebase-crashlytics-gradle:${Version.firebaseCrashlyticsGradle}"
    const val firebaseCrashlyticsKtx =
        "com.google.firebase:firebase-crashlytics-ktx:${Version.firebaseCrashlytics}"
    const val firebaseAuth = "com.google.firebase:firebase-auth:${Version.firebaseAuthVersion}"
    const val firestoreKtx =
        "com.google.firebase:firebase-firestore-ktx:${Version.firestoreKtxVersion}"
    const val firestoreStorage =
        "com.google.firebase:firebase-storage:${Version.firestoreStorageVersion}"
    const val firestore = "com.google.firebase:firebase-firestore:${Version.firestoreVersion}"

    //Retrofit
    const val gson = "com.google.code.gson:gson:${Version.gsonVersion}"
    const val squareupRetrofit =
        "com.squareup.retrofit2:retrofit:${Version.squareupRetrofitVersion}"
    const val squareupGson =
        "com.squareup.retrofit2:converter-gson:${Version.squareupGsonConverterVersion}"
    const val squareupLogging =
        "com.squareup.okhttp3:logging-interceptor:${Version.squareupLoggingVersion}"

    //Google Maps
    const val serviceMap = "com.google.android.gms:play-services-maps:${Version.serviceMapVersion}"
    const val serviceLocation =
        "com.google.android.gms:play-services-location:${Version.serviceLocationVersion}"
    const val placesLibrary =
        "com.google.android.libraries.places:places:${Version.placesLibraryVersion}"

    const val rxJava2Adapter =
        "com.squareup.retrofit2:adapter-rxjava2:${Version.rxJava2AdapterVersion}"
    const val keyboardVisibility =
        "net.yslibrary.keyboardvisibilityevent:keyboardvisibilityevent:${Version.keyboardVisibilityVersion}"

    //Injection Dependencies
    const val dagger2 = "com.google.dagger:dagger:${Version.dagger2Version}"
    const val dagger2Compiler =
        "com.google.dagger:dagger-compiler:${Version.dagger2CompilerVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${Version.koinVersion}"
    const val koinCore = "io.insert-koin:koin-core:${Version.koinVersion}"

    //Permission
    const val dexter = "com.karumi:dexter:${Version.dexterVersion}"

    //Transactions
    const val mercadoPago = "com.mercadopago.android.px:checkout:${Version.mercadoPagoVersion}"
    const val apacheOrg =
        "org.jbundle.util.osgi.wrapped:org.jbundle.util.osgi.wrapped.org.apache.http.client:${Version.apacheOrgVersion}"

    //QR
    const val saveQrUtils = "com.journeyapps:zxing-android-embedded:${Version.saveUtilsVersion}"
    const val zxingCore = "com.google.zxing:core:${Version.zxingCoreVersion}"

    //Google Maps
    const val googleMap = "com.google.android.gms:play-services-maps:${Version.googleMapVersion}"

    //Splash
    const val splashGoogle = "androidx.core:core-splashscreen:${Version.splashVersion}"

}