
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 * DNA Node Object
 * *description*
 */
public interface DNATreeNode {
    
    /**
     * Returns true if node is a leaf node
     * @return boolean
     */
    boolean isLeaf();
    
    /**
     * Returns true if node is a flyweight node
     * @return boolean
     */
    boolean isFlyweight();
    
    /**
     * Inserts a node with the sequence specified
     * @param sequence the DNA sequence to insert
     * @param level the level for recursive insertion
     * @return DNATreeNode the node that was inserted
     */
    DNATreeNode insert(char[] sequence, int level);
    DNATreeNode remove(char[] sequence, int level);
    
    /**
     * Prints the node tree path
     * @param len boolean whether or not to print length
     * @param stat boolean whether or not to print stats
     */
    void print(boolean len, boolean stat);
    
    /**
     * @param sequence the sequence to find and print
     */
    void search(char[] sequence, int level);
}
