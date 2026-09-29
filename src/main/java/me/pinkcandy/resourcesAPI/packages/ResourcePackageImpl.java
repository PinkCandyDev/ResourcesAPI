package me.pinkcandy.resourcesAPI.packages;

import me.pinkcandy.resourcesAPI.StreamToFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ResourcePackageImpl implements ResourcePackage {

    final String name;
    final JavaPlugin plugin;
    List<Resource> resources;

    public ResourcePackageImpl(String name, JavaPlugin plugin) {
        this.name = name;
        this.plugin = plugin;
        this.resources = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void insertFile(String name, String path, InputStream stream) {
        Resource resource = new Resource(name, name, StreamToFile.streamToFile(name, stream));
        resources.add(resource);
    }

    public void createItem(String name, InputStream stream) {

    }
}
