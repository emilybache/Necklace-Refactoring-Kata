import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.6.20"
}

group = "org.sammancoaching.necklace"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test-junit5"))
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

  testImplementation("com.approvaltests:approvaltests:15.1.1")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}
