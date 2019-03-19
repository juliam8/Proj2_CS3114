import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ FlyweightNodeTest.class, ParserTest.class, LeafNodeTest.class,
    InternalNodeTest.class, DNAtreeTest.class })
public class P2Tests {

}
