package junitdemo;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

	 @Test
	    public void testSomething() {
	        assertEquals(4, 2 + 2);
	    }
	    
	    @Test
	    public void testAnotherThing() {
	        assertTrue(5 > 3);
	    }
}
