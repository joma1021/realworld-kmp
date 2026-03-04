import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.composeMultiplatform)
  alias(libs.plugins.composeCompiler)
}

kotlin {
  androidTarget {
    compilerOptions {
      jvmTarget.set(JvmTarget.JVM_11)
    }
  }

  listOf(
    iosArm64(),
    iosSimulatorArm64()
  ).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "ComposeApp"
      isStatic = true
    }
  }

  js {
    browser()
    binaries.executable()
  }


  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    browser()
    binaries.executable()
  }

  sourceSets {
    androidMain.dependencies {
      implementation(libs.ui.tooling.preview)
      implementation(libs.androidx.activity.compose)
    }
    commonMain.dependencies {
      implementation(libs.runtime)
      implementation(libs.foundation)
      implementation(libs.material3)
      implementation(libs.ui)
      implementation(libs.ui.tooling.preview) // Renamed from compose.uiTooling.preview
      implementation(libs.androidx.lifecycle.viewmodelCompose)
      implementation(libs.androidx.lifecycle.runtimeCompose)
      implementation(libs.kotlinx.datetime)
      implementation(libs.material.icons.extended)
      implementation(libs.navigation.compose)
      implementation(libs.components.resources)
    }
    commonTest.dependencies {
      implementation(libs.kotlin.test)
    }
    webMain.dependencies {
      implementation(npm("@js-joda/timezone", "2.22.0"))

    }
  }
}

android {
  namespace = "com.example.realworld_kmp"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  defaultConfig {
    applicationId = "com.example.realworld_kmp"
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()
    versionCode = 1
    versionName = "1.0"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
}

dependencies {
  debugImplementation(libs.ui.tooling)
}

