package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleZ_String_DoubleMetaphoneResult_int_boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testHandleZ_withHCharacter() {
        try {
            // Arrange
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an integer
            String value = "Hannah";
            int index = 0;
            boolean slavoGermanic = false;

            // Act
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphoneResult.class, int.class, boolean.class);
            method.setAccessible(true);
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index, slavoGermanic);

            // Assert
            assertEquals(2, newIndex);
            // Additional assertions can be made on the result object if needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHandleZ_withNonHCharacter() {
        try {
            // Arrange
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an integer
            String value = "Zebra";
            int index = 0;
            boolean slavoGermanic = false;

            // Act
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphoneResult.class, int.class, boolean.class);
            method.setAccessible(true);
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index, slavoGermanic);

            // Assert
            assertEquals(1, newIndex);
            // Additional assertions can be made on the result object if needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}