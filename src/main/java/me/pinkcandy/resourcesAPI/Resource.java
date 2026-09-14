package me.pinkcandy.resourcesAPI;

import java.io.File;

public class Resource {

    private final String name;
    private final String path;
    private File file;

    public Resource(String name, String path, File file) {
        this.name = name;
        this.path = path;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }
}

