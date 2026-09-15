package me.pinkcandy.resourcesAPI.registry;

import me.pinkcandy.resourcesAPI.rpBuilder.BuildResourcePack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jspecify.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageManager {

    public static Map<String, Package> packages = new HashMap<>();


    public static void createPackage(String name, JavaPlugin plugin) {
        Package pkg = new Package(name, plugin);
        packages.put(name, pkg);
    }

    public static Package getPackage(String name) {
        return packages.get(name);
    }

    public static void buildPackage(String name) {
        Package pkg = packages.get(name);
        if (pkg == null) {
            throw new IllegalArgumentException("Package not found: " + name);
        }
        BuildResourcePack.BuildPackage(pkg);
    }
}
