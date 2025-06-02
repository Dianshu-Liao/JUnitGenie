package org.apache.commons.compress.archivers.cpio;
import static org.junit.Assert.*;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.attribute.FileTime;

public class archivers_cpio_CpioArchiveEntry__init__short_Path_String_LinkOption_____cfg_path_5_Test {
    
    @Test(timeout = 4000)
    public void testCpioArchiveEntryValidFile() {
        try {
            short format = 1;
            Path inputPath = Files.createTempFile("testFile", ".tmp");
            String entryName = "testEntry";
            LinkOption[] options = new LinkOption[]{};

            CpioArchiveEntry entry = new CpioArchiveEntry(format, inputPath, entryName, options);

            assertNotNull(entry);
            assertEquals(entryName, entry.getName());
            
            // Clean up the temp file
            Files.deleteIfExists(inputPath);
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCpioArchiveEntryInvalidPath() throws IOException {
        short format = 1;
        Path invalidPath = Files.createTempDirectory("invalid").resolve("invalid/path"); // Corrected to create a valid Path
        String entryName = "testEntry";
        LinkOption[] options = new LinkOption[]{};

        CpioArchiveEntry entry = new CpioArchiveEntry(format, invalidPath, entryName, options);
    }

    @Test(timeout = 4000)
    public void testCpioArchiveEntryDirectory() {
        try {
            short format = 1;
            Path dirPath = Files.createTempDirectory("testDir");
            String entryName = "testDirEntry";
            LinkOption[] options = new LinkOption[]{};

            CpioArchiveEntry entry = new CpioArchiveEntry(format, dirPath, entryName, options);
            assertNotNull(entry);

            // Validate the mode for directory
            // Assuming there is a method getMode to verify the mode
            assertEquals(CpioArchiveEntry.C_ISDIR, entry.getMode());
            
            // Clean up the temp directory
            Files.delete(dirPath);
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCpioArchiveEntrySetMode() {
        try {
            short format = 1;
            Path inputPath = Files.createTempFile("testFile", ".tmp");
            String entryName = "testEntry";
            LinkOption[] options = new LinkOption[]{};

            CpioArchiveEntry entry = new CpioArchiveEntry(format, inputPath, entryName, options);
            entry.setMode(32768L); // Set the mode to the required value for testing
            assertEquals(32768L, entry.getMode());

            // Clean up the temp file
            Files.deleteIfExists(inputPath);
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCpioArchiveEntrySetTime() {
        try {
            short format = 1;
            Path inputPath = Files.createTempFile("testFile", ".tmp");
            String entryName = "testEntry";
            LinkOption[] options = new LinkOption[]{};

            CpioArchiveEntry entry = new CpioArchiveEntry(format, inputPath, entryName, options);
            FileTime fileTime = Files.getLastModifiedTime(inputPath);

            entry.setTime(fileTime);
            // Additional asserts can be added if there's a way to verify the time

            // Clean up the temp file
            Files.deleteIfExists(inputPath);
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        }
    }


}