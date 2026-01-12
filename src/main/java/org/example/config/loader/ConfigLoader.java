package org.example.config.loader;

public class ConfigLoader {
    private static final ConfigLoader instance = new ConfigLoader();
    private final String configFile;

    private ConfigLoader(){

    }

    public static ConfigLoader getInstance(){
        return instance;
    }
}
