import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.teamvoided.iridium.config.Config

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    id("org.teamvoided.iridium") version "2.2.3"
    id("iridium.mod.build-script") version "2.2.3"
}

group = project.properties["maven_group"]!!
version = project.properties["mod_version"]!!
base.archivesName.set(project.properties["archives_base_name"] as String)
description = "Scuffy"

repositories {
    mavenCentral()
        maven { url = uri("https://jitpack.io") }
}

modSettings {
    modId(base.archivesName.get())
    modName("ScuffedLib")

    entrypoint("main", "org.teamvoided.scuffedlib.ScuffedLib::commonInit")
    entrypoint("client", "org.teamvoided.scuffedlib.ScuffedLib::clientInit")
    mixinFile("scuffedlib.mixins.json")
    isModParent(true)
}

dependencies {
    mappings("org.quiltmc:quilt-mappings:${Config.mappings.version}:intermediary-v2")
}

tasks {
    val targetJavaVersion = 17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(targetJavaVersion)
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = targetJavaVersion.toString()
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(JavaVersion.toVersion(targetJavaVersion).toString()))
        withSourcesJar()
    }
}