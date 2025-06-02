package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleH_String_DoubleMetaphoneResult_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHandleH() {
        try {
            // Arrange
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an integer argument
            String value = "AHOHA"; // Example string
            int index = 0; // Starting index

            // Act
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleH", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Assert
            assertEquals(2, newIndex); // Expecting index to be incremented by 2

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}