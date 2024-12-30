plugins{
    id("smiley-conventions")
}

dependencies{
    compileOnlyApi(libs.configurate.lib)
}
java {
    withSourcesJar()
    withJavadocJar()
}