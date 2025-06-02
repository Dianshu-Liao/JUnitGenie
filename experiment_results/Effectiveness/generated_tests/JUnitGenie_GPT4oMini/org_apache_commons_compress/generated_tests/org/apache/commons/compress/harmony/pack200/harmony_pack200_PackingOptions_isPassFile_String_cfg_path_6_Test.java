package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class harmony_pack200_PackingOptions_isPassFile_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testIsPassFile() {
        // Arrange
        PackingOptions packingOptions = new PackingOptions();
        
        // Use a method to add pass files instead of accessing the private field directly
        packingOptions.addPassFile("testFile.class");
        packingOptions.addPassFile("testDir/");
        packingOptions.addPassFile("anotherDir/");

        // Act & Assert
        // Test for a file that matches exactly
        assertTrue(packingOptions.isPassFile("testFile.class"));

        // Test for a directory match
        assertTrue(packingOptions.isPassFile("testDir/someFile.txt"));

        // Test for a non-matching file
        assertFalse(packingOptions.isPassFile("nonExistentFile.class"));

        // Test for a non-matching directory
        assertFalse(packingOptions.isPassFile("nonExistentDir/someFile.txt"));
    }


}