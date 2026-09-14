package me.pinkcandy.resourcesAPI;

import me.pinkcandy.resourcesAPI.rpBuilder.BuildResourcePack;
import org.bukkit.plugin.java.JavaPlugin;



public final class ResourcesAPI extends JavaPlugin {

    public static ResourcesAPI instance;

    @Override
    public void onEnable() {
        instance = this;
        // Resources for testing
        Registry.registerResource("pack.png", "textures/item/pack.png",instance.getResource("pack.png"));
        Registry.registerResource("pack.json", "items/pack.json", instance.getResource("items_pack.json"));
        Registry.registerResource("pack.json", "models/item/pack.json", instance.getResource("models_item_pack.json"));
        BuildResourcePack.BuildResourcePack(Registry.resources);
    }

    @Override
    public void onDisable() {

    }
}
