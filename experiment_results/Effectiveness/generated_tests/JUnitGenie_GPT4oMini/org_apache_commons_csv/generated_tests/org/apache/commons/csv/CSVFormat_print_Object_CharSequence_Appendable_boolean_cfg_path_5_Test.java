package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import java.io.StringWriter;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class CSVFormat_print_Object_CharSequence_Appendable_boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testPrintWithQuoteAndEscapeCharacterSet() throws Exception {
        // Arrange
        CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setQuote('"') // Changed from setQuoteCharacter to setQuote
                    .setEscape('\\') // Changed from setEscapeCharacter to setEscape
                    .build();
        
        CharSequence value = "Test Value";
        StringWriter out = new StringWriter();
        boolean newRecord = false;

        // Accessing the private method using reflection
        Method printMethod = CSVFormat.class.getDeclaredMethod("print", Object.class, CharSequence.class, Appendable.class, boolean.class);
        printMethod.setAccessible(true);

        // Act
        printMethod.invoke(format, null, value, out, newRecord);

        // Assert
        assertEquals("Expected output does not match.", "Test Value", out.toString());
    }


}