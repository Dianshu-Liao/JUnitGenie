package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_tar_TarArchiveEntry__init__String_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        String name = "testFile.txt";
        boolean preserveAbsolutePath = false;

        TarArchiveEntry entry = new TarArchiveEntry(name, preserveAbsolutePath);

        // Validate the internal state of the TarArchiveEntry using public methods
        assertEquals("testFile.txt", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode());
        assertEquals(TarArchiveEntry.LF_NORMAL, entry.getLinkFlag());
        assertNotNull(entry.getLastModifiedDate()); // Changed to getLastModifiedDate()
        assertEquals("", entry.getUserName());
    }

    @Test(timeout = 4000)
    public void testConstructorWithDirectoryName() {
        String name = "testDirectory/";
        boolean preserveAbsolutePath = true;

        TarArchiveEntry entry = new TarArchiveEntry(name, preserveAbsolutePath);

        // Validate the internal state of the TarArchiveEntry using public methods
        assertEquals("testDirectory/", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_DIR_MODE, entry.getMode());
        assertEquals(TarArchiveEntry.LF_DIR, entry.getLinkFlag());
        assertNotNull(entry.getLastModifiedDate()); // Changed to getLastModifiedDate()
        assertEquals("", entry.getUserName());
    }

    @Test(timeout = 4000)
    public void testConstructorWithEmptyName() {
        String name = "";
        boolean preserveAbsolutePath = false;

        TarArchiveEntry entry = new TarArchiveEntry(name, preserveAbsolutePath);

        // Validate the internal state of the TarArchiveEntry using public methods
        assertEquals("", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode());
        assertEquals(TarArchiveEntry.LF_NORMAL, entry.getLinkFlag());
        assertNotNull(entry.getLastModifiedDate()); // Changed to getLastModifiedDate()
        assertEquals("", entry.getUserName());
    }

}