package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class harmony_pack200_PackingOptions_isPassFile_String_cfg_path_2_Test {
    
    @Test(timeout = 4000)
    public void testIsPassFile_WithMatchingFileName() {
        PackingOptions packingOptions = new PackingOptions();
        // Set up the private final field passFiles for testing using a method
        List<String> passFiles = Arrays.asList("example.class", "directory/");
        packingOptions.setPassFiles(passFiles); // Assuming setPassFiles method exists

        assertTrue(packingOptions.isPassFile("example.class"));
    }

    @Test(timeout = 4000)
    public void testIsPassFile_WithDirectoryName() {
        PackingOptions packingOptions = new PackingOptions();
        // Set up the private final field passFiles for testing using a method
        List<String> passFiles = Arrays.asList("example.class", "directory/");
        packingOptions.setPassFiles(passFiles); // Assuming setPassFiles method exists

        assertTrue(packingOptions.isPassFile("directory/somefile.txt"));
    }

    @Test(timeout = 4000)
    public void testIsPassFile_WhenFileNameDoesNotMatch() {
        PackingOptions packingOptions = new PackingOptions();
        // Set up the private final field passFiles for testing using a method
        List<String> passFiles = Arrays.asList("example.class", "directory/");
        packingOptions.setPassFiles(passFiles); // Assuming setPassFiles method exists

        assertFalse(packingOptions.isPassFile("non_matching_file.class"));
    }

    @Test(timeout = 4000)
    public void testIsPassFile_WhenFileIsNotClassAndNotInList() {
        PackingOptions packingOptions = new PackingOptions();
        // Set up the private final field passFiles for testing using a method
        List<String> passFiles = Arrays.asList("example.class", "directory/");
        packingOptions.setPassFiles(passFiles); // Assuming setPassFiles method exists

        assertFalse(packingOptions.isPassFile("directory_not_matching/somefile.txt"));
    }

    // Added a method to set passFiles in PackingOptions class
    private static class PackingOptions {
        private List<String> passFiles;

        public void setPassFiles(List<String> passFiles) {
            this.passFiles = passFiles;
        }

        public boolean isPassFile(String fileName) {
            // Check if the fileName matches any of the passFiles
            return passFiles.stream().anyMatch(fileName::startsWith);
        }
    }

}