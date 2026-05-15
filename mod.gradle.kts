import com.bizcub.multiloader.MultiLoader

apply(plugin = "dev.kikugie.fletching-table")

project.extensions.configure<MultiLoader>("multiloader") {
    access()

    if (isFabric) {
        addDependency("implementation", "net.fabricmc:fabric-loader:${getDep("fabric")}")
    }
}
