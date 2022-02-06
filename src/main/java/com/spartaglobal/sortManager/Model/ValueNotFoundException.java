package com.spartaglobal.sortManager.Model;

public class ValueNotFoundException extends Exception {
    public ValueNotFoundException() {
        super("This Node has no value in that direction.");
    }

    public ValueNotFoundException(String message) {
        super(message);
    }
}
