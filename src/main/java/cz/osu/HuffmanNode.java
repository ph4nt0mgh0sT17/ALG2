package cz.osu;

import lombok.*;

/**
 * The node of the huffman code algorithm.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class HuffmanNode {
    private String symbol;
    private Integer frequency;

    private HuffmanNode next;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(String symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public HuffmanNode(String symbol, int frequency, HuffmanNode left, HuffmanNode right) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}
