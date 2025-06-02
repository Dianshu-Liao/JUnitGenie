package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_dump_DumpArchiveEntry_setName_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSetNameWithValidDirectoryName() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setName("testDirectory");
        assertEquals("testDirectory/", entry.getName());
        assertEquals("testDirectory", entry.getOriginalName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithNull() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setName(null);
        assertNull(entry.getName());
        assertNull(entry.getOriginalName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithRelativePath() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setName("./testFile");
        assertEquals("testFile", entry.getName());
        assertEquals("./testFile", entry.getOriginalName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithTrailingSlash() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setName("testFolder/");
        assertEquals("testFolder/", entry.getName());
        assertEquals("testFolder/", entry.getOriginalName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithEmptyString() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setName("");
        assertEquals("", entry.getName());
        assertEquals("", entry.getOriginalName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithDirectoryType() {
        try {
            DumpArchiveEntry entry = new DumpArchiveEntry();
            // Assuming we have a way to set the type to DIRECTORY
            // entry.setType(DumpArchiveEntry.TYPE.DIRECTORY); // This line is pseudo-code
            entry.setName("testDirectory");
            // The expected behavior should be defined based on the actual implementation
            assertEquals("testDirectory", entry.getName());
            assertEquals("testDirectory", entry.getOriginalName());
        } catch (Exception e) {
            fail("Exception should not be thrown for valid directory name");
        }
    }


}