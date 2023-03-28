rootProject.name = "example-app-1"

include("common")
project(":common").projectDir = rootDir.resolve("common")
include("backend")
project(":backend").projectDir = rootDir.resolve("backend")
include("frontend")
project(":frontend").projectDir = rootDir.resolve("frontend")




pluginManagement {
	buildscript {
		repositories {
			mavenCentral()
			google()
			maven { url = uri("https://plugins.gradle.org/m2") }
		}
	}
	val kotlinVersion: String by settings
	val orgSpringframeworkBootVersion: String by settings
	println("Версия библиотеки spring.boot $orgSpringframeworkBootVersion")
	val ioSpringDependencyManagementVersion: String by settings
	println("Версия менеджера зависимостей библиотеки spring.boot $ioSpringDependencyManagementVersion")
	plugins {
		application apply false
		kotlin("jvm") version kotlinVersion apply false
		kotlin("js") version kotlinVersion apply false
		kotlin("multiplatform") version kotlinVersion apply false
		kotlin("plugin.serialization") version kotlinVersion apply false
		kotlin("plugin.spring") version kotlinVersion apply false
		id("org.springframework.boot") version orgSpringframeworkBootVersion apply false
		id("io.spring.dependency-management") version ioSpringDependencyManagementVersion apply false
		distribution apply false
	}
}