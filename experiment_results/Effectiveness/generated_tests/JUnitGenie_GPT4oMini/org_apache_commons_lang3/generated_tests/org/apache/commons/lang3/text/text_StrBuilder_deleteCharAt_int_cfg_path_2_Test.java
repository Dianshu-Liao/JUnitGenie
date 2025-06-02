package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_deleteCharAt_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDeleteCharAt_IndexOutOfBoundsNegative() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        try {
            strBuilder.deleteCharAt(-1);
            fail("Expected StringIndexOutOfBoundsException for negative index");
        } catch (StringIndexOutOfBoundsException e) {
            // Use the message of the exception to check for the index
            assertTrue(e.getMessage().contains("Index: -1"));
        }
    }

    @Test(timeout = 4000)
    public void testDeleteCharAt_IndexOutOfBoundsTooLarge() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        try {
            strBuilder.deleteCharAt(5);
            fail("Expected StringIndexOutOfBoundsException for index too large");
        } catch (StringIndexOutOfBoundsException e) {
            // Use the message of the exception to check for the index
            assertTrue(e.getMessage().contains("Index: 5"));
        }
    }


}