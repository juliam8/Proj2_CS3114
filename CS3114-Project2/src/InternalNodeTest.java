import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author jmkuz
 *
 */
public class InternalNodeTest {

    /**
     * Test method for {@link InternalNode#InternalNode()}.
     */
    @Test
    public void testInternalNode() {
        InternalNode n = new InternalNode();
        assertTrue(n.a().isFlyweight());
        assertTrue(n.c().isFlyweight());
        assertTrue(n.g().isFlyweight());
        assertTrue(n.t().isFlyweight());
        assertTrue(n.$().isFlyweight());
        assertFalse(n.isFlyweight());
        assertFalse(n.isLeaf());
    }

    /**
     * Test method for {@link InternalNode#InternalNode(DNATreeNode, DNATreeNode, DNATreeNode, DNATreeNode, DNATreeNode)}.
     
    @Test
    public void testInternalNodeDNATreeNodeDNATreeNodeDNATreeNodeDNATreeNodeDNATreeNode() {
        fail("Not yet implemented");
    }*/

    /**
     * Test method for {@link InternalNode#insert(char[], int)}.
     */
    @Test
    public void testInsert() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        
        assertFalse(n.a().isFlyweight());
        assertFalse(n.c().isFlyweight());
        assertFalse(n.g().isFlyweight());
        assertTrue(n.a().isLeaf());
        assertTrue(n.c().isLeaf());
        assertTrue(n.g().isLeaf());
        
        assertEquals(((LeafNode) ((InternalNode) n).a()).dna(), seq1);
        assertEquals(((LeafNode) ((InternalNode) n).c()).dna(), seq2);
        assertEquals(((LeafNode) ((InternalNode) n).g()).dna(), seq3);
        
        char[] seq4 = new char[]{'C', 'G', 'C'};
        n.insert(seq4, 1);
        char[] seq5 = new char[]{'C', 'T', 'C'};
        n.insert(seq5, 1);
        
