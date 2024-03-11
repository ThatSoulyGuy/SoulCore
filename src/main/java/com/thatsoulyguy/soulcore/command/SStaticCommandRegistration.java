package com.thatsoulyguy.soulcore.command;

import org.bukkit.plugin.java.JavaPlugin;

public class SStaticCommandRegistration
{
    public String name;

    public JavaPlugin plugin;

    public static SStaticCommandRegistration Register(String name, JavaPlugin plugin)
    {
        SStaticCommandRegistration out = new SStaticCommandRegistration();

        out.name = name;
        out.plugin = plugin;

        return out;
    }
}