package me.pinkcandy.resourcesAPI.registry;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface PackageManager {

    Package createPackage(String name, JavaPlugin plugin);

    @Nullable
    Package getPackage(String name);

    void buildPackage(String name);
}

