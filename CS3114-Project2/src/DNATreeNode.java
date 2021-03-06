
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 * 
 *          DNA Node Object
 *          This is the interface which LeafNode, InternalNode,
 *          and FlyweightNode all implement. It enables us to
 *          use inheritance in the DNA tree by allowing the
 *          root to be of type DNATreeNode and thus could be
 *          an internal, leaf, or flyweight node depending on
 *          what is inserted into the tree.
 */
public interface DNATreeNode {

    /**
     * Returns true if node is a leaf node
     * 
     * @return boolean
     */
    boolean isLeaf();


    /**
     * Returns true if node is a flyweight node
     * 
     * @return boolean
     */
    boolean isFlyweight();


    /**
     * Inserts a node with the sequence specified
     * 
     * @param sequence
     *            the DNA sequence to insert
     * @param level
     *            the level for recursive insertion
     * @param print
     *            whether to print the inserted node's level
     * @return DNATreeNode the node that was inserted
     */
    DNATreeNode insert(char[] sequence, int level, boolean print);


    /**
     * Removes a node with the sequence specified
     * 
     * @param sequence
     *            the DNA sequence to remove
     * @param level
     *            the level for recursive remove
     * @return DNATreeNode the node that was remove
     */
    DNATreeNode remove(char[] sequence, int level);


    /**
     * Prints the node tree path
     * 
     * @param len
     *            boolean whether or not to print length
     * @param stat
     *            boolean whether or not to print stats
     */
    void print(boolean len, boolean stat);


    /**
     * @param sequence
     *            the sequence to find and print
     * @param level
     *            the level at which the search is
     * @param curSearch
     *            the search variables for this instance
     */
    void search(char[] sequence, int level, SequenceSearch curSearch);

}
