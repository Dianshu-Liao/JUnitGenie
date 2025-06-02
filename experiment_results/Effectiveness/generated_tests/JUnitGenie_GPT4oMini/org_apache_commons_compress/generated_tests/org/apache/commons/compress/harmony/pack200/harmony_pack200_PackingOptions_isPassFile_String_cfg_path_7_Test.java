package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class harmony_pack200_PackingOptions_isPassFile_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testIsPassFile() {
        // Arrange
        PackingOptions packingOptions = new PackingOptions();
        // Assuming passFiles is populated with some test data
        // Use a method to add files to passFiles since it has private access
        packingOptions.addPassFile("testFile.class");
        packingOptions.addPassFile("testDir/");
        packingOptions.addPassFile("anotherFile.class");

        // Act & Assert
        // Test case where passFileName matches an entry in passFiles
        try {
            assertTrue(packingOptions.isPassFile("testFile.class"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test case where passFileName starts with a directory in passFiles
        try {
            assertTrue(packingOptions.isPassFile("testDir/someFile.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test case where passFileName does not match any entry in passFiles
        try {
            assertFalse(packingOptions.isPassFile("nonExistentFile.class"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}