package org.apache.commons.csv;
import org.apache.commons.csv.Lexer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Lexer_isMetaChar_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsMetaChar() throws Exception {
        // Arrange
        int escapeValue = 92; // Example value for escape
        int quoteCharValue = 34; // Example value for quoteChar
        int commentStartValue = 35; // Example value for commentStart

        // Create a StringReader to pass to ExtendedBufferedReader
        StringReader stringReader = new StringReader("test data");
        ExtendedBufferedReader bufferedReader = new ExtendedBufferedReader(stringReader);
        
        Lexer lexer = new Lexer(CSVFormat.DEFAULT, bufferedReader);
        
        // Use reflection to access the private fields
        java.lang.reflect.Field escapeField = Lexer.class.getDeclaredField("escape");
        escapeField.setAccessible(true);
        escapeField.setInt(lexer, escapeValue);
        
        java.lang.reflect.Field quoteCharField = Lexer.class.getDeclaredField("quoteChar");
        quoteCharField.setAccessible(true);
        quoteCharField.setInt(lexer, quoteCharValue);
        
        java.lang.reflect.Field commentStartField = Lexer.class.getDeclaredField("commentStart");
        commentStartField.setAccessible(true);
        commentStartField.setInt(lexer, commentStartValue);

        // Access the private method using reflection
        Method isMetaCharMethod = Lexer.class.getDeclaredMethod("isMetaChar", int.class);
        isMetaCharMethod.setAccessible(true);

        // Act & Assert
        // Test for escape character
        assertTrue((Boolean) isMetaCharMethod.invoke(lexer, escapeValue));
        
        // Test for quote character
        assertTrue((Boolean) isMetaCharMethod.invoke(lexer, quoteCharValue));
        
        // Test for comment start character
        assertTrue((Boolean) isMetaCharMethod.invoke(lexer, commentStartValue));
        
        // Test for a character that is not a meta character
        assertFalse((Boolean) isMetaCharMethod.invoke(lexer, 100)); // Example non-meta character
    }


}