package com.example.escriturarapida.model;

public class Levels implements ILevels {
    public int ActualLevel = 1;
    public int score = 0;
    public int fails = 0;
    private int baseTime = 20;
    private int successes = 0;



    @Override
    public int levelUp() {
        ActualLevel += 1;
        score += 1;
        if (successes < 5) {
            successes += 1;
        } else {
            successes = 0;
        }

        return ActualLevel;
    }

    @Override
    public void resetGame() {
        ActualLevel = 1;
        baseTime = 20;
        successes = 0;

    }

    @Override
    public int timeForLevel(){
        if (successes == 5){
            baseTime -= 2;
        }
        return baseTime;
    }

}