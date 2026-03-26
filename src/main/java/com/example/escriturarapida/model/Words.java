package com.example.escriturarapida.model;

import java.util.Random;

/**
 * Handles word generation and validation for the typing game.
 * .
 * This class provides a collection of predefined words and is responsible
 * for selecting a random word based on the current difficulty level.
 * It also validates whether the user's input matches the generated word.
 * .
 * The difficulty increases progressively by selecting words from different
 * ranges of the array depending on the player's level.
 */
public class Words implements IWords{

    /**
     * Array containing all available words for the game.
     */
    private String[] words;

    /**
     * Stores the index of the currently selected word.
     */
    int positionWord;

    /**
     * Initializes the word list used in the game.
     */
    public Words(){
        words = new String[120];

        words[0] = "cimarrón";
        words[1] = "carne";
        words[2] = "mermelada";
        words[3] = "hemorroide";
        words[4] = "herpes";
        words[5] = "ratatopo";
        words[6] = "corneta";
        words[7] = "trasteo";
        words[8] = "hermano";
        words[9] = "lengua";
        words[10] = "Cerdo";
        words[11] = "bicicleta";
        words[12] = "baldosa";
        words[13] = "chancleta";
        words[14] = "arepa";
        words[15] = "tijera";
        words[16] = "Reja";
        words[17] = "lentejas";
        words[18] = "parchate";
        words[19] = "Anciano";
        words[20] = "sifilis";
        words[21] = "gandul";
        words[22] = "papanatas";
        words[23] = "caca";
        words[24] = "atleta";
        words[25] = "Tulipán";
        words[26] = "Caracol";
        words[27] = "Palabra";
        words[28] = "tuberculo";
        words[29] = "balcón";
        words[30] = "manteca";
        words[31] = "comcenter";
        words[32] = "estofado";
        words[33] = "sangre";
        words[34] = "Locura";
        words[35] = "vidrio";
        words[36] = "menticol";
        words[37] = "fácil";
        words[38] = "chamo";
        words[39] = "Botella";
        words[40] = "contingencia";
        words[41] = "Serpiente";
        words[42] = "recorcholis";
        words[43] = "Barricada";
        words[44] = "Zombie";
        words[45] = "interrogación";
        words[46] = "ferrocarril";
        words[47] = "Frialdad";
        words[48] = "estreñimiento";
        words[49] = "eucalipto";
        words[50] = "Escoba";
        words[51] = "estuFa";
        words[52] = "Reconocer";
        words[53] = "arma la casa";
        words[54] = "estrambótico";
        words[55] = "encalambrado";
        words[56] = "paletaS";
        words[57] = "bilingüe";
        words[58] = "pintucarita";
        words[59] = "Hola, como estas?";
        words[60] = "tangamandapio";
        words[61] = "destornillador";
        words[62] = "esternocleidomastoideo";
        words[63] = "Estantería";
        words[64] = "paralilepípedo";
        words[65] = "Invertebrado";
        words[66] = "Profesionalidad";
        words[67] = "diferenciabilidad";
        words[68] = "lechuga, tomate y agua";
        words[69] = "Confía en ti";
        words[70] = "Rastreador";
        words[71] = "acetaminofen";
        words[72] = "Corrupción";
        words[73] = "Calentamiento";
        words[74] = "Hipersensibilidad";
        words[75] = "perimenopaucia";
        words[76] = "tartamudeo";
        words[77] = "Baloncesto";
        words[78] = "electromagnético";
        words[79] = "hipotermia";
        words[80] = "guarda el computador";
        words[81] = "cuidado con dar papaya";
        words[82] = "hiperventilador";
        words[83] = "tractomula en mi calzón";
        words[84] = "otorrinolarringólogo";
        words[85] = "ácido desocirribonucleico";
        words[86] = "semiautomático";
        words[87] = "desacoplamiento";
        words[88] = "40 kilogramos de arroz";
        words[89] = "patología";
        words[90] = "paradigmas enigmáticos";
        words[91] = "Paquito con poquito";
        words[92] = "Madriguera";
        words[93] = "Destraba-lenguas";
        words[94] = "FinAliZar";
        words[95] = "Desbotellado";
        words[96] = "María chuchena choza";
        words[97] = "Fusil Barrett M82";
        words[98] = "que seria pizzería";
        words[99] = "corniza que aprisa";
        words[100] = "Felicitaciones";
        words[101] = "contabilidad";
        words[102] = "agarra al ñucla";
        words[103] = "Garganta";
        words[104] = "Destrucción";
        words[105] = "cañaveralejo";
    }


    /**
     * Generates a random word based on the current difficulty level.
     * .
     * The word selection is divided into ranges:
     * - Easy levels (< 15): simple words (lower indices)
     * - Medium levels (15–29): intermediate words
     * - Advanced levels (30+): more complex or longer words and sentences
     *
     * @param ActualLevel the current level of the player
     * @return a randomly selected word according to the difficulty
     */
    @Override
    public String generateWord(int ActualLevel) {
        Random random = new Random();
        if (ActualLevel < 15){
            positionWord = random.nextInt(40);
        } else if (ActualLevel >= 15 && ActualLevel < 30){
            positionWord = random.nextInt(35, 80);
        } else {
            positionWord = random.nextInt(60, 106);
        }

        return words[positionWord];
    }

    /**
     * Validates if the user's input matches the previously generated word.
     *
     * @param word the word entered by the user
     * @return 'true' if the input matches the expected word, 'false' otherwise
     */
    @Override
    public Boolean validateWord(String word) {

        return word.equals(words[positionWord]);
    }

}
