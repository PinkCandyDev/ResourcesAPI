package me.pinkcandy.resourcesAPI;

import me.pinkcandy.resourcesAPI.registry.PackageManager;
import me.pinkcandy.resourcesAPI.registry.Package;
import me.pinkcandy.resourcesAPI.registry.Resource;

public class TestResources {

    public TestResources() {
        PackageManager manager = ResourcesAPI.getInstance().getPackageManager();

        Package pkg = manager.createPackage("resourcesapi", ResourcesAPI.getInstance());

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
