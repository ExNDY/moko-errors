/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiplatform)
    plugin(Deps.Plugins.kotlinAndroidExtensions)
    plugin(Deps.Plugins.mobileMultiplatform)
    plugin(Deps.Plugins.mokoResources)
    plugin(Deps.Plugins.mavenPublish)
}

group = "dev.icerock.moko"
version = Deps.mokoErrorsVersion

dependencies {
    commonMainImplementation(Deps.Libs.MultiPlatform.coroutines)

    androidMainImplementation(Deps.Libs.Android.appCompat)
    androidMainImplementation(Deps.Libs.Android.material)

    commonMainImplementation(Deps.Libs.MultiPlatform.mokoMvvmCore)
    commonMainApi(Deps.Libs.MultiPlatform.mokoResources)

    // temporary fix of https://youtrack.jetbrains.com/issue/KT-41083
    commonMainImplementation("dev.icerock.moko:parcelize:0.4.0")
    commonMainImplementation("dev.icerock.moko:graphics:0.4.0")
}

multiplatformResources {
    multiplatformResourcesPackage = "dev.icerock.moko.errors"
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
