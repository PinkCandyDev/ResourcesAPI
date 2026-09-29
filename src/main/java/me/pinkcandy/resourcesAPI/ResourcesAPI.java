package me.pinkcandy.resourcesAPI;

import me.pinkcandy.resourcesAPI.registry.PackageManager;
import me.pinkcandy.resourcesAPI.registry.PackageManagerImpl;
import me.pinkcandy.resourcesAPI.rpBuilder.BuildResourcePack;
import org.bukkit.plugin.java.JavaPlugin;



public final class ResourcesAPI extends JavaPlugin {

    private static ResourcesAPI instance;
    private PackageManager packageManager;

    @Override
    public void onEnable() {
        instance = this;
        packageManager = new PackageManagerImpl();

        TestResources testResources = new TestResources();
        BuildResourcePack.BuildResourcePack();
    }

    @Override
    public void onDisable() {

    }

    public static ResourcesAPI getInstance() {
        return instance;
    }

    public static PackageManager getPackageManager() {
        return instance.packageManager;
    }
}
