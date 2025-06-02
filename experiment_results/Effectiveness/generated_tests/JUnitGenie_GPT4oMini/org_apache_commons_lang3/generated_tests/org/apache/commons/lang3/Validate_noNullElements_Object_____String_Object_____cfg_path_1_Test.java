package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.fail;

public class Validate_noNullElements_Object_____String_Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNoNullElementsWithNullElement() {
        String message = "Null element found at index %d";
        Object[] inputArray = new Object[] { "test", null, "example" };
        Object[] values = new Object[] { "value1", "value2" };

        try {
            Validate.noNullElements(inputArray, message, values);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Null element found at index 1");
        }
    }

    @Test(timeout = 4000)
    public void testNoNullElementsWithValidArray() {
        String message = "No nulls allowed";
        Object[] inputArray = new Object[] { "test", "value", "example" };
        Object[] values = new Object[] { "value1", "value2" };

        Object[] result = Validate.noNullElements(inputArray, message, values);
        assert result != null;
        assert result.length == 3;
    }

}