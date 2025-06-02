package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_PackingOptions_setDeflateHint_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetDeflateHintWithValidHint() {
        PackingOptions options = new PackingOptions();
        String validHint = "keep";
        
        options.setDeflateHint(validHint);
        
        assertEquals(validHint, options.getDeflateHint()); // Use getter method to access deflateHint
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDeflateHintWithInvalidHint() {
        PackingOptions options = new PackingOptions();
        String invalidHint = "invalid";
        
        try {
            options.setDeflateHint(invalidHint);
        } catch (IllegalArgumentException e) {
            assertEquals("Bad argument: -H invalid ? deflate hint should be either true, false or keep (default)", e.getMessage());
            throw e; // rethrow to satisfy the expected exception
        }
    }

    @Test(timeout = 4000)
    public void testSetDeflateHintWithTrue() {
        PackingOptions options = new PackingOptions();
        String validHint = "true";
        
        options.setDeflateHint(validHint);
        
        assertEquals(validHint, options.getDeflateHint()); // Use getter method to access deflateHint
    }

    @Test(timeout = 4000)
    public void testSetDeflateHintWithFalse() {
        PackingOptions options = new PackingOptions();
        String validHint = "false";
        
        options.setDeflateHint(validHint);
        
        assertEquals(validHint, options.getDeflateHint()); // Use getter method to access deflateHint
    }


}