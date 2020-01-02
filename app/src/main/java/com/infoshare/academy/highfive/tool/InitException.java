package com.infoshare.academy.highfive.tool;

public class InitException extends RuntimeException {
    public InitException() {
        super("SingleTon not initialized");
    }
}
