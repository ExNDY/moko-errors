/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("kotlin-android-extensions")
    id("dev.icerock.mobile.multiplatform")
    id("maven-publish")
}

group = "dev.icerock.moko"
version = Versions.Libs.MultiPlatform.mokoErrors

android {
    compileSdkVersion(Versions.Android.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
    }
}

dependencies {
    mppLibrary(Deps.Libs.MultiPlatform.kotlinStdLib)

    androidLibrary(Deps.Libs.Android.appCompat)
    androidLibrary(Deps.Libs.Android.material)

    mppLibrary(Deps.Libs.MultiPlatform.mokoMvvm)
}

publishing {
    repositories.maven("https://api.bintray.com/maven/icerockdev/moko/moko-errors/;publish=1") {
        name = "bintray"

        credentials {
            username = System.getProperty("BINTRAY_USER")
            password = System.getProperty("BINTRAY_KEY")
        }
    }
}
