import java.util.Arrays;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 * Leaf Node Object
 * *description*
 */
public class LeafNode implements DNATreeNode {
    
    /**
     * Constructor for LeafNode class
     */
    //LeafNode() {
    //    char[] arr = {};
    //    dnaSequence = arr;
    //    length = 0;  
    //}
    
    /**
     * Constructor for LeafNode class
     * @param sequence the DNA sequence for this leaf node
     */
    LeafNode(char[] sequence) {
        dnaSequence = sequence;
        length = sequence.length;
        
        char[] letters = "ACGT".toCharArray();
        int[] count = new int[4];
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 4; j++) {
                if (sequence[i] == letters[j]) {
                    count[j]++;
                }
            }
        }
        double newLength = (double) length;
        percentA = (count[0] * 100 / newLength);
        percentC = (count[1] * 100 / newLength);
        percentG = (count[2] * 100 / newLength);
        percentT = (count[3] * 100 / newLength);
    }
    
    /**
     * Inserts a node below a leaf node
     * @param sequence the DNA sequence to insert
     * @param level the level at which to insert
     * @param print the boolean that dictates whether to print
     * @return the node that was inserted
     */
    public DNATreeNode insert(char[] sequence, int level, boolean print) {
        
        //if(length != 0) {
        InternalNode n = new InternalNode();
        n.insert(dnaSequence, level, false);
        n.insert(sequence, level, true);
        return n;
        //}
        
       // return new LeafNode(sequence);
       
    }
    
    /**
     * Removes specified sequence
     * @param sequence the sequence to remove
     * @param level the level at which it is
     * @return the DNA node that was removed
     */
    public DNATreeNode remove(char[] sequence, int level) {
        if (Arrays.equals(sequence, dnaSequence)) {
            return new FlyweightNode();
        }
        else {
            return this;
        }
    }
    
    /**
     * Prints out an Leaf Node key
     * @param len boolean whether or not to print length
     * @param stat boolean whether or not to print stats
     */
    public void print(boolean len, boolean stat) {
        System.out.print(dnaSequence);
        if (len) {
            System.out.print(" " + length);
        }
        else if (stat) {
            String statA = String.format("%.2f", percentA);
            String statC = String.format("%.2f", percentC);
            String statG = String.format("%.2f", percentG);
            String statT = String.format("%.2f", percentT);
            System.out.print(" A:" + statA);
            System.out.print(" C:" + statC);
            System.out.print(" G:" + statG);
            System.out.print(" T:" + statT);
        }
        System.out.print("\n");
    }
    
    /**
     * Finds a sequence within the DNA tree
     * @param sequence the DNA sequence to find
     * @param level the level at which the node is
     * @param curSearch the search variables to consider
     */
    //if search sequence has $ at the end, then you
    //only check if that EXACT sequence exists.
    //if it doesn't have that $ at the end, print out all.
    public void search(char[] sequence, int level, SequenceSearch curSearch) {
        curSearch.incrementNumOfNodesVisited();
        
        if (!curSearch.getExactMatch()) {
            char [] subArray;
            subArray = Arrays.copyOfRange(dnaSequence, 0, sequence.length);
            if (Arrays.equals(sequence, subArray)) {
                System.out.print("sequence: ");
                System.out.println(dnaSequence);
                curSearch.setSequenceFound(true);
            }
        }
        else {
            if (Arrays.equals(sequence, dnaSequence)) {
                curSearch.setSequenceFound(true);
                
                if (!curSearch.getInsertCheck()) {
                    System.out.print("sequence: ");
                    System.out.println(dnaSequence);
                }
            }
        }
    }
    
    /**
     * Sets the DNA sequence to a new value
     * @param sequence the sequence to set
     */
    public void setDNA(char[] sequence) {
        dnaSequence = sequence;
    }
    
    /**
     * Returns the DNA sequence for this leaf node
     * @return the DNA sequence
     */
    public char[] dna() {
        return dnaSequence;
    }
    
    /**
     * Check for if the node is a leaf node
     * @return a boolean that states that this is a leaf node
     */
    public boolean isLeaf() {
        return true;
    }
    
    /**
     * Check for if the node is a flyweight node
     * @return false since a leaf node is not a flyweigh
     */
    public boolean isFlyweight() {
        return false;
    }
    
    /**
     * Returns the percentage of A in the leaf node
     * @return the percentage of A
     */
    public double percentA() {
        return percentA;
    }
    
    /**
     * Returns the percentage of C in the leaf node
     * @return the percentage of C
     */
    public double percentC() {
        return percentC;
    }
    
    /**
     * Returns the percentage of G in the leaf node
     * @return the percentage of G
     */
    public double percentG() {
        return percentG;
    }
    
    /**
     * Returns the percentage of A in the leaf node
     * @return the percentage of A
     */
    public double percentT() {
        return percentT;
    }
    
    /**
     * Member variable that holds the DNA sequence of the node
     */
    private char[] dnaSequence;
    
    private int length;
    private double percentA;
    private double percentC;
    private double percentG;
    private double percentT;

}
