package com.example.escriturarapida.model;

public interface ILevels {

    int levelUp();
    double getTimeLimit(); // Devuelve el tiempo según el nivel
    boolean progress(int aciertosActuales);

}
