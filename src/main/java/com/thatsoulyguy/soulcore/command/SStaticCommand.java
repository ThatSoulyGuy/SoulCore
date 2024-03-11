package com.thatsoulyguy.soulcore.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class SStaticCommand implements CommandExecutor
{
    public String name;

    public JavaPlugin plugin;

    public SStaticCommand()
    {
        SStaticCommandRegistration registration = Register();

        name = registration.name;
        plugin = registration.plugin;

        Objects.requireNonNull(plugin.getCommand(name)).setExecutor(this);
    }

    public abstract int Execute(Player player, String[] arguments);

    public abstract SStaticCommandRegistration Register();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args)
    {
        int result = Execute((Player) sender, args);

        if(result != 0)
            sender.sendMessage(ChatColor.RED + "Command '" + name + "' failed with exit code: '" + result + "'");

        return true;
    }
}