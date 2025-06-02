package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleSC_String_DoubleMetaphoneResult_int_cfg_path_7_Test {
    @Test(timeout = 4000)
    public void testHandleSC() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an enclosing instance
        
        String value = "HARD";
        int index = 0; // 'H' is at index 0, valid and meets constraints
        
        try {
            // Access the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true); // Allow access to private method
            
            int returnValue = (int) method.invoke(doubleMetaphone, value, result, index);

            // Change in result object to check if 'S' was appended
            assertEquals("S", result.getPrimary()); // Corrected method to get the primary character
            
            assertEquals(index + 3, returnValue); // Verify the return value is correct
            
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions for test details
        }
    }

}