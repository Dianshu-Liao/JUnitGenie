package org.apache.commons.lang3.text.translate;
import org.apache.commons.lang3.text.translate.OctalUnescaper;
import org.junit.Test;
import java.io.StringWriter;
import java.io.Writer;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class text_translate_OctalUnescaper_translate_CharSequence_int_Writer_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testTranslateWithValidInput() {
        OctalUnescaper unescaper = new OctalUnescaper();
        CharSequence input = "\\123"; // Octal representation of 83 (ASCII for 'S')
        int index = 0;
        Writer out = new StringWriter();
        
        try {
            int result = unescaper.translate(input, index, out);
            assertEquals(3, result); // 3 characters processed
            assertEquals(83, out.toString().charAt(0)); // Check if the output is correct
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTranslateWithNoOctal() {
        OctalUnescaper unescaper = new OctalUnescaper();
        CharSequence input = "NoOctalHere";
        int index = 0;
        Writer out = new StringWriter();
        
        try {
            int result = unescaper.translate(input, index, out);
            assertEquals(0, result); // No characters processed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTranslateWithInvalidOctal() {
        OctalUnescaper unescaper = new OctalUnescaper();
        CharSequence input = "\\8"; // Invalid octal
        int index = 0;
        Writer out = new StringWriter();
        
        try {
            int result = unescaper.translate(input, index, out);
            assertEquals(1, result); // 1 character processed (the backslash)
            assertEquals("", out.toString()); // No valid output
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTranslateWithIncompleteOctal() {
        OctalUnescaper unescaper = new OctalUnescaper();
        CharSequence input = "\\12"; // Octal representation of 10 (ASCII for newline)
        int index = 0;
        Writer out = new StringWriter();
        
        try {
            int result = unescaper.translate(input, index, out);
            assertEquals(2, result); // 2 characters processed
            assertEquals(10, out.toString().charAt(0)); // Check if the output is correct
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}