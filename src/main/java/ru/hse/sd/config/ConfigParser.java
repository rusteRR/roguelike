package ru.hse.sd.config;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ConfigParser {
    private static final String defaultConfig = "GameConfig.json";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static Config fromResources() {
        URL configURL = ClassLoader.getSystemResource(defaultConfig);
        Config config = null;
        try {
            config = objectMapper.readValue(configURL, Config.class);
        } catch (IOException e) {
            System.out.printf("Exception occurred: %s", e.getMessage());
        }
        return config;
    }

    public static Config fromFile(String filename) throws IOException {
        File file = new File(filename);
        return objectMapper.readValue(file, Config.class);
    }
}
