import org.gradle.kotlin.dsl.androidTestImplementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.jason_portfolio"
    compileSdk =37


    defaultConfig {
        applicationId = "com.example.jason_portfolio"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation("androidx.navigation:navigation-compose:2.9.8")
    implementation(libs.androidx.ui.test.junit4)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:5.11.0")
    implementation(platform("androidx.compose:compose-bom:2024.10.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.10.00"))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")


}
