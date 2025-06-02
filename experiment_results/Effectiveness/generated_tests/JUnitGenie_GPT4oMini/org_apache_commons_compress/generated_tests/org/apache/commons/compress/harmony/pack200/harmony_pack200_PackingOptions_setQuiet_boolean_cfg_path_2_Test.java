package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class harmony_pack200_PackingOptions_setQuiet_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetQuietTrue() {
        PackingOptions options = new PackingOptions();
        options.setQuiet(true);
        // Verify that verbose is set to false when quiet is true
        assertFalse("Expected verbose to be false when quiet is true", options.isVerbose());
    }

    @Test(timeout = 4000)
    public void testSetQuietFalse() {
        PackingOptions options = new PackingOptions();
        options.setQuiet(false);
        // Verify that verbose is set to true when quiet is false
        assertTrue("Expected verbose to be true when quiet is false", options.isVerbose());
    }


}