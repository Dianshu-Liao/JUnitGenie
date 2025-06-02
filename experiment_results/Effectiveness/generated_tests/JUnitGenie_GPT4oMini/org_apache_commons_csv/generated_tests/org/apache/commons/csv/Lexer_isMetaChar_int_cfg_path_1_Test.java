package org.apache.commons.csv;
import org.apache.commons.csv.Lexer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class Lexer_isMetaChar_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsMetaChar() {
        try {
            // Create an instance of Lexer
            CSVFormat format = CSVFormat.DEFAULT;
            // Create a StringReader to provide input to ExtendedBufferedReader
            StringReader stringReader = new StringReader("test input");
            ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

            Lexer lexer = new Lexer(format, reader);

            // Access the private method isMetaChar using reflection
            Method method = Lexer.class.getDeclaredMethod("isMetaChar", int.class);
            method.setAccessible(true);

            // Set the private final fields for testing
            int escape = 92; // Example value for escape
            int quoteChar = 34; // Example value for quoteChar
            int commentStart = 35; // Example value for commentStart

            // Use reflection to set the private fields
            java.lang.reflect.Field escapeField = Lexer.class.getDeclaredField("escape");
            escapeField.setAccessible(true);
            escapeField.setInt(lexer, escape);

            java.lang.reflect.Field quoteCharField = Lexer.class.getDeclaredField("quoteChar");
            quoteCharField.setAccessible(true);
            quoteCharField.setInt(lexer, quoteChar);

            java.lang.reflect.Field commentStartField = Lexer.class.getDeclaredField("commentStart");
            commentStartField.setAccessible(true);
            commentStartField.setInt(lexer, commentStart);

            // Test the method with a value that is not a meta character
            boolean result = (boolean) method.invoke(lexer, 100); // 100 is not escape, quoteChar, or commentStart
            assertFalse(result); // Expecting false since 100 is not a meta character

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}