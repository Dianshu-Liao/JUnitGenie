package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_PackingOptions_setDeflateHint_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetDeflateHint_WithValidValue_Keep() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint("keep");
        assertEquals("keep", options.getDeflateHint()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetDeflateHint_WithValidValue_True() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint("true");
        assertEquals("true", options.getDeflateHint()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetDeflateHint_WithValidValue_False() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint("false");
        assertEquals("false", options.getDeflateHint()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetDeflateHint_WithInvalidValue_ShouldThrowException() {
        PackingOptions options = new PackingOptions();
        try {
            options.setDeflateHint("invalid");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Exception is expected
            assertEquals("Bad argument: -H invalid ? deflate hint should be either true, false or keep (default)", e.getMessage());
        }
    }


}