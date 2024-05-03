package ru.hse.sd;

import org.apache.commons.cli.*;
import ru.hse.sd.config.Config;
import ru.hse.sd.config.ConfigParser;

public class Controller {
    private static final String defaultConfig = "src/main/java/ru/hse/sd/config/defaultCfg/GameConfig.json";

    public static void main(String[] args) {
        Options options = new Options();

        Option configOption = new Option("cf", "config-file", true, "config file path");

        options.addOption(configOption);
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.printf("Exception occurred: %s", e.getMessage());
            System.exit(1);
        }

        String configFileName = cmd.getOptionValue("config-file", defaultConfig);
        ConfigParser configParser = new ConfigParser();
        Config config = configParser.parseConfig(configFileName);
    }
}
