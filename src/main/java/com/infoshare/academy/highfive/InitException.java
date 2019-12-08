package com.infoshare.academy.highfive;

public class InitException extends RuntimeException {
    public InitException() {
        super("SingleTon not initialized");
    }
}
