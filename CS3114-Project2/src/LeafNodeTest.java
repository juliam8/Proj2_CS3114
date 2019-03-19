import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author jmkuz
 *
 */
public class LeafNodeTest {

    /**
     * Test method for {@link LeafNode#LeafNode(char[])}.
     */
    @Test
    public void testLeafNode() {
        char[] seq = {'A', 'A'};
        LeafNode n = new LeafNode(seq);
        assertTrue(n.isLeaf());
    }

    /**
     * Test method for {@link LeafNode#insert(char[], int)}.
     */
    @Test
    public void testInsert() {
        char[] seq = {'A', 'A'};
        DNATreeNode n = new LeafNode(seq);
        assertTrue(n.isLeaf());
        
        char[] seq2 = {'G', 'T'};
        n = n.insert(seq2, 1, true);
        
        assertFalse(n.isLeaf());
        assertFalse(n.isFlyweight());
    }


    
}
