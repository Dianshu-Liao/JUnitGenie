package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_DefaultXmlPrettyPrinter_withCustomNewLine_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithCustomNewLine_NullInput() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        printer.withCustomNewLine(null);
        // Verify that _newLine is set to SYSTEM_DEFAULT_NEW_LINE
        assertEquals("Expected _newLine to be SYSTEM_DEFAULT_NEW_LINE", 
                     "SYSTEM_DEFAULT_NEW_LINE", 
                     getFieldValue(printer, "_newLine"));
    }

    @Test(timeout = 4000)
    public void testWithCustomNewLine_ValidInput() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        String customNewLine = "\n";
        printer.withCustomNewLine(customNewLine);
        // Verify that _newLine is set to the custom new line
        assertEquals("Expected _newLine to be the custom new line", 
                     customNewLine, 
                     getFieldValue(printer, "_newLine"));
    }

    // Helper method to access the protected field _newLine using reflection
    private String getFieldValue(DefaultXmlPrettyPrinter printer, String fieldName) {
        try {
            java.lang.reflect.Field field = DefaultXmlPrettyPrinter.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(printer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to access field value", e);
        }
    }

}