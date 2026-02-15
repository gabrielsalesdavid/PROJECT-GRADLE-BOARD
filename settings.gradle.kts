plugins {
    id("java")
}

group = "br.com.projectgradleboard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentra()
}

dependencies {
    implementation("org.liquibase:liquibase-core:4.29.1")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("org.projectlombok:lombok:1.18.34")

    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.test {
    useJUnitPlatform()
}