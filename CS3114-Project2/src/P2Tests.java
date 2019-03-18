import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FlyweightNodeTest.class, ParserTest.class, LeafNodeTest.class, InternalNodeTest.class})
public class P2Tests {

}
