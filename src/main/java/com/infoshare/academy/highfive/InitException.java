package com.infoshare.academy.highfive;

public class InitException extends Exception {
    public InitException() {
        super("SingleTon not initialized");
    }
}
