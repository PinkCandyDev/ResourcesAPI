package me.pinkcandy.resourcesAPI;

import org.jspecify.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static me.pinkcandy.resourcesAPI.ResourcesAPI.instance;

public class Registry {

    static List<Resource> resources = new ArrayList<>();

    public static void registerResource(String name, String path, @Nullable InputStream stream) {
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
