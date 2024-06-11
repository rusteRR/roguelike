package ru.hse.sd;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private static InputEvent currentInput;

    public Controller() {
        currentInput = null;
    }

    public KeyEvent getKey() {
        if (currentInput instanceof KeyEvent) {
            return (KeyEvent) currentInput;
        }
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (currentInput == null) {
            currentInput = e;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentInput = null;
    }
}
