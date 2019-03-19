
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * 
 * Flyweight Node Object
 * *description*
 */
public class FlyweightNode implements DNATreeNode {
    
    /** 
     * Constructor for FlyweightNode class
     */
    FlyweightNode() {
        //empty because no variables need to be set
    }
    
    /**
     * Replaces empty node with a leaf node
     * @param sequence the DNA sequence to insert
     * @param level the level at which to insert
     * @param print the boolean that dictates whether to print
     * @return the new node 
     */
    public DNATreeNode insert(char[] sequence, int level, boolean print) {
        //System.out.println(level - 1);
        //LeafNode n = new LeafNode();
        //return n.insert(sequence, 0);
        return new LeafNode(sequence);
    }
    
    /**
     * Remove helper
     * @param sequence the sequence to remove
     * @param level the level at which the node is
     * @return the removed DNA tree node 
     */
    public DNATreeNode remove(char[] sequence, int level) {
        return this;
    }
    
    /**
     * Prints out an empty key
     * @param len boolean whether or not to print length
     * @param stat boolean whether or not to print stats
     */
    public void print(boolean len, boolean stat) {
        System.out.println("E");
    }
    
    /**
     * Finds a sequence
     * @param sequence the DNA sequence to find
     * @param level the level at which the node is
     * @param curSearch the search variables
     */
    public void search(char[] sequence, int level, SequenceSearch curSearch) {
        curSearch.incrementNumOfNodesVisited();
    }
    
    
    /**
     * Get the flyweight node pointer
     * @return the flyweight node
     */
    public DNATreeNode getFlyweight() {
        return EMPTY_FLY;
    }
    
    /** 
     * Return false because it is not a leaf
     * @return boolean 
     */
    public boolean isLeaf() {
        return false;
    }
    
    /**
     * Returns true because this is a flyweight node
     * @return boolean
     */
    public boolean isFlyweight() {
        return true;
    }
        
    /**
     * Private member variable for Flyweight node
     */
    private static final FlyweightNode EMPTY_FLY = new FlyweightNode();


}
