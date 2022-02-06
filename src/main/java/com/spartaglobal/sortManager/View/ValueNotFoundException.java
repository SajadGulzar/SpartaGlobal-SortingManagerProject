package com.spartaglobal.sortManager.View;

public class ValueNotFoundException extends Exception {
    public ValueNotFoundException() {
        super("This Node has no value in that direction.");
    }

    public ValueNotFoundException(String message) {
        super(message);
    }
}
