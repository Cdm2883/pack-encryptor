plugins {
    alias(libs.plugins.node.gradle)
}

val buildCoreTask = project(":" + projects.core.name)
    .tasks
    .named("jsBrowserProductionLibraryDistribution")

tasks.register("build") {
    group = "npm"
    dependsOn(buildCoreTask, "npm_run_build")
}
