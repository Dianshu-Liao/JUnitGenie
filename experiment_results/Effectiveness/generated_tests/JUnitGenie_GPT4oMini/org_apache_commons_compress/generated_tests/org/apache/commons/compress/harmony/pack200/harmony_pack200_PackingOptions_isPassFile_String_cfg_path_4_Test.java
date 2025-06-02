package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class harmony_pack200_PackingOptions_isPassFile_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsPassFile() {
        // Setup
        PackingOptions packingOptions = new PackingOptions();
        
        // Assuming PackingOptions has a method to add pass files since passFiles is private
        packingOptions.addPassFile("testFile.class");
        packingOptions.addPassFile("testDir/");
        packingOptions.addPassFile("anotherDir/");

        // Test case 1: Check for a file that matches exactly
        String passFileName1 = "testFile.class";
        boolean result1 = packingOptions.isPassFile(passFileName1);
        assertTrue(result1);

        // Test case 2: Check for a directory match
        String passFileName2 = "testDir/someFile.txt";
        boolean result2 = packingOptions.isPassFile(passFileName2);
        assertTrue(result2);

        // Test case 3: Check for a non-matching file
        String passFileName3 = "nonExistentFile.class";
        boolean result3 = packingOptions.isPassFile(passFileName3);
        assertFalse(result3);

        // Test case 4: Check for a non-matching directory
        String passFileName4 = "anotherDir/someFile.txt";
        boolean result4 = packingOptions.isPassFile(passFileName4);
        assertTrue(result4);

        // Test case 5: Check for a file that does not match any entry
        String passFileName5 = "randomFile.txt";
        boolean result5 = packingOptions.isPassFile(passFileName5);
        assertFalse(result5);
    }


}