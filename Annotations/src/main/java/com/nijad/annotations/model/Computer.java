package com.nijad.annotations.model;

public class Computer {
    private CPU cpu;

    public Computer(CPU cpu) {
        this.cpu = cpu;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
}
