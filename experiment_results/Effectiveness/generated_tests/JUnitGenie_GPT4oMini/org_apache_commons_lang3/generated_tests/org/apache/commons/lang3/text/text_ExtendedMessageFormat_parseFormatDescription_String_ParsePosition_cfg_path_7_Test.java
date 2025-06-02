package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import java.text.ParsePosition;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_ExtendedMessageFormat_parseFormatDescription_String_ParsePosition_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testParseFormatDescription_UndenotedFormatElement() {
        try {
            // Instantiate the class to access the private method
            ExtendedMessageFormat format = new ExtendedMessageFormat("format");
            
            // Prepare the input parameters
            String pattern = "Invalid pattern without closures";
            ParsePosition pos = new ParsePosition(0);
            
            // Access the private method using reflection
            java.lang.reflect.Method method = ExtendedMessageFormat.class.getDeclaredMethod("parseFormatDescription", String.class, ParsePosition.class);
            method.setAccessible(true);
            
            // Attempt to invoke the method, expecting an IllegalArgumentException
            method.invoke(format, pattern, pos);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Unterminated format element at position"));
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

}