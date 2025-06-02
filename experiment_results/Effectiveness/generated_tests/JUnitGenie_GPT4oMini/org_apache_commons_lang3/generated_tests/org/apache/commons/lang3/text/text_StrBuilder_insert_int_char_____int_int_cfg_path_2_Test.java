package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInsertWithInvalidOffset() {
        StrBuilder strBuilder = new StrBuilder();
        char[] chars = {'a', 'b', 'c'};
        int index = 0;
        int offset = 5; // Invalid offset
        int length = 2;

        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid offset: 5", e.getMessage());
        }
    }

}