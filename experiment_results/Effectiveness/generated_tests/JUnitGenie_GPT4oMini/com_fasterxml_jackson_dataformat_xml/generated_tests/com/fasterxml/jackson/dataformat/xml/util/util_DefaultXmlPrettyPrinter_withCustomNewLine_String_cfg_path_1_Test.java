package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_DefaultXmlPrettyPrinter_withCustomNewLine_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithCustomNewLine_NullInput() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        printer.withCustomNewLine(null);
        // Assuming access to SYSTEM_DEFAULT_NEW_LINE, we can retrieve it via reflection if needed
        try {
            java.lang.reflect.Field defaultNewLineField = DefaultXmlPrettyPrinter.class.getDeclaredField("SYSTEM_DEFAULT_NEW_LINE");
            defaultNewLineField.setAccessible(true);
            String systemDefaultNewLine = (String) defaultNewLineField.get(null);
            assertEquals(systemDefaultNewLine, printer._newLine);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWithCustomNewLine_ValidInput() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        String customNewLine = "\n";
        printer.withCustomNewLine(customNewLine);
        assertEquals(customNewLine, printer._newLine);
    }

}