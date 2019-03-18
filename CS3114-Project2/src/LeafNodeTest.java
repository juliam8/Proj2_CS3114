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

    /**
     * Test method for {@link LeafNode#remove(char[], int)}.
     */
    @Test
    public void testRemove() {
        char[] seq = {'A', 'A'};
        DNATreeNode n = new LeafNode(seq);
        assertTrue(n.isLeaf());
                
        n = n.remove(seq, 1);
        assertTrue(n.isFlyweight());
    }

    /**
     * Test method for {@link LeafNode#print(boolean, boolean)}.
     */
    @Test
    public void testPrint() {
        char[] seq = {'A', 'A'};
        LeafNode n = new LeafNode(seq);
        assertTrue(n.isLeaf());
        n.print(false, false);
        assertTrue(n.isLeaf());
    }

    /**
     * Test method for {@link LeafNode#search(char[], int, SequenceSearch)}.
     */
    @Test
    public void testSearchCharArrayIntSequenceSearch() {
        DNATreeNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1, true);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1, true);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1, true);
        char[] seq4 = new char[]{'T', 'G', 'C'};
        n.insert(seq4, 1, true);
        
        SequenceSearch curSearch = new SequenceSearch();
        curSearch.sequenceFound = false;
        curSearch.exactMatch = true;
        
        ((LeafNode) ((InternalNode) n).g()).search(seq3, 1, curSearch);
        assertEquals(curSearch.sequenceFound, true);
        
        SequenceSearch curSearch2 = new SequenceSearch();
        curSearch2.sequenceFound = false;
        curSearch2.exactMatch = true;
        
        char[] badSeq = new char[]{'T', 'A', 'A'};
        ((InternalNode) n).a().search(badSeq, 1, curSearch2);
        assertEquals(curSearch2.sequenceFound, false);
    }


    /**
     * Test method for {@link LeafNode#setDNA(char[])}.
     */
    @Test
    public void testSetDNA() {
        DNATreeNode n = new LeafNode();
        char[] seq1 = new char[]{'T', 'T', 'C', 'T'};
        ((LeafNode) n).setDNA(seq1);
        
        assertEquals(((LeafNode) n).dna(), seq1);
    }

    /**
     * Test method for {@link LeafNode#dna()}.
     */
    @Test
    public void testDna() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1, true);
        
        assertEquals(((LeafNode) ((InternalNode) n).a()).dna(), seq1);
    }

    /**
     * Test method for {@link LeafNode#isLeaf()}.
     */
    @Test
    public void testIsLeaf() {
        char[] seq1 = new char[]{'A', 'G', 'C', 'T'};
        DNATreeNode n = new LeafNode(seq1);
        
        assertTrue(n.isLeaf());
    }

    /**
     * Test method for {@link LeafNode#isFlyweight()}.
     */
    @Test
    public void testIsFlyweight() {
        DNATreeNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'T', 'T'};
        n.insert(seq1, 1, true);
        assertTrue(((InternalNode) n).c().isFlyweight());
        assertTrue(((InternalNode) n).g().isFlyweight());
        assertTrue(((InternalNode) n).t().isFlyweight());
        assertTrue(((InternalNode) n).$().isFlyweight());

    }

    /**
     * Test method for {@link LeafNode#percentA()}.
     */
    @Test
    public void testPercentA() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'T', 'T'};
        n.insert(seq1, 1, true);
        
        assertEquals(((LeafNode) n.a()).percentA(), 50.00, 0.1);
    }

    /**
     * Test method for {@link LeafNode#percentC()}.
     */
    @Test
    public void testPercentC() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'C', 'C', 'T', 'T'};
        n.insert(seq1, 1, true);
        
        assertEquals(((LeafNode) n.c()).percentC(), 50.00, 0.1);
    }

    /**
     * Test method for {@link LeafNode#percentG()}.
     */
    @Test
    public void testPercentG() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'G', 'A', 'T', 'T'};
        n.insert(seq1, 1, true);
        
        assertEquals(((LeafNode) n.g()).percentG(), 25.00, 0.1);
    }

    /**
     * Test method for {@link LeafNode#percentT()}.
     */
    @Test
    public void testPercentT() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'T', 'T'};
        n.insert(seq1, 1, true);
        
        assertEquals(((LeafNode) n.a()).percentT(), 50.00, 0.1);
    }

}
