plugins {
    java
    id("io.izzel.taboolib") version "1.56"
    id("org.jetbrains.kotlin.jvm") version "1.9.20-Beta2"
}

taboolib {
    description {
        contributors {
            name("Oveln")
        }
        desc("Elements")
    }
    install("common", "module-configuration")
    install("module-nms", "module-nms-util")
    install("module-ui")
    install("platform-bukkit")
    classifier = null
    version = "6.0.12-26"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("ink.ptms.core:v11701:11701:mapped")
    compileOnly("ink.ptms.core:v11701:11701:universal")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_17
}
