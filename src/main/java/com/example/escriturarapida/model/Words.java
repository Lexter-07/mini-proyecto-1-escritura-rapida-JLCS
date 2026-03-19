package com.example.escriturarapida.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Words implements IWord{
    private String[] words;
    int positionWord;
    public Words(){
        words = new String[80];

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
        words[10] = "Cerdo";
        words[11] = "estreñimiento";
        words[12] = "baldosa";
        words[13] = "chancleta";
        words[14] = "arepa";
        words[15] = "tijera";
        words[16] = "Reja";
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
        words[27] = "Palabra";
        words[28] = "tuberculo";
        words[29] = "acetaminofen";
        words[30] = "manteca";
        words[31] = "comcenter";
        words[32] = "pintucarita";
        words[33] = "sangre";
        words[34] = "bilingüe";
        words[35] = "vidrio";
        words[36] = "menticol";
        words[37] = "ferrocarril";
        words[38] = "chamo";
        words[39] = "contingencia";
        words[40] = "botella";
        words[41] = "Serpiente";
        words[42] = "recorcholis";
        words[43] = "Barricada";
        words[44] = "Zombie";
        words[45] = "interrogación";
        words[46] = "fácil";
        words[47] = "frialdad";
        words[48] = "bicicleta";
        words[49] = "eucalipto";
        words[50] = "Escoba";
        words[51] = "estuFa";
        words[52] = "reconocer";
        words[53] = "arma la casa";
        words[54] = "Caracol";
        words[55] = "balcón";
        words[56] = "paletaS";
        words[57] = "Locura";
        words[58] = "estofado";
        words[59] = "Hola, como estas?";
        words[60] = "trasteo";
        words[61] = "destornillador";
        words[62] = "hermano";
    }


    // GENERA LA PALABRA A ESCRIBIRSE.
    @Override
    public String generateWord() {
        Random random = new Random();
        positionWord = random.nextInt(63);

        return words[positionWord];
    }

    @Override
    public Boolean validateWord(String word) {

        return word.equals(words[positionWord]);
    }

}
