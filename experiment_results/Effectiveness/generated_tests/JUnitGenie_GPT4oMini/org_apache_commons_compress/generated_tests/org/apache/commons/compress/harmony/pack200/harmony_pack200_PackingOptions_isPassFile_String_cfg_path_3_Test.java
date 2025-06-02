package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class harmony_pack200_PackingOptions_isPassFile_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsPassFileWithMatchingFileName() {
        PackingOptions packingOptions = new PackingOptions();
        // Assuming passFiles is initialized with some values
        packingOptions.addPassFile("example.class");
        assertTrue(packingOptions.isPassFile("example.class"));
    }

    @Test(timeout = 4000)
    public void testIsPassFileWithDirectory() {
        PackingOptions packingOptions = new PackingOptions();
        // Assuming passFiles is initialized with some values
        packingOptions.addPassFile("example/");
        assertTrue(packingOptions.isPassFile("example/test.txt"));
    }

    @Test(timeout = 4000)
    public void testIsPassFileWithNonMatchingFileName() {
        PackingOptions packingOptions = new PackingOptions();
        // Assuming passFiles is initialized with some values
        packingOptions.addPassFile("example.class");
        assertFalse(packingOptions.isPassFile("notexample.class"));
    }

    @Test(timeout = 4000)
    public void testIsPassFileWithNonMatchingDirectory() {
        PackingOptions packingOptions = new PackingOptions();
        // Assuming passFiles is initialized with some values
        packingOptions.addPassFile("example/");
        assertFalse(packingOptions.isPassFile("other/test.txt"));
    }


}