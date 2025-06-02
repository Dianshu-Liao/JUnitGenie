package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertArrayEquals;

public class Validate_notEmpty_Object_____String_Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNotEmptyWithNullArray() {
        String message = "Array must not be null";
        try {
            Validate.notEmpty((Object[]) null, message); // Explicitly casting to Object[]
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testNotEmptyWithEmptyArray() {
        String message = "Array must not be empty";
        try {
            Validate.notEmpty(new Object[]{}, message);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testNotEmptyWithValidArray() {
        Object[] result = Validate.notEmpty(new Object[]{1, 2, 3}, "Array is valid");
        // Assert that the result is the same as the input array
        assertArrayEquals(new Object[]{1, 2, 3}, result);
    }


}