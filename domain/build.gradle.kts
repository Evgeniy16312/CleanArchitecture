plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation("javax.inject:javax.inject:1")

   val defCoroutinesVersion = "1.6.0"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$defCoroutinesVersion")

    val defRetrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$defRetrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$defRetrofitVersion")
}