package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_PackingOptions_setDeflateHint_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSetDeflateHint_ValidInput_Keep() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint("keep");
        assertEquals("keep", options.getDeflateHint()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetDeflateHint_ValidInput_True() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint("true");
        assertEquals("true", options.getDeflateHint()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetDeflateHint_ValidInput_False() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint("false");
        assertEquals("false", options.getDeflateHint()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetDeflateHint_InvalidInput() {
        PackingOptions options = new PackingOptions();
        try {
            options.setDeflateHint("invalid");
            fail("Expected IllegalArgumentException for invalid input");
        } catch (IllegalArgumentException e) {
            assertEquals("Bad argument: -H invalid ? deflate hint should be either true, false or keep (default)", e.getMessage());
        }
    }


}