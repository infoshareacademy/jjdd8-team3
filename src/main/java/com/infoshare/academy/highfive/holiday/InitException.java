package com.infoshare.academy.highfive.holiday;

public class InitException extends RuntimeException {
    public InitException() {
        super("SingleTon not initialized");
    }
}
