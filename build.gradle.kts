import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.9"
    application
}


javafx {
    version = "15.0.1"

    val list = mutableListOf("javafx.controls")
    val media = listOf("javafx.media")
    list.addAll(media)
    modules = list
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation ("org.json:json:20230227")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}