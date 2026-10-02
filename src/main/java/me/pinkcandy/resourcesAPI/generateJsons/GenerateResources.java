package me.pinkcandy.resourcesAPI.generateJsons;

import me.pinkcandy.resourcesAPI.StreamToFile;
import me.pinkcandy.resourcesAPI.generateJsons.Items.Items;
import me.pinkcandy.resourcesAPI.generateJsons.models.item.ItemModel;
import me.pinkcandy.resourcesAPI.packages.Resource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GenerateResources {
    public static List<Resource> generateResourcesForItemFromTexture(String name, InputStream textureStream, String packageName) {
        List<Resource> resources = new ArrayList<>();
        resources.add(new Resource(name + ".png", "textures/item/" + name + ".png", StreamToFile.streamToFile(name + ".png", textureStream)));
        resources.add(Items.generateItemsForModel(name, packageName));
        resources.add(ItemModel.generateModelForItem(name, packageName));
        return resources;
    }
}
