package me.pinkcandy.resourcesAPI;


import me.pinkcandy.resourcesAPI.packages.PackageManager;
import me.pinkcandy.resourcesAPI.packages.ResourcePackage;

public class TestResources {

    public TestResources() {
        PackageManager manager = ResourcesAPI.getInstance().getPackageManager();

        ResourcePackage pkg = manager.createPackage("resourcesapi", ResourcesAPI.getInstance());

        pkg.insertFile(
                "pack.png",
                "textures/item/pack.png",
                ResourcesAPI.getInstance().getResource("pack.png")
        );

        pkg.insertFile(
                "pack.json",
                "items/pack.json",
                ResourcesAPI.getInstance().getResource("items_pack.json")
        );

        pkg.insertFile(
                "pack.json",
                "models/item/pack.json",
                ResourcesAPI.getInstance().getResource("models_item_pack.json")
        );

        manager.buildPackage("resourcesapi");


    }
}
