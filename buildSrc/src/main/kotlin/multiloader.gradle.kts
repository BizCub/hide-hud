plugins {
    id("me.modmuss50.mod-publish-plugin")
    id("dev.kikugie.fletching-table")
    id("com.bizcub.multiloader")
}

multiloader {
    setMREnvironment(mrEnvs.clientOnly)
    setCFEnvironment(cfEnvs.client)

    if (isFabric) {
        addDependency(
            dependency = "net.fabricmc:fabric-loader:${getDep("fabric")}"
        )
    }
}
