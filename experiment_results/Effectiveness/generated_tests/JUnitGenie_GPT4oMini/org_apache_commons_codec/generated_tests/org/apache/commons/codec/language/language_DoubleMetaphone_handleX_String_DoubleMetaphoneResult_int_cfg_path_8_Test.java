package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleX_String_DoubleMetaphoneResult_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testHandleX() {
        try {
            // Arrange
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            String value = "example";
            int index = 1; // This will trigger the else branch
            
            // Correctly instantiate the DoubleMetaphoneResult object with the required argument
            DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Create a new instance with an integer argument

            // Access the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Act
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Assert
            assertEquals(2, newIndex); // Expecting index to be incremented by 1
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}