package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.*;

public class Validate_noNullElements_Object_____String_Object_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testNoNullElements_withValidArray() {
        String[] inputArray = {"Hello", "World"};
        String message = "Array cannot contain null values";
        String[] result = Validate.noNullElements(inputArray, message);
        assertArrayEquals(inputArray, result);
    }

    @Test(timeout = 4000)
    public void testNoNullElements_withNullElement() {
        String[] inputArray = {"Hello", null};
        String message = "Array cannot contain null values";
        
        try {
            Validate.noNullElements(inputArray, message);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Array cannot contain null values at index 1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNoNullElements_withEmptyArray() {
        String[] inputArray = {};
        String message = "Empty array is valid";
        String[] result = Validate.noNullElements(inputArray, message);
        assertArrayEquals(inputArray, result);
    }

    @Test(timeout = 4000)
    public void testNoNullElements_withAllNullArray() {
        String[] inputArray = {null, null};
        String message = "All elements are null";
        
        try {
            Validate.noNullElements(inputArray, message);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("All elements are null at index 0", e.getMessage());
        }
    }

}