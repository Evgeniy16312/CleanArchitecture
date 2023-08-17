plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

}

android {
    namespace = "com.example.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation(project(mapOf("path" to ":domain")))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val defCoroutinesVersion = "1.6.0"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$defCoroutinesVersion")


    val defRetrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$defRetrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$defRetrofitVersion")

    implementation("javax.inject:javax.inject:1")

    //Dagger2
    implementation("com.google.dagger:dagger:2.46.1")
    implementation("com.google.dagger:dagger-android-support:2.46.1")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.46.1")

}