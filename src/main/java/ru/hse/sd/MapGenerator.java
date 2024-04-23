package ru.hse.sd;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;

import java.io.IOException;

public class MapGenerator {
    public static void generate() {
        try {
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
            TerminalScreen screen = terminalFactory.createScreen();
            screen.startScreen();

            // Panel to hold the components
            Panel mainPanel = new Panel();
            mainPanel.setLayoutManager(new GridLayout(3));

            Panel mapPanel = new Panel();
            mapPanel.setLayoutManager(new GridLayout(5));

            drawMap(mapPanel);

            Button button1 = new Button("Take", () -> showMessage("Item was taken."));
            Button button2 = new Button("Wall", () -> showMessage("Wall was built."));
            // TODO: add more buttons

            mainPanel.addComponent(button1);
            mainPanel.addComponent(button2);

            mainPanel.addComponent(mapPanel);

            BasicWindow window = new BasicWindow("Roguelike Game");
            window.setComponent(mainPanel);

            MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
            gui.addWindowAndWait(window);

            screen.stopScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawMap(Panel mapPanel) {
        // simple example to draw a map, replace it with real logic
        String[][] map = {
            {"#", "#", "#", "#", "#"},
            {"#", ".", ".", ".", "#"},
            {"#", ".", "#", ".", "#"},
            {"#", ".", ".", "#", "#"},
            {"#", "#", "#", "#", "#"}
        };

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                Label label = new Label(map[y][x]);
                mapPanel.addComponent(label);
            }
        }
    }

    private static void showMessage(String message) {
        MessageDialog.showMessageDialog(null, "Message", message, MessageDialogButton.OK);
    }
}
