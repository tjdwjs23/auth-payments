import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.0"
    kotlin("kapt") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
    kotlin("plugin.jpa") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
}

tasks.jar { enabled = false }

group = "demo"
version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17


repositories {
    mavenCentral()
}

dependencies {
    // Spring Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Spring Data
    val queryDslVersion = dependencyManagement.importedProperties["querydsl.version"]
    implementation("com.querydsl:querydsl-jpa:$queryDslVersion:jakarta")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    kapt("com.querydsl:querydsl-apt:$queryDslVersion:jakarta")

    // Validator
    implementation("org.hibernate.validator:hibernate-validator:7.0.2.Final")
    implementation("jakarta.validation:jakarta.validation-api:3.0.1")

    // Kotlin Logging
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.1")

    // Test
    testImplementation("org.mockito:mockito-core:5.11.0")
    testImplementation("org.amshove.kluent:kluent:1.73")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}