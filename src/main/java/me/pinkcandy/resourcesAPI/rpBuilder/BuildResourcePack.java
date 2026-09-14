package me.pinkcandy.resourcesAPI.rpBuilder;

import me.pinkcandy.resourcesAPI.Resource;
import me.pinkcandy.resourcesAPI.ResourcesAPI;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BuildResourcePack {

    public static void BuildResourcePack(List<Resource> resources){
        Path mainPackFolder = ResourcesAPI.instance.getDataFolder().toPath().resolve("pack/assets/minecraft");
        try{
            Files.createDirectories(mainPackFolder);
            Files.copy(ResourcesAPI.instance.getResource("pack.png"), ResourcesAPI.instance.getDataFolder().toPath().resolve("pack/pack.png"));
            Files.createFile(ResourcesAPI.instance.getDataFolder().toPath().resolve("pack/pack.mcmeta"));
            Files.writeString(ResourcesAPI.instance.getDataFolder().toPath().resolve("pack/pack.mcmeta"), "{\n" +
                    "  \"pack\": {\n" +
                    "    \"pack_format\": 107.1,\n" +
                    "    \"description\": \"ResourcesAPI resources\"\n" +
                    "  }\n" +
                    "}\n");
            Files.createDirectories(mainPackFolder.resolve("textures/item"));
            Files.createDirectories(mainPackFolder.resolve("textures/block"));
            Files.createDirectories(mainPackFolder.resolve("sounds"));
            Files.createDirectories(mainPackFolder.resolve("models/item"));
            Files.createDirectories(mainPackFolder.resolve("items"));

            for (Resource resource : resources) {
                Path resourcePath = mainPackFolder.resolve(resource.getPath());
                Files.createDirectories(resourcePath.getParent());
                Files.copy(resource.getFile().toPath(), resourcePath);
            }

            ZipUtil.pack(new File(ResourcesAPI.instance.getDataFolder(), "pack"), new File(ResourcesAPI.instance.getDataFolder(), "resourcesAPI.zip"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
