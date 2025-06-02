package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class text_StrBuilder_validateRange_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValidateRange() {
        try {
            // Create an instance of StrBuilder
            StrBuilder strBuilder = new StrBuilder();
            // Set the size field to a known value for testing
            // Using reflection to access the protected field 'size'
            java.lang.reflect.Field sizeField = StrBuilder.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.setInt(strBuilder, 10); // Set size to 10 for testing

            // Access the protected method validateRange using reflection
            Method validateRangeMethod = StrBuilder.class.getDeclaredMethod("validateRange", int.class, int.class);
            validateRangeMethod.setAccessible(true);

            // Test case where startIndex is valid and endIndex is within size
            int result = (int) validateRangeMethod.invoke(strBuilder, 0, 5);
            assertEquals(5, result);

            // Test case where endIndex exceeds size
            result = (int) validateRangeMethod.invoke(strBuilder, 0, 15);
            assertEquals(10, result); // endIndex should be set to size

            // Test case where startIndex is negative
            try {
                validateRangeMethod.invoke(strBuilder, -1, 5);
                fail("Expected StringIndexOutOfBoundsException");
            } catch (StringIndexOutOfBoundsException e) {
                // Expected exception
            }

            // Test case where startIndex is greater than endIndex
            try {
                validateRangeMethod.invoke(strBuilder, 5, 3);
                fail("Expected StringIndexOutOfBoundsException");
            } catch (StringIndexOutOfBoundsException e) {
                // Expected exception
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

}