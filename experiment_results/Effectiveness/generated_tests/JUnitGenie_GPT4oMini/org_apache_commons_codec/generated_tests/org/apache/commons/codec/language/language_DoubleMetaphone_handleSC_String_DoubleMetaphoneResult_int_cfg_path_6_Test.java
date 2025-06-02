package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleSC_String_DoubleMetaphoneResult_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testHandleSC() {
        try {
            // Arrange
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            String value = "HOOH"; // 'H' at index 0
            int index = 0;

            // Access the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Create an instance of DoubleMetaphoneResult using the constructor
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Use the enclosing instance

            // Act
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Assert
            assertEquals(3, newIndex);
            // Check the result for expected output
            // The expected output should be 'X' based on the logic in handleSC
            assertEquals("X", result.getPrimary());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}