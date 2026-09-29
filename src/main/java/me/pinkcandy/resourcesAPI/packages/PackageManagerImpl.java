package me.pinkcandy.resourcesAPI.packages;

import me.pinkcandy.resourcesAPI.rpBuilder.BuildResourcePack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class PackageManagerImpl implements PackageManager {

    private final Map<String, ResourcePackageImpl> packages = new HashMap<>();

    @Override
    public ResourcePackage createPackage(String name, JavaPlugin plugin) {
        if (packages.containsKey(name)) {
            throw new IllegalArgumentException(
                    "Package already exists: " + name
            );
        }

        ResourcePackageImpl pkg = new ResourcePackageImpl(name, plugin);
        packages.put(name, pkg);

        return pkg;
    }

    @Override
    public ResourcePackage getPackage(String name) {
        return packages.get(name);
    }

    @Override
    public void buildPackage(String name) {
        ResourcePackageImpl pkg = packages.get(name);

        if (pkg == null) {
            throw new IllegalArgumentException(
                    "Package not found: " + name
            );
        }

        BuildResourcePack.BuildPackage(pkg);
    }
}
