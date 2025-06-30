package junitdemo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    
    @Test
    public void testBasicAssertions() {
        // Test equality (expected, actual)
        assertEquals(5, 2 + 3);
        
        // Test boolean conditions
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        
        // Test null/not null
        assertNull(null);
        assertNotNull(new Object());
    }
    
    @Test
    public void testArrayAndObjectEquality() {
        // Test array equality (contents must match)
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        
        // Test object equality (uses equals() method)
        String s1 = "hello";
        String s2 = "hello";
        assertSame(s1, s2);       // Checks if same object (for strings from pool)
        assertEquals(s1, s2);     // Checks logical equality
    }
    
    @Test(expected = ArithmeticException.class)
    public void testException() {
        // Test if exception is thrown
        int result = 1 / 0;
    }
    
    @Test
    public void testFloatingPointComparison() {
        // Test floating point with delta tolerance
        assertEquals(0.3, 0.1 + 0.2, 0.0001);  // Avoid floating-point precision issues
    }
}