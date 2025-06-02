package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.Name2;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class sym_Name2_equals_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithMatchingValues() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        // Set the private final fields q1 and q2 using reflection
        setFinalField(name2, "q1", 1);
        setFinalField(name2, "q2", 2);
        
        // Test with matching values
        assertTrue(name2.equals(1, 2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNonMatchingFirstValue() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        // Set the private final fields q1 and q2 using reflection
        setFinalField(name2, "q1", 1);
        setFinalField(name2, "q2", 2);
        
        // Test with non-matching first value
        assertFalse(name2.equals(2, 2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNonMatchingSecondValue() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        // Set the private final fields q1 and q2 using reflection
        setFinalField(name2, "q1", 1);
        setFinalField(name2, "q2", 2);
        
        // Test with non-matching second value
        assertFalse(name2.equals(1, 3));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNonMatchingValues() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        // Set the private final fields q1 and q2 using reflection
        setFinalField(name2, "q1", 1);
        setFinalField(name2, "q2", 2);
        
        // Test with non-matching values
        assertFalse(name2.equals(2, 3));
    }

    private void setFinalField(Name2 name2, String fieldName, int value) {
        try {
            java.lang.reflect.Field field = Name2.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setInt(name2, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}