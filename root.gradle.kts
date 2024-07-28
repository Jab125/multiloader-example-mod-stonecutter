plugins {
    kotlin("jvm") version "${E.p["kotlin_version"]}" apply false
    id("dev.architectury.loom") version "${E.p["architectury_loom_version"]}" apply false
    id("com.jab125.preprocessor.preprocess") version "${E.p["preprocessor_version"]}"
}

val packageJar by tasks.creating(Copy::class) {
    into("${layout.buildDirectory}/libs/")
}


preprocess {
    val fabric = createNode("fabric", 0, "")
    E.p["enabled_platforms"].toString().split(",").stream().filter { it != "fabric" }.forEach {
        createNode(it, 0, "").link(fabric)
    }
}

subprojects {
    project.extra["modLoaderParser"] = javaslang.Function1<String, Int> {
        val loaders = HashMap<String, Int>()
        loaders["NEOFORGE"] = -2
        loaders["FORGE"] = -1
        loaders["FABRIC"] = 1
        loaders["QUILT"] = 2

        loaders[it]
    }
    project.extra["minecraftVersionParser"] = javaslang.Function1<String, Int?> { string ->
        if (string == null) return@Function1 null
        var splat : List<String> = string.split(".")
        if (splat.size == 2) { // 1.19 -> 1.19.0
            splat = List(3) { x -> if (x <= 1) splat[x] else "0" }
        }
        val versionStr : StringBuilder = StringBuilder()
        splat.forEach {
            versionStr.append(it.padStart(2, '0'))
        }
        versionStr.toString().toInt()
    }
    afterEvaluate {
        tasks.getByName("build").dependsOn(packageJar)
    }
}