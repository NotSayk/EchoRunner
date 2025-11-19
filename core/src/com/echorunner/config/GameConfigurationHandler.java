package com.echorunner.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GameConfigurationHandler
{
    private static final Properties config = new Properties();

    private GameConfigurationHandler() {}

    public static final Object getInfo( String elt )
    {
        return GameConfigurationHandler.config.get( elt );
    }

    public static void setInfo( String elt, String value )
    {
        GameConfigurationHandler.config.setProperty(elt, value);
    }

    public static void createConfigFile()
    {
        
    }

    public static final void save() throws FileNotFoundException, IOException
    {
        GameConfigurationHandler.config.store(new FileOutputStream(Constants.ROOT_FOLDER + Constants.CONFIG_FILE_NAME) , "Config file");
    }

    public static final void load() throws FileNotFoundException, IOException
    {
        GameConfigurationHandler.config.load(new FileInputStream(Constants.ROOT_FOLDER + Constants.CONFIG_FILE_NAME));
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