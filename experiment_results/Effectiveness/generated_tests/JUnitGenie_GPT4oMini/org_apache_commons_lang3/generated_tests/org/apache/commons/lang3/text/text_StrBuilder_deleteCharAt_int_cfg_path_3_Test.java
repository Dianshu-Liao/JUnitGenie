package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_deleteCharAt_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testDeleteCharAt_ValidIndex() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        strBuilder.deleteCharAt(1); // Deleting character at index 1 ('e')
        assertEquals("Hllo", strBuilder.toString());
    }

    @Test(timeout = 4000)
    public void testDeleteCharAt_IndexOutOfBounds_Negative() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        try {
            strBuilder.deleteCharAt(-1);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("-1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDeleteCharAt_IndexOutOfBounds_TooLarge() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        try {
            strBuilder.deleteCharAt(5); // Index 5 is out of bounds for size 5
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("5", e.getMessage());
        }
    }

}