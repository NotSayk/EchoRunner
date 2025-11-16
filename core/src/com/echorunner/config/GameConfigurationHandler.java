package com.echorunner.config;

import java.util.Properties;

public class GameConfigurationHandler
{
    private static final Properties config = new Properties();

    private GameConfigurationHandler() {}

    public static final Object getInfo()
    {
        return null;
    }

    public static void setInfo()
    {

    }

    public static void createConfigFile()
    {

    }

    public static final void save()
    {

    }

    public static final void load()
    {

    }

    /*
     * Emplacement Root (Constantes)
     * résolution, touches, parametres ...
    */
        // Find file => retrive infos => cache
        // |
        // +-> if not found => create new file with default parameters (also launch in safe mode)
        // getInfo <= cached infos
        // setInfo
        // save
}