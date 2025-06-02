package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.LinkOption;
import java.nio.file.attribute.FileTime;
import java.io.IOException;
import static org.junit.Assert.*;

public class archivers_cpio_CpioArchiveEntry__init__short_Path_String_LinkOption_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testCpioArchiveEntry_RegularFile() {
        try {
            // Setup
            short format = 1; // Example format
            Path inputPath = Paths.get("path/to/regular/file.txt"); // Ensure this path points to a valid regular file
            String entryName = "file.txt";
            LinkOption[] options = new LinkOption[]{};

            // Create the CpioArchiveEntry
            CpioArchiveEntry entry = new CpioArchiveEntry(format, inputPath, entryName, options);

            // Assertions can be added here to verify the state of the entry if needed
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCpioArchiveEntry_Directory() {
        try {
            // Setup
            short format = 1; // Example format
            Path inputPath = Paths.get("path/to/directory"); // Ensure this path points to a valid directory
            String entryName = "directory";
            LinkOption[] options = new LinkOption[]{};

            // Create the CpioArchiveEntry
            CpioArchiveEntry entry = new CpioArchiveEntry(format, inputPath, entryName, options);

            // Assertions can be added here to verify the state of the entry if needed
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCpioArchiveEntry_InvalidPath() {
        try {
            // Setup
            short format = 1; // Example format
            Path inputPath = Paths.get("path/to/invalid/file.txt"); // Ensure this path does not exist
            String entryName = "invalid.txt";
            LinkOption[] options = new LinkOption[]{};

            // Create the CpioArchiveEntry
            CpioArchiveEntry entry = new CpioArchiveEntry(format, inputPath, entryName, options);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        }
    }

}