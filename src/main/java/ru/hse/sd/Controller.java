package ru.hse.sd;

import org.apache.commons.cli.*;
import ru.hse.sd.config.Config;
import ru.hse.sd.config.ConfigParser;

import java.io.IOException;
public class Controller {

    public static void main(String[] args) throws IOException {
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

        String configFileName = cmd.getOptionValue("config-file");
        Config config = configFileName == null ? ConfigParser.fromResources() : ConfigParser.fromFile(configFileName);

        Game game = new Game(config);

        while (!game.isFinished()) {
            // parse input ...
            game.processMove();
        }
    }
}
