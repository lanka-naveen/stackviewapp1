android {
    compileSdk = 34
    buildToolsVersion = "34.0.0"
    namespace = "com.example.stackviewapp"
    defaultConfig {
        applicationId = "com.example.stackviewapp"
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}
