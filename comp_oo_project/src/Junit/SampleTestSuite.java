package Junit;
import junit.framework.Test;
import junit.framework.TestSuite;


public class SampleTestSuite extends TestSuite
{
	public static Test suite() {
	TestSuite suite = new TestSuite("Sample Tests");

	suite.addTestSuite(pos_test.class);
	
	return suite;
	}
}