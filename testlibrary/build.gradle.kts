@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    `maven-publish`
}

android {
    namespace = "com.custom.testlibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    setPublishNonDefault(true)
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

//group = ""
//version = ""

afterEvaluate {

    publishing {
        publications {
//            val sdkGroupId = "com.github.kalevan"
//            val sdkArtifactId = "testlibrary"

            create<MavenPublication>("debug") {
//                groupId = sdkGroupId
//                artifactId = sdkArtifactId
//                version = "0.0.1-debug"


                from(components["debug"])
//                artifact("${layout.buildDirectory}/outputs/aar/testlibrary-debug.aar")
            }
            create<MavenPublication>("release") {
                from(components["release"])
            }
        }
    }
}
