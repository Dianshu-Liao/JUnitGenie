package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_chomp_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testChomp_SingleCharacter() {
        // Test with a single character that is not CR or LF
        String result = StringUtils.chomp("a");
        assertEquals("a", result);

        // Test with LF character
        result = StringUtils.chomp("\n");
        assertEquals("", result);

        // Test with CR character
        result = StringUtils.chomp("\r");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testChomp_TwoCharacters() {
        // Test with two characters, one being CR and the other being LF
        String result = StringUtils.chomp("\r\n");
        assertEquals("", result);

        // Test with two characters that are neither CR nor LF
        result = StringUtils.chomp("ab");
        assertEquals("ab", result);
    }

    @Test(timeout = 4000)
    public void testChomp_EmptyString() {
        // Test with empty string
        String result = StringUtils.chomp("");
        assertEquals("", result);
    }
    
    @Test(timeout = 4000)
    public void testChomp_Null() {
        // Test with null to ensure that isEmpty handles it
        String result;
        try {
            result = StringUtils.chomp(null);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle exception or assert if necessary
        }
    }

}