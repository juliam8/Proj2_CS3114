
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * @param <N> the type of node within the tree
 *
 * Tree Object
 * *description*
 */
public class Tree<N> {
    
    /**
     * Constructor for the Tree class 
     * Sets the root as a flyweight node
     */
    Tree() {
        root = new FlyweightNode();
    }
    

    /**
     * Clears the elements of the DNA Tree
     */
    public void clear() {
        root = new FlyweightNode();
        nodeCount = 1;
    }

    /**
     * Calls node insert helper and to increment node count 
     * @param sequence the sequence to insert
     */
    public void insert(char[] sequence) {
        root = root.insert(sequence, 1, true);
        nodeCount++;
    }
    
    /**
     * Calls node remove helper to remove sequence
     * @param sequence the dna sequence to remove
     */
    public void remove(char[] sequence) {
        root = root.remove(sequence, 1);
        nodeCount--;
    }
    
    /**
     * Prints out the sequences in the tree in pre order
     * @param len boolean whether or not to print length
     * @param stat boolean whether or not to print stats
     */
    public void print(boolean len, boolean stat) {
        root.print(len, stat);
    }
    
    /**
     * Searches for occurrences of a sequence within the tree
     * @param sequence the sequence to find within the tree
     * @param curSearch the specified variables for this search
     */
    public void search(char[] sequence, SequenceSearch curSearch) {
        root.search(sequence, 0, curSearch);
    }

    /**
     * Returns the root of the DNA Tree
     * @return the root of the DNA Tree
     */
    public DNATreeNode root() {
        return root;
    }

    /**
     * Returns the node count of the DNA Tree
     * @return the number of nodes in the DNA Tree
     */
    public int nodeCount() {
        return nodeCount;
    }

    /**
     * The root of the DNATree
     */
    protected DNATreeNode root;
    
    /**
     * The number of nodes in the DNA Tree
     */
    protected int nodeCount;   
    
    /**
     * The DNA sequence in the node
     */
    protected char[] dnaSequence;
}
