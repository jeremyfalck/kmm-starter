plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //Coroutines
            implementation(libs.kotlinx.coroutines.core)

            //Ktor
            implementation(libs.ktor.client.core)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.core.coroutines)
            implementation(libs.koin.test)

            //Logging
            implementation(libs.kermit)

        }
        commonTest.dependencies {
            //Kotest
            implementation(libs.kotest)
            implementation(libs.kotest.framework.engine)
            implementation(libs.kotest.assertions.core)
            implementation(libs.kotest.property)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.jfalck.kmmstarter"
    compileSdk = 34
    defaultConfig {
        minSdk = 23
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
