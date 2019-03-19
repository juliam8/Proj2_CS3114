import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

/**
 * 
 */

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * 
 * Parser Test Object
 * *description*
 */
public class ParserTest {

    /**
     * Test method for {@link Parser#Parser(java.io.File, Tree)}.
     */
    @Test
    public final void testParser() {
        Tree<DNATreeNode> myTree;
        myTree = new Tree<DNATreeNode>();
        assertEquals(myTree.nodeCount(), 0);
        //should be a flyweight, not null
        assertNotNull(myTree.root());
        
        File tFile = new File("src//P2ParserTestFile.txt");
        assertNotNull(tFile);
        
        // parse is a Parser object used to interpret the 
        // input file contents and execute commands
        Parser myparse = new Parser(tFile, myTree);
        // should be a flyweight, not null
        assertNotNull(myparse.mTree.root());      
    }
    
    
    /**
     * Test method for {@link Parser#Execute()}.
     */
    @Test
    public final void testExecute() {
        
        Tree<DNATreeNode> myTree;
        myTree = new Tree<DNATreeNode>();
        assertEquals(myTree.nodeCount(), 0);
        assertNotNull(myTree.root());
        
        File tFile = new File("src//P2ParserTestFile.txt");
        assertNotNull(tFile);
        
        // parse is a Parser object used to interpret the 
        // input file contents and execute commands
        Parser myparse = new Parser(tFile, myTree);
        myparse.execute();
        assertEquals(myparse.mTree.nodeCount(), 1);
        char[] seq1 = {'G', 'T'};
        char[] seq2 = {'G', 'T', 'C'};
        myparse.mTree.insert(seq1);
        myparse.mTree.insert(seq2);
        assertEquals(myparse.mTree.nodeCount(), 3);
        myparse.mTree.clear();
        assertEquals(myparse.mTree.nodeCount(), 1);
    }
}
