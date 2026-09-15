package me.pinkcandy.resourcesAPI.rpBuilder;

import me.pinkcandy.resourcesAPI.registry.Package;
import me.pinkcandy.resourcesAPI.registry.Resource;
import me.pinkcandy.resourcesAPI.ResourcesAPI;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BuildResourcePack {

    public static void BuildPackage(Package pkg){
        Path mainPackFolder = ResourcesAPI.instance.getDataFolder().toPath().resolve("pack/assets/" + pkg.getName());
        try {
            Files.createDirectories(mainPackFolder);
            Files.createDirectories(mainPackFolder.resolve("textures/item"));
            Files.createDirectories(mainPackFolder.resolve("textures/block"));
            Files.createDirectories(mainPackFolder.resolve("sounds"));
            Files.createDirectories(mainPackFolder.resolve("models/item"));
            Files.createDirectories(mainPackFolder.resolve("items"));

            for (Resource resource : pkg.getResources()) {
                Path resourcePath = mainPackFolder.resolve(resource.getPath());
                Files.createDirectories(resourcePath.getParent());
                Files.copy(resource.getFile().toPath(), resourcePath);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void BuildResourcePack(){
        try {
            Files.copy(ResourcesAPI.instance.getResource("pack.png"), ResourcesAPI.instance.getDataFolder().toPath().resolve("pack/pack.png"));
            Files.createFile(ResourcesAPI.instance.getDataFolder().toPath().resolve("pack/pack.mcmeta"));
            Files.writeString(ResourcesAPI.instance.getDataFolder().toPath().resolve("pack/pack.mcmeta"), "{\n" +
                    "  \"pack\": {\n" +
                    "    \"pack_format\": 107.1,\n" +
                    "    \"description\": \"ResourcesAPI resources\"\n" +
                    "  }\n" +
                    "}\n");
            ZipUtil.pack(new File(ResourcesAPI.instance.getDataFolder(), "pack"), new File(ResourcesAPI.instance.getDataFolder(), "resourcesAPI.zip"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
