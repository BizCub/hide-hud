plugins {
    id("io.github.bizcub.multiloader")
}

multiloader {
    setMREnvironment(mrEnvs.clientOnly)
    setCFEnvironment(cfEnvs.client)

    versionRange("26.2", to = "latest")
    versionRange("1.21.1", to = "1.21.11")
    versionRange("1.21.1", from = "1.20.6", loader = "forge")
    versionRange("1.20.1", to = "1.21.11")
    versionRange("1.20.1", to = "1.20.4", loader = "forge")

    if (isFabric) {
        addDependency(
            dependency = "net.fabricmc:fabric-loader:${getDep("fabric")}"
        )
    }
}
