package ru.javalearn.facade;


class CPU {
    public void freeze() {  }
    public void jump(long position) {  }
    public void execute() {  }
}

class Memory {
    public void load(long position, byte[] data) {  }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        byte[] b = {1,2};
        return b;
    }
}

/* Facade */

class Computer {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    private static final long BOOT_ADDRESS = 123;
    private static final long BOOT_SECTOR = 1;
    private static final int SECTOR_SIZE = 2;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}

/* Client */

class Facade {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startComputer();
    }
}