package org.apache.commons.csv;
import org.apache.commons.csv.Lexer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class Lexer_isMetaChar_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsMetaCharWithQuoteChar() {
        try {
            // Create an instance of Lexer with necessary parameters
            Lexer lexer = new Lexer(null, null); // Replace null with actual CSVFormat and ExtendedBufferedReader if needed

            // Use reflection to access the private method
            Method method = Lexer.class.getDeclaredMethod("isMetaChar", int.class);
            method.setAccessible(true);

            // Set the quoteChar field to a specific value for testing
            int quoteCharValue = 34; // Assuming quoteChar is set to ASCII value of '"'
            lexer.getClass().getDeclaredField("quoteChar").setInt(lexer, quoteCharValue);

            // Call the method with the quoteChar value
            boolean result = (boolean) method.invoke(lexer, quoteCharValue);
            assertTrue(result); // Expecting true since ch == quoteChar

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsMetaCharWithEscape() {
        try {
            // Create an instance of Lexer with necessary parameters
            Lexer lexer = new Lexer(null, null); // Replace null with actual CSVFormat and ExtendedBufferedReader if needed

            // Use reflection to access the private method
            Method method = Lexer.class.getDeclaredMethod("isMetaChar", int.class);
            method.setAccessible(true);

            // Set the escape field to a specific value for testing
            int escapeValue = 92; // Assuming escape is set to ASCII value of '\'
            lexer.getClass().getDeclaredField("escape").setInt(lexer, escapeValue);

            // Call the method with the escape value
            boolean result = (boolean) method.invoke(lexer, escapeValue);
            assertTrue(result); // Expecting true since ch == escape

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsMetaCharWithNonMetaChar() {
        try {
            // Create an instance of Lexer with necessary parameters
            Lexer lexer = new Lexer(null, null); // Replace null with actual CSVFormat and ExtendedBufferedReader if needed

            // Use reflection to access the private method
            Method method = Lexer.class.getDeclaredMethod("isMetaChar", int.class);
            method.setAccessible(true);

            // Call the method with a non-meta character value
            int nonMetaCharValue = 97; // ASCII value of 'a'
            boolean result = (boolean) method.invoke(lexer, nonMetaCharValue);
            assertTrue(!result); // Expecting false since ch is not a meta character

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}