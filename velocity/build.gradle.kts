plugins{
    id("smiley-conventions")
    id("com.gradleup.shadow") version "8.3.5"
}

dependencies{
    compileOnly(libs.velocity.api)
    implementation(libs.configurate.lib)
    api(project(":common"))
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar{
    archiveBaseName.set("smiley-velocity")
    archiveClassifier.set("")
    archiveVersion.set(version.toString())
    relocate("dev.dejvokep.boostedyaml", "it.pino.smiley.libs.boostedyaml")
    exclude("org/intellij/lang/annotations/**")
    exclude("org/jetbrains/annotations/**")
}