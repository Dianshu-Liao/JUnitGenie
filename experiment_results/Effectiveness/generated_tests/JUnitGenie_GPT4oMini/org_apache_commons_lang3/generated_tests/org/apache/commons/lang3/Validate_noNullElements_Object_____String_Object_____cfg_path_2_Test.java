package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.*;

public class Validate_noNullElements_Object_____String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNoNullElementsWithNullElement() {
        String message = "Element at index %d is null";
        Object[] arrayWithNull = {1, null, 3};

        try {
            Validate.noNullElements(arrayWithNull, message, new Object[]{});
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Element at index 1 is null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNoNullElementsWithNoNullElement() {
        String message = "No null elements expected";
        Object[] validArray = {1, 2, 3};

        Object[] result = Validate.noNullElements(validArray, message, new Object[]{});
        assertArrayEquals(validArray, result);
    }

}