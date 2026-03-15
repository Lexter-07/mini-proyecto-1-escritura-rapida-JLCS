package com.example.escriturarapida.model;

public class Levels implements ILevels {
    public int ActualLevel = 1;
    private int TiempoBase = 20;
    private int Successes = 0;


    @Override
    public int levelUp() {
        ActualLevel += 1;
        if (Successes < 5) {
            Successes += 1;
        } else {
            Successes = 0;
        }

        return ActualLevel;
    }

    @Override
    public void resetGame() {
        ActualLevel = 1;
        TiempoBase = 20;

    }

    @Override
    public int timeForLevel(){
        if (Successes == 5){
            TiempoBase -= 2;
        }
        return TiempoBase;
    }

}