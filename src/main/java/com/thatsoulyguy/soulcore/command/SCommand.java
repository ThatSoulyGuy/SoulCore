package com.thatsoulyguy.soulcore.command;

import org.bukkit.entity.Player;

public abstract class SCommand
{
    public String name;

    public String description;

    public String syntax;

    public SCommand()
    {
        SCommandRegistration registration = Register();

        name = registration.name;
        description = registration.description;
        syntax = registration.syntax;
    }

    public abstract int Execute(Player player, String[] args);

    public abstract SCommandRegistration Register();
}