plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    js {
        outputModuleName = "pack-manager-core"
        browser()
        useEsModules()
        generateTypeScriptDefinitions()
        binaries.library()
    }

    mingwX64()
}

fun buildDir(path: String) = layout.buildDirectory.file(path).get().asFile
infix fun String.copyBuildTo(dest: String) = buildDir(this)
    .copyRecursively(buildDir(dest), overwrite = true)
tasks.named("jsBrowserDevelopmentLibraryDistribution") {
    doLast { "dist/js/developmentLibrary" copyBuildTo "dist/js/library" }
}
tasks.named("jsBrowserProductionLibraryDistribution") {
    doLast { "dist/js/productionLibrary" copyBuildTo "dist/js/library" }
}
