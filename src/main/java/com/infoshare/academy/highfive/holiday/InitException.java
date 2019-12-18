package com.infoshare.academy.highfive.holiday;

class InitException extends RuntimeException {
    InitException() {
        super("SingleTon not initialized");
    }
}
