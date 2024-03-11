package com.thatsoulyguy.soulcore.update;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SUpdateManager
{
    private static final Map<String, Runnable> updateCalls = new HashMap<>();

    public static void Initialize(JavaPlugin plugin, int frequency)
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for(Runnable call : SUpdateManager.GetUpdateCalls())
                    call.run();
            }
        }.runTaskTimer(plugin, 0L, frequency);
    }

    public static void Register(String id, Runnable function)
    {
        updateCalls.put(id, function);
    }

    public static void UnRegister(String id)
    {
        updateCalls.remove(id);
    }

    public static Collection<Runnable> GetUpdateCalls()
    {
        return updateCalls.values();
    }
}