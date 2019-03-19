import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * 
 * Flyweight Node Test Object
 * *description*
 */
public class FlyweightNodeTest {

    /**
     * Test method for {@link FlyweightNode#FlyweightNode()}.
     */
    @Test
    public final void testFlyweightNode() {
        DNATreeNode n = new FlyweightNode();
        assertTrue(n.isFlyweight());
    }

    /**
     * Test method for {@link FlyweightNode#insert(char[], int)}.
     */
    @Test
    public final void testInsert() {
        DNATreeNode n = new FlyweightNode();
        assertTrue(n.isFlyweight());
        char[] arr = {'A', 'C', 'T'};
        n = n.insert(arr, 0, true);
        assertTrue(n.isLeaf());
        assertFalse(n.isFlyweight());
    }

    /**
     * Test method for {@link FlyweightNode#remove(char[], int)}.
     */
    @Test
    public final void testRemove() {
        DNATreeNode n = new FlyweightNode();
        char[] arr = {'A', 'C', 'T'};
        DNATreeNode rm = n.remove(arr, 0);
        assertEquals(n, rm);
    }

    /**
     * Test method for {@link FlyweightNode#print(boolean, boolean)}.
     */
    @Test
    public final void testPrint() {
        DNATreeNode n = new FlyweightNode();
        assertTrue(n.isFlyweight());
    }

}
