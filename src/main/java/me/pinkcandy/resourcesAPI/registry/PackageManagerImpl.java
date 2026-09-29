package me.pinkcandy.resourcesAPI.registry;

import me.pinkcandy.resourcesAPI.rpBuilder.BuildResourcePack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class PackageManagerImpl implements PackageManager {

    private final Map<String, PackageImpl> packages = new HashMap<>();

    @Override
    public Package createPackage(String name, JavaPlugin plugin) {
        if (packages.containsKey(name)) {
            throw new IllegalArgumentException(
                    "Package already exists: " + name
            );
        }

        PackageImpl pkg = new PackageImpl(name, plugin);
        packages.put(name, pkg);

        return pkg;
    }

    @Override
    public Package getPackage(String name) {
        return packages.get(name);
    }

    @Override
    public void buildPackage(String name) {
        PackageImpl pkg = packages.get(name);

        if (pkg == null) {
            throw new IllegalArgumentException(
                    "Package not found: " + name
            );
        }

        BuildResourcePack.BuildPackage(pkg);
    }
}
