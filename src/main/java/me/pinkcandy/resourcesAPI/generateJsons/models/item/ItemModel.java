package me.pinkcandy.resourcesAPI.generateJsons.models.item;

import me.pinkcandy.resourcesAPI.ResourcesAPI;
import me.pinkcandy.resourcesAPI.packages.Resource;

import java.io.File;
import java.io.FileWriter;

public class ItemModel {
    public static Resource generateModelForItem(String name, String packageName) {
        try {
            File file = new File(ResourcesAPI.getInstance().getDataPath().toFile(), name + ".json");
            FileWriter writer = new FileWriter(file);
            writer.write(
                    "{\n" +
                            "  \"parent\": \"minecraft:item/generated\",\n" +
                            "  \"textures\": {\n" +
                            "    \"layer0\": \"" + packageName +":item/" + name + "\"\n" +
                            "  }\n" +
                            "}\n"
            );
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Resource resource = new Resource(name + ".json", "models/item/" + name + ".json", new File(ResourcesAPI.getInstance().getDataPath().toFile(), name + ".json"));
        return resource;
    }
}
