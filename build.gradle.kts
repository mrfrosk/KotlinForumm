import java.net.URI

allprojects {
	repositories {
		mavenCentral()
		google()
		mavenCentral()
		gradlePluginPortal()
		maven("https://maven.google.com/")
		maven("https://projects.itemis.de/nexus/content/repositories/mbeddr")
		maven("https://maven.atlassian.com/content/repositories/atlassian-public")
		maven {
			url = URI("http://repository.ops4j.org/maven2")
			isAllowInsecureProtocol = true
		}
		maven("https://jitpack.io")
	}
}

tasks.wrapper {
	gradleVersion = "7.4.2"
}

subprojects {
	configurations.all {
		resolutionStrategy {
			eachDependency {
				when (requested.group) {
					"org.jacoco" -> useVersion("0.8.7")
					"org.jetbrains.exposed" -> useVersion("0.38.1")
					"org.jetbrains.kotlin-wrappers" -> when (requested.name) {
						"kotlin-react-dom", "kotlin-react" -> useVersion("18.0.0-pre.328-kotlin-1.6.20")
						"kotlin-styled" -> useVersion("5.3.5-pre.328-kotlin-1.6.20")
						"kotlin-react-router-dom" -> useVersion("6.3.0-pre.328-kotlin-1.6.20")
						"kotlin-redux" -> useVersion("4.1.2-pre.328-kotlin-1.6.20")
						"kotlin-react-virtual" -> useVersion("2.10.4-pre.328-kotlin-1.6.20")
						"kotlin-mui" -> useVersion("5.5.3-pre.328-kotlin-1.6.20")
						"kotlin-mui-icons" -> useVersion("5.5.1-pre.328-kotlin-1.6.20")
						"kotlin-react-redux" -> useVersion("7.2.6-pre.328-kotlin-1.6.20")
					}
					"io.ktor" -> when (requested.name) {
						"ktor-client-core" -> useVersion("2.0.0")
						else -> useVersion("2.0.0")
					}
					"org.jetbrains.kotlinx" -> when (requested.name) {
						"kotlinx-serialization-json" -> useVersion("1.3.2")
						"kotlinx-datetime-jvm", "kotlinx-datetime" -> useVersion("0.3.2")
						"kotlinx-coroutines-core" -> useVersion("1.6.1")
						"kotlinx-coroutines-io" -> useVersion("0.24.0")
					}
					"org.postgresql" -> when (requested.name) {
						"postgresql" -> useVersion("42.3.3")
					}
					"org.junit.jupiter" -> useVersion("5.8.2")
					"ch.qos.logback" -> useVersion("1.2.11")
					"com.benasher44" -> when (requested.name) {
						"uuid" -> useVersion("0.4.0")
					}
				}
			}
		}
	}

}
