package ru.hse.sd.config;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigParser {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public Config parseConfig(String configFileName) {
        File file = new File(configFileName);
        Config config = null;
        try {
            config = objectMapper.readValue(file, Config.class);
        } catch (IOException e) {
            System.out.printf("Exception occurred: %s", e.getMessage());
        }
        return config;
    }
}
