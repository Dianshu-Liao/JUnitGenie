package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsonPointer_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithEqualPointers() {
        try {
            // Create two equal JsonPointer instances for comparison
            JsonPointer pointer1 = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class)
                .newInstance("example", 0, "example", null);
            JsonPointer pointer2 = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class)
                .newInstance("example", 0, "example", null);
            
            // This should return true
            assertTrue(pointer1.equals(pointer2));
        } catch (Exception e) {
            fail("Exception thrown while testing equals method: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentPointers() {
        try {
            // Create two different JsonPointer instances
            JsonPointer pointer1 = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class)
                .newInstance("example1", 0, "example1", null);
            JsonPointer pointer2 = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class)
                .newInstance("example2", 0, "example2", null);
            
            // This should return false
            assertFalse(pointer1.equals(pointer2));
        } catch (Exception e) {
            fail("Exception thrown while testing equals method: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithNullObject() {
        try {
            JsonPointer pointer = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class)
                .newInstance("example", 0, "example", null);

            // This should return false
            assertFalse(pointer.equals(null));
        } catch (Exception e) {
            fail("Exception thrown while testing equals method: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        try {
            JsonPointer pointer = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class)
                .newInstance("example", 0, "example", null);

            // This should return false
            assertFalse(pointer.equals("not_a_pointer"));
        } catch (Exception e) {
            fail("Exception thrown while testing equals method: " + e.getMessage());
        }
    }


}