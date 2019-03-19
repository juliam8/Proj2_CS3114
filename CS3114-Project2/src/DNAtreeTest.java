import static org.junit.Assert.*;

import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * 
 */

/**
 * @author abbym1
 * @author juliam8
 * @version 2019-02-14
 */
public class DNAtreeTest {

    /**
     * Test method for {@link DNAtree#main(java.lang.String[])}.
     */
    @Test
    public void testMain() {
        String[] in1 = {"src//CoverageP2.txt"};
        assertNotNull(in1);
        try {
            DNAtree.main(in1);
        } 
        catch (FileNotFoundException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }

}
