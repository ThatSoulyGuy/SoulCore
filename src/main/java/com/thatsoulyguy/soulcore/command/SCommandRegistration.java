package com.thatsoulyguy.soulcore.command;

public class SCommandRegistration
{
    public String name;
    public String description;
    public String syntax;

    public static SCommandRegistration Register(String name, String description, String syntax)
    {
        SCommandRegistration out = new SCommandRegistration();

        out.name = name;
        out.description = description;
        out.syntax = syntax;

        return out;
    }
}