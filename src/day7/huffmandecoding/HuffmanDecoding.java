package day7.huffmandecoding;

import java.util.*;

abstract class Node implements Comparable<Node> {

    public int frequency; // the frequency of this tree
    public char data;
    public Node left, right;

    public Node(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Node {

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }

    @Override
    public String toString() {
        return "HuffmanLeaf{" +
                "frequency=" + frequency +
                ", data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class HuffmanNode extends Node {

    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

    /*
        class Node
            public  int frequency; // the frequency of this tree
            public  char data;
            public  Node left, right;

    */
    Map<String, HuffmanLeaf> huffmanLeafMap = new HashMap<>();

    void findHuffmanLeaf(Node node, String code) {
        if (node instanceof HuffmanLeaf) huffmanLeafMap.put(code, (HuffmanLeaf) node);
        if (node.left != null) findHuffmanLeaf(node.left, String.format("%s0", code));
        if (node.right != null) findHuffmanLeaf(node.right, String.format("%s1", code));
    }

    void decode(String s, Node root) {
        findHuffmanLeaf(root, "");

        while (s.length() != 0) {
            HuffmanLeaf huffmanLeaf;
            int endIndex = 1;

            do {
                String code = s.substring(0, endIndex);
                huffmanLeaf = huffmanLeafMap.get(code);
                endIndex++;
            } while (huffmanLeaf == null);

            System.out.print(huffmanLeaf.data);

            s = s.substring(endIndex - 1);
        }
    }
}


public class HuffmanDecoding {

    // input is an array of frequencies, indexed by character code

    public static Node buildTree(int[] charFreqs) {

        PriorityQueue<Node> trees = new PriorityQueue<Node>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Node a = trees.poll();
            Node b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static Map<Character, String> mapA = new HashMap<Character, String>();

    public static void printCodes(Node tree, StringBuffer prefix) {
        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data, prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String test = input.next();

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        Node tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < test.length(); i++) {

            char c = test.charAt(i);
            s.append(mapA.get(c));

        }

        Decoding d = new Decoding();
        d.decode(s.toString(), tree);
    }
}