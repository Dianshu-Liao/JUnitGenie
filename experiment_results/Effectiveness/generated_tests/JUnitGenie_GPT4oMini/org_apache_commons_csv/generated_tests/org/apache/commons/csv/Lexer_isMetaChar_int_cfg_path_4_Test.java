package org.apache.commons.csv;
import org.apache.commons.csv.Lexer;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Lexer_isMetaChar_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsMetaCharWithEscape() {
        try {
            // Create an instance of Lexer
            Lexer lexer = new Lexer(null, null); // Assuming CSVFormat and ExtendedBufferedReader are not needed for this test

            // Access the private method isMetaChar using reflection
            Method method = Lexer.class.getDeclaredMethod("isMetaChar", int.class);
            method.setAccessible(true);

            // Get the value of the private final field 'escape'
            java.lang.reflect.Field escapeField = Lexer.class.getDeclaredField("escape");
            escapeField.setAccessible(true);
            int escapeValue = (int) escapeField.get(lexer);

            // Invoke the method with the escape value
            boolean result = (boolean) method.invoke(lexer, escapeValue);

            // Assert that the result is true
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}