plugins {
  kotlin("jvm") version "1.5.31"
  kotlin("plugin.spring") version "1.5.31"
  id("org.springframework.boot") version "2.5.5"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  id("org.jmailen.kotlinter") version "3.0.2"
  jacoco
}

group = "com.example"
version = "0.0.1"

repositories {
  mavenCentral()
}

val javaVersion = "11"
tasks {
  compileKotlin {
    kotlinOptions.jvmTarget = javaVersion
  }
  compileTestKotlin {
    kotlinOptions.jvmTarget = javaVersion
  }
}

val kotestVersion = "4.1.3"

dependencies {
  //implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation(kotlin("stdlib-jdk8"))
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.2")
  testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
  testImplementation("io.kotest:kotest-runner-console-jvm:$kotestVersion")
  // health check
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("io.micrometer:micrometer-registry-prometheus")
  // OpenAPI
  implementation("org.springdoc:springdoc-openapi-ui:1.5.9")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

apply(plugin = "org.jmailen.kotlinter")
kotlinter {
  ignoreFailures = false
  indentSize = 4
}
