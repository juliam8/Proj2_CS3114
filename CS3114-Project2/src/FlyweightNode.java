/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * @param 
 * @param 
 * 
 * Flyweight Node Object
 * *description*
 */
public class FlyweightNode implements DNATreeNode {
    
    /** 
     * Constructor for FlyweightNode class
     */
    FlyweightNode(){}
    
    /**
     * Replaces empty node with a leaf node
     * @param sequence the DNA sequence to insert
     * @param level the level at which to insert
     * @return the new node 
     */
    public DNATreeNode insert(char[] sequence, int level) {
        return new LeafNode(sequence);
    }
    
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
     */
    public boolean search(char[] sequence, int level, boolean check) {
        return false;        
    }
    
    /**
     * Finds an exact sequence
     * @param sequence the DNA sequence to find
     */
    public boolean search(char[] sequence, int level) {
        return false;        
    }
    
    /**
     * Get the flyweight node pointer
     * @return the flyweight node
     */
    public DNATreeNode getFlyweight() {
        return emptyFly;
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
    private static final FlyweightNode emptyFly = new FlyweightNode();


}
