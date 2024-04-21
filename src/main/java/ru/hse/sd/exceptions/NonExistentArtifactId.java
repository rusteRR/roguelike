package ru.hse.sd.exceptions;

public class NonExistentArtifactId extends Exception {
    public NonExistentArtifactId(String message) {
        super(message);
    }
}
