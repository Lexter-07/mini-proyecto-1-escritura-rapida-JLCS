package com.example.escriturarapida.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Words implements IWord{
    private String[] words;
    //Random random;
    int positionWord;
    public Words(){
        words = new String[30];

        words[0] = "cimarron";
        words[1] = "carne";
        words[2] = "mermelada";
        words[3] = "hemorroide";
        words[4] = "herpes";
        words[5] = "ratatopo";
        words[6] = "corneta";
        words[7] = "tangamandapio";
        words[8] = "esternocleidomastoideo";
        words[9] = "lengua";
        words[10] = "cerdo";
        words[11] = "estreñimiento";
        words[12] = "baldosa";
        words[13] = "chancleta";
        words[14] = "arepa";
        words[15] = "tijera";
        words[16] = "reja";
        words[17] = "lentejas";
        words[18] = "parchate";
        words[19] = "anciano";
        words[20] = "sifilis";
        words[21] = "gandul";
        words[22] = "papanatas";
        words[23] = "caca";
        words[24] = "atleta";
        words[25] = "tulipan";
        words[26] = "estrambotico";
        words[27] = "palabra";
        words[28] = "tuberculo";
    }


    // GENERA LA PALABRA A ESCRIBIRSE.
    @Override
    public String generateWord() {
        Random random = new Random();
        positionWord = random.nextInt(29);

        return words[positionWord];
    }

    @Override
    public Boolean validateWord(String word) {

        return word.equalsIgnoreCase(words[positionWord]);
    }

}

