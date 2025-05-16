plugins {
    alias(libs.plugins.node.gradle)
}

val buildCoreTask = project(":" + projects.core.name)
    .tasks
    .named("jsBrowserProductionLibraryDistribution")

tasks.named("npmInstall") {
    dependsOn(buildCoreTask)
}
tasks.register("build") {
    group = "npm"
    dependsOn("npm_run_build")
}
