package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleSC_String_DoubleMetaphoneResult_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHandleSC() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Prepare the parameters for the method
            String value = "SCHOOL";
            int index = 0;

            // Access the private method handleSC using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, index);

            // Assert the expected results
            assertEquals(3, newIndex);
            // Corrected the method to get the primary value from the DoubleMetaphone instance
            String primary = doubleMetaphone.doubleMetaphone(value); // Use doubleMetaphone method to get primary
            assertEquals("X", primary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}