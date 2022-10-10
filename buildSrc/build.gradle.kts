import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven(url = "https://www.jitpack.io")
    maven(
        url =("https://maven.google.com")
    )
}