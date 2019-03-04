
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 * DNA Node Object
 * *description*
 */

public interface DNATreeNode {
    
    boolean isLeaf();
    boolean isFlyweight();
    DNATreeNode insert(char[] sequence, int level);
    void print(boolean len, boolean stat);
}
