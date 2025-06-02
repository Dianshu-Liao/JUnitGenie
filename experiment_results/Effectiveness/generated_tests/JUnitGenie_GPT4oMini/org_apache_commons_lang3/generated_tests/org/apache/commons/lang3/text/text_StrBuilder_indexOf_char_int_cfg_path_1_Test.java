package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_indexOf_char_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIndexOfWithStartIndexGreaterThanSize() {
        StrBuilder strBuilder = new StrBuilder("example");
        strBuilder.size = 7; // Set size to match the length of the string
        int result = strBuilder.indexOf('e', 10); // startIndex is greater than size
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOfWithNegativeStartIndex() {
        StrBuilder strBuilder = new StrBuilder("example");
        strBuilder.size = 7; // Set size to match the length of the string
        int result = strBuilder.indexOf('e', -5); // startIndex is negative
        assertEquals(0, result); // Should return the index of the first occurrence
    }

}