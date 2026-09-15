package me.pinkcandy.resourcesAPI.registry;

import org.bukkit.plugin.java.JavaPlugin;
import org.jspecify.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Package {

    final String name;
    final JavaPlugin plugin;
    List<Resource> resources;

    public Package(String name, JavaPlugin plugin) {
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

    public void insertFile(String name, String path, @Nullable InputStream stream) {
        if (stream == null) {
            throw new IllegalArgumentException("Resource stream is null");
        }

        try {
            File file = File.createTempFile(name, null);

            try (InputStream input = stream) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            Resource resource = new Resource(name, path, file);
            resources.add(resource);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
