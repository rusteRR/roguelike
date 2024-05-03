package ru.hse.sd.exceptions;

public class InventoryIsFull extends Exception {
    public InventoryIsFull(String message) {
        super(message);
    }
}