        assertFalse(n.c().isLeaf());
        assertTrue(((LeafNode) ((InternalNode) n.c()).a()).isLeaf());
        assertTrue(((LeafNode) ((InternalNode) n.c()).g()).isLeaf());
        assertTrue(((LeafNode) ((InternalNode) n.c()).t()).isLeaf());
        assertEquals(((LeafNode) ((InternalNode) n.c()).a()).dna(), seq2);
        assertEquals(((LeafNode) ((InternalNode) n.c()).g()).dna(), seq4);
        assertEquals(((LeafNode) ((InternalNode) n.c()).t()).dna(), seq5);   
    }
    
    /**
     * Test method for {@link InternalNode#remove(char[], int)}.
     */
    @Test
    public void testRemove() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        
        assertTrue(n.a().isLeaf());
        assertTrue(n.c().isLeaf());
        assertTrue(n.g().isLeaf());
        
        n.remove(seq1, 1);
        
        assertFalse(n.a().isLeaf());
        assertTrue(n.c().isLeaf());
        assertTrue(n.g().isLeaf());
        
        n.remove(seq2, 1);
        
        assertFalse(n.a().isLeaf());
        assertFalse(n.c().isLeaf());
        assertTrue(n.g().isLeaf());
        
        n.remove(seq3, 1);
        
        assertFalse(n.a().isLeaf());
        assertFalse(n.c().isLeaf());
        assertFalse(n.g().isLeaf());
    }

    /**
     * Test method for {@link InternalNode#search(char[], int, SequenceSearch)}.
     */
    @Test
    public void testSearch() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        char[] seq4 = new char[]{'C', 'G', 'C'};
        n.insert(seq4, 1);
        char[] seq5 = new char[]{'C', 'T', 'C'};
        n.insert(seq5, 1);
        
        SequenceSearch curSearch = new SequenceSearch();
        curSearch.sequenceFound = false;
        curSearch.exactMatch = true;
        
        n.search(seq1, 1, curSearch);
        assertTrue(curSearch.sequenceFound);
        assertTrue(curSearch.exactMatch);
        assertEquals(curSearch.getNumberOfNodesVisited(), 2);
    }

    /**
     * Test method for {@link InternalNode#print(boolean, boolean)}.
     */
    @Test
    public void testPrint() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        char[] seq4 = new char[]{'C', 'G', 'C'};
        n.insert(seq4, 1);
        char[] seq5 = new char[]{'C', 'T', 'C'};
        n.print(false, false);
        
        assertFalse(n.c().isLeaf());
        assertTrue(((LeafNode) ((InternalNode) n.c()).a()).isLeaf());
        assertTrue(((LeafNode) ((InternalNode) n.c()).g()).isLeaf());
        assertEquals(((LeafNode) ((InternalNode) n.c()).a()).dna(), seq2);
        assertEquals(((LeafNode) ((InternalNode) n.c()).g()).dna(), seq4);
        assertEquals(((LeafNode) ((InternalNode) n.c()).t()).dna(), seq5);   
        

    }

    /**
     * Test method for {@link InternalNode#setA(DNATreeNode)}.
     */
    @Test
    public void testSetA() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        DNATreeNode a = new LeafNode(seq1);
        n.setA(a);
        
        assertTrue(n.c().isFlyweight());
        assertTrue(n.g().isFlyweight());
        assertTrue(n.t().isFlyweight());
        assertTrue(n.$().isFlyweight());
        assertEquals(((LeafNode) ((InternalNode) n).a()).dna(), seq1);
    }

    /**
     * Test method for {@link InternalNode#setG(DNATreeNode)}.
     */
    @Test
    public void testSetG() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'G', 'A', 'C', 'T'};
        DNATreeNode g = new LeafNode(seq1);
        n.setG(g);
        
        assertTrue(n.c().isFlyweight());
        assertTrue(n.a().isFlyweight());
        assertTrue(n.t().isFlyweight());
        assertTrue(n.$().isFlyweight());
        assertEquals(((LeafNode) ((InternalNode) n).g()).dna(), seq1);
    }

    /**
     * Test method for {@link InternalNode#setC(DNATreeNode)}.
     */
    @Test
    public void testSetC() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'C', 'A', 'C', 'T'};
        DNATreeNode c = new LeafNode(seq1);
        n.setC(c);
        
        assertTrue(n.a().isFlyweight());
        assertTrue(n.g().isFlyweight());
        assertTrue(n.t().isFlyweight());
        assertTrue(n.$().isFlyweight());
        assertEquals(((LeafNode) ((InternalNode) n).c()).dna(), seq1);
    }

    /**
     * Test method for {@link InternalNode#setT(DNATreeNode)}.
     */
    @Test
    public void testSetT() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'T', 'T', 'C', 'T'};
        DNATreeNode t = new LeafNode(seq1);
        n.setT(t);
        
        assertTrue(n.c().isFlyweight());
        assertTrue(n.g().isFlyweight());
        assertTrue(n.a().isFlyweight());
        assertTrue(n.$().isFlyweight());
        assertEquals(((LeafNode) ((InternalNode) n).t()).dna(), seq1);
    }

    /**
     * Test method for {@link InternalNode#set$(DNATreeNode)}.
     */
    @Test
    public void testSet$() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'T', 'C'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'T', 'G'};
        n.insert(seq2, 1);
        
        char[] seq3 = new char[]{'T'};
        DNATreeNode exact = new LeafNode(seq3);
        ((InternalNode) n.t()).set$(exact);
        
        assertTrue(n.c().isFlyweight());
        assertTrue(n.g().isFlyweight());
        assertTrue(n.a().isFlyweight());
        assertEquals(((LeafNode) ((InternalNode) n.t()).$()).dna(), seq3);
    }

    /**
     * Test method for {@link InternalNode#a()}.
     */
    @Test
    public void testA() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        char[] seq4 = new char[]{'T', 'G', 'C'};
        n.insert(seq4, 1);
        
        assertEquals(((LeafNode) ((InternalNode) n).a()).dna(), seq1);
    }

    /**
     * Test method for {@link InternalNode#g()}.
     */
    @Test
    public void testG() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        char[] seq4 = new char[]{'T', 'G', 'C'};
        n.insert(seq4, 1);
        
        assertEquals(((LeafNode) ((InternalNode) n).g()).dna(), seq3);
    }

    /**
     * Test method for {@link InternalNode#c()}.
     */
    @Test
    public void testC() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        char[] seq4 = new char[]{'T', 'G', 'C'};
        n.insert(seq4, 1);
        
        assertEquals(((LeafNode) ((InternalNode) n).c()).dna(), seq2);
    }

    /**
     * Test method for {@link InternalNode#t()}.
     */
    @Test
    public void testT() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C', 'T'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'C', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        char[] seq4 = new char[]{'T', 'G', 'C'};
        n.insert(seq4, 1);
        
        assertEquals(((LeafNode) ((InternalNode) n).t()).dna(), seq4);
    }

    /**
     * Test method for {@link InternalNode#$()}.
     */
    @Test
    public void test$() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'A', 'C'};
        n.insert(seq1, 1);
        char[] seq2 = new char[]{'C', 'A', 'T'};
        n.insert(seq2, 1);
        char[] seq3 = new char[]{'G', 'G', 'C'};
        n.insert(seq3, 1);
        char[] seq4 = new char[]{'T', 'G', 'C'};
        n.insert(seq4, 1);
        char[] seq5 = new char[]{'A'};
        n.insert(seq5, 1);
        
        assertEquals(((LeafNode) ((InternalNode) n.a()).$()).dna(), seq5);
    }

    /**
     * Test method for {@link InternalNode#isLeaf()}.
     */
    @Test
    public void testIsLeaf() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'G', 'C', 'T'};
        n.insert(seq1, 1);
        
        assertTrue(n.a().isLeaf());
    }

    /**
     * Test method for {@link InternalNode#isFlyweight()}.
     */
    @Test
    public void testIsFlyweight() {
        InternalNode n = new InternalNode();
        char[] seq1 = new char[]{'A', 'G', 'C', 'T'};
        n.insert(seq1, 1);
        
        assertTrue(n.c().isFlyweight());
        assertTrue(n.g().isFlyweight());
        assertTrue(n.t().isFlyweight());
        assertTrue(n.$().isFlyweight());
    }

    

}
