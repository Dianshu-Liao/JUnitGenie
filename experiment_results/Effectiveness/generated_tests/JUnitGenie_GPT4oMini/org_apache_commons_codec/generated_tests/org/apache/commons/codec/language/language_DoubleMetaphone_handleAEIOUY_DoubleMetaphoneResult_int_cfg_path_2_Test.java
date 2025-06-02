package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class language_DoubleMetaphone_handleAEIOUY_DoubleMetaphoneResult_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHandleAEIOUY_whenIndexIsGreaterThanZero() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone(); // Instantiate the class
        DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Create the result object with an initial value
        int index = 1; // Set index greater than 0

        try {
            // Access the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleAEIOUY", DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true); // Make the private method accessible

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, result, index);
            
            // Check that the returned index is correct
            assertEquals(2, newIndex); // index + 1 should equal 2
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception in case of reflection failure or other issues
        }

        // Assert that the result contains 'A' after calling the method
        assertEquals('A', result.toString().charAt(0)); // Ensure character 'A' is appended
    }

    @Test(timeout = 4000)
    public void testHandleAEIOUY_whenIndexIsZero() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone(); // Instantiate the class
        DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Create the result object with an initial value
        int index = 0; // Set index to 0

        try {
            // Access the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleAEIOUY", DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true); // Make the private method accessible

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, result, index);
            
            // Check that the returned index is correct
            assertEquals(1, newIndex); // index + 1 should equal 1
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception in case of reflection failure or other issues
        }

        // Assert that the result does not contain 'A' when index is 0
        assertEquals("", result.toString()); // Ensure result is empty when index is 0
    }

}