package me.pinkcandy.resourcesAPI.packages;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface PackageManager {

    ResourcePackage createPackage(String name, JavaPlugin plugin);

    @Nullable
    ResourcePackage getPackage(String name);

    void buildPackage(String name);
}

