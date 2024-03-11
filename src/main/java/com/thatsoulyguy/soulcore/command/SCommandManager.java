package com.thatsoulyguy.soulcore.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SCommandManager implements CommandExecutor
{
    public static Map<String, SCommand> registeredCommands = new HashMap<>();

    public static void Initialize(JavaPlugin plugin, String name)
    {
        Objects.requireNonNull(plugin.getCommand(name)).setExecutor(new SCommandManager());
    }

    public static void Register(SCommand command)
    {
        registeredCommands.put(command.name, command);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command alias, @NotNull String label, @NotNull String[] args)
    {
        if(!sender.isOp())
        {
            sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.", "Code: '-1'");
            return false;
        }

        if(sender instanceof Player)
        {
            Player executor = (Player) sender;

            if (args.length > 0)
            {
                for(SCommand command : registeredCommands.values())
                {
                    if(args[0].equalsIgnoreCase(command.name))
                    {
                        String[] argsCopy = new String[args.length - 1];
                        System.arraycopy(args, 1, argsCopy, 0, args.length - 1);

                        int result = command.Execute(executor, argsCopy);

                        if(result != 0)
                            sender.sendMessage(ChatColor.RED + "Sub Command: '" + command.name + "' failed with code: '" + result + "'.");
                    }
                }
            }
            else
            {
                sender.sendMessage(ChatColor.YELLOW + "---------------------------");

                for(SCommand command : registeredCommands.values())
                    sender.sendMessage( ChatColor.GREEN + command.name + " - " + command.syntax + ", " + command.description);

                sender.sendMessage(ChatColor.YELLOW + "---------------------------");

                return true;
            }
        }
        else
        {
            sender.sendMessage(ChatColor.DARK_RED + "You must be a player to execute this command.", "Code: '-2'");
            return false;
        }

        return true;
    }
}