package com.example.escriturarapida.model;

public class Levels implements ILevels {
    public int ActualLevel = 1;
    private int BaseTime = 20;
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
        BaseTime = 20;
        Successes = 0;

    }

    @Override
    public int timeForLevel(){
        if (Successes == 5){
            BaseTime -= 2;
        }
        return BaseTime;
    }

}