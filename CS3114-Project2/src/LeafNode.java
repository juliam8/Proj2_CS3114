
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * @param 
 * @param 
 *
 * Leaf Node Object
 * *description*
 */
public class LeafNode implements DNATreeNode{
    
    /**
     * Constructor for LeafNode class
     * @param sequence the DNA sequence for this leaf node
     */
    LeafNode(char[] sequence){
        DNASequence = sequence;
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
        percentA = (count[0]*100 / length);
        percentC = (count[1]*100 / length);
        percentG = (count[2]*100 / length);
        percentT = (count[3]*100 / length);
    }
    
    /**
     * @param sequence
     * @return
     */
    public DNATreeNode insert(char[] sequence, int level) {
        InternalNode n = new InternalNode();
        n.insert(DNASequence, level);
        n.insert(sequence, level);
        return n;
    }
    
    /**
     * Prints out an Leaf Node key
     * @param len boolean whether or not to print length
     * @param stat boolean whether or not to print stats
     */
    public void print(boolean len, boolean stat) {
        System.out.print(DNASequence);
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
     * Sets the DNA sequence to a new value
     * @param sequence
     */
    public void setDNA(char[] sequence) {
        DNASequence = sequence;
    }
    
    /**
     * Returns the DNA sequence for this leaf node
     * @return the DNA sequence
     */
    public char[] dna() {
        return DNASequence;
    }
    
    /**
     * Check for if the node is a leaf node
     * @return
     */
    public boolean isLeaf() {
        return true;
    }
    
    /**
     * Check for if the node is a flyweight node
     * @return
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
    private char[] DNASequence;
    
    private int length;
    private double percentA;
    private double percentC;
    private double percentG;
    private double percentT;

}
