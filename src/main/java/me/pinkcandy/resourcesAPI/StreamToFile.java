package me.pinkcandy.resourcesAPI;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class StreamToFile {
    public static File streamToFile(String name, InputStream inputStream) {
        try {
            File file = File.createTempFile(name, null);

            try (InputStream input = inputStream) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            return file;
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to create temp file: " + name, e);
        }
    }

}
