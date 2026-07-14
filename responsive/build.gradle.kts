plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    `maven-publish`
}

android {
    namespace = "com.rite.responsivedp"
    compileSdk = 36

    defaultConfig {
        minSdk = 21

        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        compose = true
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)

    implementation(libs.androidx.annotation)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            // On JitPack the effective coordinate is derived from the repo:
            //   com.github.<org>.<repo>:responsive:<tag>
            // These values are used for local/other Maven publishing only.
            groupId = "com.rite.responsivedp"
            artifactId = "responsive"
            version = "1.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}