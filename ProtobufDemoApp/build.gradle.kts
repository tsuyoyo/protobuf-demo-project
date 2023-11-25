// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        // https://square.github.io/wire/changelog/
        // Kotlin was updated to 1.8.20 since 4.5.3?
        classpath("com.squareup.wire:wire-gradle-plugin:4.5.2")
    }
}
