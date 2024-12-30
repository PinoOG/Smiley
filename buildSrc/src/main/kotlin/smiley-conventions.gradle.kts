plugins {
    java
    `java-library`
}

group = "it.pino.smiley"
version = project.extra["smileyVersion"] as String

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
}


tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    withType<Javadoc> {
        options.encoding = "UTF-8"
    }
    processResources {
        val props = mapOf("version" to version)
        inputs.properties(props)
        filesMatching("plugin.yml") {
            expand(props)
        }
        filesMatching("velocity-plugin.json") {
            expand(props)
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}