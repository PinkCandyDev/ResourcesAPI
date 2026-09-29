package me.pinkcandy.resourcesAPI.rpBuilder;

import me.pinkcandy.resourcesAPI.packages.ResourcePackageImpl;
import me.pinkcandy.resourcesAPI.packages.Resource;
import me.pinkcandy.resourcesAPI.ResourcesAPI;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class BuildResourcePack {

    public static void BuildPackage(ResourcePackageImpl pkg){
        Path mainPackFolder = ResourcesAPI.getInstance().getDataFolder().toPath().resolve("pack/assets/" + pkg.getName());
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
            Files.copy(ResourcesAPI.getInstance().getResource("pack.png"), ResourcesAPI.getInstance().getDataFolder().toPath().resolve("pack/pack.png"));
            Files.createFile(ResourcesAPI.getInstance().getDataFolder().toPath().resolve("pack/pack.mcmeta"));
            Files.writeString(ResourcesAPI.getInstance().getDataFolder().toPath().resolve("pack/pack.mcmeta"), "{\n" +
                    "  \"pack\": {\n" +
                    "    \"pack_format\": 107.1,\n" +
                    "    \"description\": \"ResourcesAPI resources\"\n" +
                    "  }\n" +
                    "}\n");
            ZipUtil.pack(new File(ResourcesAPI.getInstance().getDataFolder(), "pack"), new File(ResourcesAPI.getInstance().getDataFolder(), "resourcesAPI.zip"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
