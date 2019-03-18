import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

/**
 * 
 */

/**
 * @author amalone46
 *
 */
public class ParserTest {

    /**
     * Test method for {@link Parser#Parser(java.io.File, Tree)}.
     */
    @Test
    public final void testParser() {
        Tree<DNATreeNode> myTree;
        myTree = new Tree<DNATreeNode>();
        
        // parse is a Parser object used to interpret the 
        // input file contents and execute commands
        Parser parse = new Parser(new File("src\\P2sampleinput.txt"), myTree);
        parse.execute();
        assertNotEquals(parse, 0);
    }

}
