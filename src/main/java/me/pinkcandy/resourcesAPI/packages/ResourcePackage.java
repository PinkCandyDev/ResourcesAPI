package me.pinkcandy.resourcesAPI.packages;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.InputStream;
import java.util.List;

public interface ResourcePackage {

    public String getName();
    public List<Resource> getResources();
    public void insertFile(String name, String path, InputStream stream);
    public void createItem(String name, InputStream stream);
}
