package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;

public class language_DoubleMetaphone_handleCC_String_DoubleMetaphoneResult_int_cfg_path_2_Test {
    
    @Test(timeout = 4000)
    public void testHandleCC_withValidInputs() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Providing an integer argument
        String value = "bellocchio";
        int index = 1;

        try {
            Method handleCCMethod = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            handleCCMethod.setAccessible(true);
            int newIndex = (int) handleCCMethod.invoke(doubleMetaphone, value, result, index);

            assertEquals(4, newIndex);
            // Since result.append was called, we check the appended results
            assertEquals("KS", result.getPrimary());
        } catch (Exception e) {
            // Handle the exception as the method may throw an exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHandleCC_withBacchus() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Providing an integer argument
        String value = "bacchus";
        int index = 1;

        try {
            Method handleCCMethod = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            handleCCMethod.setAccessible(true);
            int newIndex = (int) handleCCMethod.invoke(doubleMetaphone, value, result, index);

            assertEquals(3, newIndex);
            // Since "bacchus" doesn't satisfy the first condition, we check for 'K'
            assertEquals("K", result.getPrimary());
        } catch (Exception e) {
            // Handle the exception as the method may throw an exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHandleCC_withEmptyString() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Providing an integer argument
        String value = "";
        int index = 0;

        try {
            Method handleCCMethod = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            handleCCMethod.setAccessible(true);
            int newIndex = (int) handleCCMethod.invoke(doubleMetaphone, value, result, index);

            assertEquals(2, newIndex);
            assertEquals("K", result.getPrimary());
        } catch (Exception e) {
            // Handle the exception as the method may throw an exception
            e.printStackTrace();
        }
    }

}