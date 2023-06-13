plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.26")
    implementation("org.testng:testng:7.1.0")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation(platform("org.junit:junit-bom:5.8.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured:4.3.0")
    testImplementation("com.github.javafaker:javafaker:1.0.1")
    testImplementation("com.puppycrawl.tools:checkstyle:8.44")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.6.2")
    implementation ("org.codehaus.jackson:jackson-mapper-asl:1.9.13")
    compileOnly ("org.projectlombok:lombok:1.18.20")
    testImplementation ("org.projectlombok:lombok:1.18.12")
    implementation ("io.rest-assured:json-schema-validator:4.3.1")
    implementation ("io.rest-assured:rest-assured:4.2.0")
}

tasks.test {
    useJUnitPlatform()
}