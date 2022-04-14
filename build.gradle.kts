
plugins {
    kotlin("jvm") version "1.6.0"
    id("org.jetbrains.kotlin.jupyter.api") version "0.11.0-1"
    `maven-publish`
}

group = "com.andreikingsley"
version = "test-datalore-1.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")
}


tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.andreikingsley"
            artifactId = "test"
            version = "test-datalore-1.1"

            from(components["java"])
        }
    }
}

