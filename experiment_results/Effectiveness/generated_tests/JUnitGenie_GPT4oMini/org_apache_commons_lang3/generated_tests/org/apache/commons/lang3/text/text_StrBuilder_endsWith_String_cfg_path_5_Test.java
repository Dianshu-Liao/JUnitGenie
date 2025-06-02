package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_StrBuilder_endsWith_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEndsWith_NullString() {
        StrBuilder strBuilder = new StrBuilder(5); // Initialize with size greater than 0
        boolean result = strBuilder.endsWith(null);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEndsWith_EmptyString() {
        StrBuilder strBuilder = new StrBuilder(5); // Initialize with size greater than 0
        boolean result = strBuilder.endsWith("");
        assertFalse(result); // Since size is greater than 0, it should return false
    }

    @Test(timeout = 4000)
    public void testEndsWith_StringLongerThanSize() {
        StrBuilder strBuilder = new StrBuilder(5); // Initialize with size 5
        boolean result = strBuilder.endsWith("longer");
        assertFalse(result); // The string is longer than the size of StrBuilder
    }

}