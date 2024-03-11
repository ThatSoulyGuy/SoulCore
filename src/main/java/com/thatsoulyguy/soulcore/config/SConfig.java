package com.thatsoulyguy.soulcore.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class SConfig
{
    private File configFile;
    private FileConfiguration config;
    private String path;
    private JavaPlugin plugin;

    public void Initialize(JavaPlugin plugin, String path)
    {
        this.plugin = plugin;
        this.path = path;

        configFile = new File(plugin.getDataFolder(), path);

        if (!configFile.exists())
        {
            configFile.getParentFile().mkdirs();
            plugin.saveResource(path, false);
        }

        config = new YamlConfiguration();

        try
        {
            config.load(configFile);
        }
        catch (IOException | InvalidConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    public void Reload()
    {
        configFile = new File(plugin.getDataFolder(), path);

        if (!configFile.exists())
        {
            configFile.getParentFile().mkdirs();
            plugin.saveResource(path, false);
        }

        config = new YamlConfiguration();

        try
        {
            config.load(configFile);
        }
        catch (IOException | InvalidConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    public void SetValue(String path, Object value)
    {
        config.set(path, value);
        Save();
    }

    public Object GetValue(String path)
    {
        return config.get(path);
    }

    public void Save()
    {
        try
        {
            config.save(configFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}