plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp.gradle)
    alias(libs.plugins.hilt.gradle)
}

android {
    namespace = "com.example.appplaceholder_v20"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.appplaceholder_v20"
        minSdk = 26
        targetSdk = 36
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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)




    // Inyección de dependencias con Hilt usando KSP
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // 🌐 El motor principal de Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

    // 📑 Conversor de texto plano para capturar el String gigante del RSS
    implementation("com.squareup.retrofit2:converter-scalars:2.11.0")

    // 🌟 Conversor de Retrofit para usar GSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}