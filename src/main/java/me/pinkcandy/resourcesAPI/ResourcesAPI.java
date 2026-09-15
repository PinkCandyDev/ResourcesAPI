package me.pinkcandy.resourcesAPI;

import me.pinkcandy.resourcesAPI.registry.PackageManager;
import me.pinkcandy.resourcesAPI.rpBuilder.BuildResourcePack;
import org.bukkit.plugin.java.JavaPlugin;



public final class ResourcesAPI extends JavaPlugin {

    public static ResourcesAPI instance;

    @Override
    public void onEnable() {
        instance = this;
        // Resources for testing

        PackageManager.createPackage("resourcesapi", instance);
        PackageManager.getPackage("resourcesapi").insertFile("pack.png", "textures/item/pack.png", instance.getResource("pack.png"));
        PackageManager.getPackage("resourcesapi").insertFile("pack.json", "items/pack.json", instance.getResource("items_pack.json"));
        PackageManager.getPackage("resourcesapi").insertFile("pack.json", "models/item/pack.json", instance.getResource("models_item_pack.json"));
        PackageManager.buildPackage("resourcesapi");

        BuildResourcePack.BuildResourcePack();
    }

    @Override
    public void onDisable() {

    }
}
