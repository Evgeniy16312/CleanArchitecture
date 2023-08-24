// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    System.setProperty("navigationComponentsVersion", "2.5.3")

    dependencies {
        val navigationComponentsVersion = System.getProperty("navigationComponentsVersion")

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationComponentsVersion")
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.0" apply false
}