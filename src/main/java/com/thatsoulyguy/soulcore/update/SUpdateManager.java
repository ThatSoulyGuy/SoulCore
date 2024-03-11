package com.thatsoulyguy.soulcore.update;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SUpdateManager
{
    private static final Map<String, Runnable> updateCalls = new HashMap<>();

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