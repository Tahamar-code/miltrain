plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.3"
    id("java")
}

group = "com.miltrain"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // SpringBoot
    implementation("org.springframework.boot:spring-boot-starter-web")

    //JUnit
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    //Lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")


    // Slf4j logging
    implementation("org.slf4j:slf4j-api:2.0.11")
}

tasks.test {
    useJUnitPlatform()
}