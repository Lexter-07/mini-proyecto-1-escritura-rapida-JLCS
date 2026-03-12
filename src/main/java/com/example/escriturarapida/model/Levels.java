package com.example.escriturarapida.model;

public class Levels implements ILevels{
    public int ActualLevel = 1;
    private double TiempoBase = 20;
    private final int ACIERTOS = 10;



    @Override
    public int levelUp() {
        ActualLevel +=1;
        return ActualLevel;
    }

    @Override
    public double getTimeLimit() {
        return 0;
    }

    @Override
    public boolean progress(int aciertosActuales) {
        return aciertosActuales >= ACIERTOS;
    }
}
