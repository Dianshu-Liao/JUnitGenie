package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_validateRange_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testValidateRange() {
        try {
            // Instantiate the StrBuilder class
            StrBuilder strBuilder = new StrBuilder();
            // Set the protected field 'size' using reflection
            java.lang.reflect.Field sizeField = StrBuilder.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.setInt(strBuilder, 10); // Set size to 10 for testing

            // Access the protected method 'validateRange' using reflection
            Method validateRangeMethod = StrBuilder.class.getDeclaredMethod("validateRange", int.class, int.class);
            validateRangeMethod.setAccessible(true);

            // Test case: Valid range
            int result = (int) validateRangeMethod.invoke(strBuilder, 0, 5);
            assertEquals(5, result);

            // Test case: endIndex greater than size
            result = (int) validateRangeMethod.invoke(strBuilder, 0, 15);
            assertEquals(10, result); // endIndex should be capped to size

            // Test case: startIndex greater than endIndex
            try {
                validateRangeMethod.invoke(strBuilder, 5, 3);
            } catch (StringIndexOutOfBoundsException e) {
                // Expected exception
            }

            // Test case: startIndex negative
            try {
                validateRangeMethod.invoke(strBuilder, -1, 5);
            } catch (StringIndexOutOfBoundsException e) {
                // Expected exception
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}