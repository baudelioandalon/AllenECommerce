buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.7.20"
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://www.jitpack.io")
        maven(
            url = ("https://maven.google.com")
        )
    }
    dependencies {
        classpath(Dependency.pluginKotlin)
        classpath(Dependency.pluginBuildTools)
        classpath(Dependency.pluginSageArgs)
        classpath(Dependency.pluginFirebaseCrashlyticsGradle)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    }
}
allprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://www.jitpack.io")
        maven(
            url = ("https://maven.google.com")
        )
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}