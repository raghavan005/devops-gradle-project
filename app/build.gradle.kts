plugins {
    application
    `maven-publish`
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guava)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("6.0.1")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.App"
}

/* 🔥 THIS IS THE IMPORTANT PART */
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("http://192.168.56.1:8081/repository/maven-releases/")
            credentials {
                username = "admin"
                password = "PASTE_YOUR_PASSWORD_HERE"
            }
        }
    }
}
