package cz.osu;

import java.util.HashMap;

public class Huffman {

    private HuffmanNode root;
    private HashMap<String, String> huffmanCode;

    /**
     * Builds the Huffman tree according to the text.
     * @param text The text to be encoded/decoded.
     */
    public Huffman(String text){

        buildHuffmanTree(text);
    }

    /**
     * Prints the huffman tree code.
     */
    public void printHuffmanCode(){

        for (String symbol : huffmanCode.keySet()) {

            System.out.println(symbol + " > " + huffmanCode.get(symbol));
        }
    }

    /**
     * Encodes the text to the simplified version.
     * @param textToEncode The text to be encoded.
     * @return The encoded text.
     */
    public String encode(String textToEncode){

        StringBuilder sb = new StringBuilder();

        // Searches for all encoded huffman codes to fill the encoded text.
        for (int i = 0 ; i < textToEncode.length(); i++) {
            sb.append(huffmanCode.get(textToEncode.substring(i, i + 1)));
        }

        return sb.toString();
    }

    /**
     * Decodes the text..
     * @param textToDecode The text to be decoded.
     * @return The decoded text.
     */
    public String decode(String textToDecode){

        StringBuilder stringBuilder = new StringBuilder();

        int index = -1;
        while (index < textToDecode.length() - 2) {

            index = findSymbol(root, index, textToDecode, stringBuilder);
        }

        return stringBuilder.toString();
    }

    /**
     * Builds the huffman tree using the binary tree.
     * @param text The text that is relevant to the huffman tree.
     */
    private void buildHuffmanTree(String text) {

        HashMap<Character, HuffmanNode> freqMap = new HashMap<>();

        for(int i = 0; i < text.length(); i++){

            HuffmanNode temp = freqMap.get(text.charAt(i));

            if(temp == null){

                freqMap.put(text.charAt(i), new HuffmanNode(text.substring(i, i+ 1), 1));

            }else {

                temp.setFrequency(temp.getFrequency() + 1);
            }
        }

        //prioritniFronta
        PriorityQueue priorityQueueHuffman = new PriorityQueue();
        for (HuffmanNode node: freqMap.values()) priorityQueueHuffman.addNode(node);

        //vytvoreni stromu
        while (priorityQueueHuffman.getNodesCount() > 1){

            HuffmanNode left = priorityQueueHuffman.pop();
            HuffmanNode right = priorityQueueHuffman.pop();

            priorityQueueHuffman.addNode(new HuffmanNode("", left.getFrequency() + right.getFrequency(), left, right));
        }

        root = priorityQueueHuffman.pop();

        // prochazeni stromu a generovani kodu
        huffmanCode = new HashMap<>();
        fillHuffmanCode(root, "", huffmanCode);
    }

    /**
     * Fills the huffman code.
     * @param actualNode The actual node if is the symbol.
     * @param str The huffman code.
     * @param huffmanCode The map of all huffman codes.
     */
    private void fillHuffmanCode(HuffmanNode actualNode, String str, HashMap<String, String> huffmanCode) {

        if (actualNode == null) return;

        if (actualNode.getLeft() == null && actualNode.getRight() == null) {

            huffmanCode.put(actualNode.getSymbol(), str);
        }

        fillHuffmanCode(actualNode.getLeft(), str + "0", huffmanCode);
        fillHuffmanCode(actualNode.getRight(), str + "1", huffmanCode);
    }

    /**
     * Searches for the symbol.
     * @param actualNode The actual node.
     * @param index The index.
     * @param textToDecode The text to be decoded.
     * @param decodedText Already decoded text.
     * @return The index of the symbol.
     */
    private int findSymbol(HuffmanNode actualNode, int index, String textToDecode, StringBuilder decodedText) {

        if (actualNode == null)
            return index;

        // We reached actual symbol node we have nowhere to go, so we can append current symbol
        if (actualNode.getLeft() == null && actualNode.getRight() == null) {
            decodedText.append(actualNode.getSymbol());
            return index;
        }

        index++;

        if (textToDecode.charAt(index) == '0') {
            index = findSymbol(actualNode.getLeft(), index, textToDecode, decodedText);
        }

        else {
            index = findSymbol(actualNode.getRight(), index, textToDecode, decodedText);
        }

        return index;
    }
}
