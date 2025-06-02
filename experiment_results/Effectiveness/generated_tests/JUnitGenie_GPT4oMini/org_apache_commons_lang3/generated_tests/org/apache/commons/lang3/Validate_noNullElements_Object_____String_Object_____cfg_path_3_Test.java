package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.*;

public class Validate_noNullElements_Object_____String_Object_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testNoNullElements_withValidArray() {
        String[] input = {"one", "two", "three"};
        String message = "Array should not contain null elements";
        Object[] values = {};

        String[] result = Validate.noNullElements(input, message, values);
        assertArrayEquals(input, result);
    }

    @Test(timeout = 4000)
    public void testNoNullElements_withNullElement() {
        String[] input = {"one", null, "three"};
        String message = "Array should not contain null elements";
        Object[] values = {};

        try {
            Validate.noNullElements(input, message, values);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Array should not contain null elements: 1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNoNullElements_withEmptyArray() {
        String[] input = {};
        String message = "Array should not contain null elements";
        Object[] values = {};

        String[] result = Validate.noNullElements(input, message, values);
        assertArrayEquals(input, result);
    }

    @Test(timeout = 4000)
    public void testNoNullElements_withNullArray() {
        String message = "Array should not be null";
        Object[] values = {};

        try {
            Validate.noNullElements((Object[]) null, message, values); // Cast to Object[] to resolve ambiguity
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("array", e.getMessage());
        }
    }


}