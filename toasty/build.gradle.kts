import io.grpc.internal.SharedResourceHolder.release

plugins {
    id("com.android.library")
    //TODO STEP 01
    id ("maven-publish")
}



android {
    namespace = "com.prabirkundu.toasty"
    compileSdk = 34

    defaultConfig {
        minSdk = 24


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        //TODO STEP 02
        aarMetadata {
            minCompileSdk = 29
        }

        //TODO STEP 03
        publishing {
            singleVariant("release") {
                withSourcesJar()
            }
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}


/*//Publish Library Locally
publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["release"])
            groupId = "com.github.Prabir-Kundu"
            artifactId = "Toasty"
            version = "1.0.0"
        }
    }
}*/

/*//Publish Library Locally
publishing {
    publications {
        release(MavenPublication) {
            group = "com.prabirkundu.toasty"
            artifacts = "toasty"
            //groupId = 'com.prabirkundu.toasty'
            //artifactId = 'dialog_x'
            version = "1.7"

            afterEvaluate {
                from components.release
            }
        }
    }
}*/


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.prabirkundu.toasty"
                artifactId = "Toasty"
                version = "1.0.3"
            }
        }
    }
}

/*afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.Prabir-Kundu"
                artifactId = "Toasty"
                version = "1.0.1"
            }
        }
    }
}*/
