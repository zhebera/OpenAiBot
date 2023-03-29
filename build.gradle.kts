plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")

    //OpenAI libraries
    implementation("com.aallam.openai:openai-client:3.2.0")
    implementation("io.ktor:ktor-client-apache:2.2.4")

    // see https://github.com/pengrad/java-telegram-bot-api
    implementation("com.github.pengrad:java-telegram-bot-api:6.5.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}