package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import static org.junit.Assert.*;

public class archivers_tar_TarArchiveEntry__init__String_boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParams() {
        String name = "testFile.txt";
        boolean preserveAbsolutePath = false;

        try {
            TarArchiveEntry entry = new TarArchiveEntry(name, preserveAbsolutePath);
            assertNotNull(entry);
            assertEquals(name, entry.getName()); // Using getter method
            assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode()); // Using getter method
            assertEquals(TarArchiveEntry.LF_NORMAL, entry.getLinkFlag()); // Using getter method
            // Corrected method to get last modified time
            assertTrue(entry.getLastModifiedDate().toInstant().compareTo(Instant.now()) <= 0); 
            assertEquals("", entry.getUserName()); // Using getter method
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorAsDirectory() {
        String dirName = "testDirectory/";
        boolean preserveAbsolutePath = true;

        try {
            TarArchiveEntry entry = new TarArchiveEntry(dirName, preserveAbsolutePath);
            assertNotNull(entry);
            assertEquals(dirName, entry.getName()); // Using getter method
            assertEquals(TarArchiveEntry.DEFAULT_DIR_MODE, entry.getMode()); // Using getter method
            assertEquals(TarArchiveEntry.LF_DIR, entry.getLinkFlag()); // Using getter method
            // Corrected method to get last modified time
            assertTrue(entry.getLastModifiedDate().toInstant().compareTo(Instant.now()) <= 0); 
            assertEquals("", entry.getUserName()); // Using getter method
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }

}