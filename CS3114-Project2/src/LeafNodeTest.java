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
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#remove(char[], int)}.
     */
    @Test
    public void testRemove() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#print(boolean, boolean)}.
     */
    @Test
    public void testPrint() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#search(char[], int, SequenceSearch)}.
     */
    @Test
    public void testSearchCharArrayIntSequenceSearch() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#search(char[], int)}.
     */
    @Test
    public void testSearchCharArrayInt() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#setDNA(char[])}.
     */
    @Test
    public void testSetDNA() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#dna()}.
     */
    @Test
    public void testDna() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#isLeaf()}.
     */
    @Test
    public void testIsLeaf() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#isFlyweight()}.
     */
    @Test
    public void testIsFlyweight() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#percentA()}.
     */
    @Test
    public void testPercentA() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#percentC()}.
     */
    @Test
    public void testPercentC() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#percentG()}.
     */
    @Test
    public void testPercentG() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link LeafNode#percentT()}.
     */
    @Test
    public void testPercentT() {
        fail("Not yet implemented");
    }

}
