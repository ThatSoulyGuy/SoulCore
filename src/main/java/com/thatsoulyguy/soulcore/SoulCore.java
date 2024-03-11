package com.thatsoulyguy.soulcore;

import com.thatsoulyguy.soulcore.update.SUpdateManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class SoulCore extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for(Runnable call : SUpdateManager.GetUpdateCalls())
                    call.run();
            }
        }.runTaskTimer(this, 0L, 20L);
    }

    @Override
    public void onDisable()
    {

    }
}
