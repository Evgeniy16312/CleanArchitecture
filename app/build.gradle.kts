plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.cleanarchitecture"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.cleanarchitecture"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val navigationComponentsVersion = System.getProperty("navigationComponentsVersion")
    //Dagger2
    implementation("com.google.dagger:dagger:2.46.1")
    implementation("com.google.dagger:dagger-android-support:2.46.1")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.46.1")
    kapt ("com.google.dagger:dagger-compiler:2.46.1")
    implementation("javax.inject:javax.inject:1")

    //Подключение архитектурных модулей
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))


    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationComponentsVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationComponentsVersion")

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}