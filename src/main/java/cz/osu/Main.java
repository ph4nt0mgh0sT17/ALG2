package cz.osu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(getWelcomeText());

        String text = "Algoritmy a datove struktury - Huffmanovo kodovani 20.4.2020, ALDS2";

        Huffman huffman = new Huffman(text);

        huffman.printHuffmanCode();

        String encodedText = huffman.encode(text);

        int dataCompulsion = (encodedText.length() % 8 == 0) ? encodedText.length() / 8 : encodedText.length() / 8 + 1;

        System.out.println("Encoded Text: " + encodedText + " | Data compulsion " + dataCompulsion);

        String decodedText = huffman.decode(encodedText);
        System.out.println("Decoded Text: " + decodedText + " | Data compulsion " + decodedText.length());

    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return  "==================== 7ALG2 ====================\n" +
                "|                20. 04. 2020                 |\n" +
                "|                 David Miko                  |\n" +
                "===============================================\n";
    }
}
