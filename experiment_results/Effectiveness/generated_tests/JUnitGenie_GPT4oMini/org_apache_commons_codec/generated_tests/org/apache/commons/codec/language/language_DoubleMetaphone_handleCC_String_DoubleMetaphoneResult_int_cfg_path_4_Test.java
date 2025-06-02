package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleCC_String_DoubleMetaphoneResult_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHandleCC() {
        try {
            // Arrange
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an integer argument
            String value = "accident"; // This should trigger the "KS" append
            int index = 1;

            // Access the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Act
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Assert
            assertEquals(4, newIndex); // The expected new index after processing
            assertEquals("KS", result.toString()); // Check if "KS" was appended

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}