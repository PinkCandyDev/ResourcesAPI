package me.pinkcandy.resourcesAPI.registry;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.InputStream;
import java.util.List;

public interface Package {

    public String getName();
    public List<Resource> getResources();
    public void insertFile(String name, String path, @Nullable InputStream stream);
}
