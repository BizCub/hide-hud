plugins {
    id("multiloader-common")
}

reps.clear()
deps.clear()

if (isFabric) {
    deps.add(Dependency("net.fabricmc:fabric-loader:latest.release", "implementation"))
}

if (isNeoForge) {
    reps.add(Repository("https://maven.neoforged.net/releases"))
}
