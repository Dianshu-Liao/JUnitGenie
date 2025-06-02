package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_dump_DumpArchiveEntry_setName_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetNameWithValidDirectoryName() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setType(DumpArchiveEntry.TYPE.DIRECTORY); // Assuming there's a method to set the type

        String name = "testDirectory";
        entry.setName(name);

        // Verify that originalName is set correctly using a getter method
        assertEquals(name, entry.getOriginalName());
        // Verify that name is set correctly with a trailing slash using a getter method
        assertEquals(name + "/", entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithNull() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setType(DumpArchiveEntry.TYPE.DIRECTORY); // Assuming there's a method to set the type

        entry.setName(null);

        // Verify that originalName is set to null using a getter method
        assertNull(entry.getOriginalName());
        // Verify that name is set to null using a getter method
        assertNull(entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithRelativePath() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setType(DumpArchiveEntry.TYPE.DIRECTORY); // Assuming there's a method to set the type

        String name = "./testDirectory";
        entry.setName(name);

        // Verify that originalName is set correctly using a getter method
        assertEquals(name, entry.getOriginalName());
        // Verify that name is set correctly without the leading "./" using a getter method
        assertEquals("testDirectory", entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithInvalidDirectoryName() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        entry.setType(DumpArchiveEntry.TYPE.DIRECTORY); // Assuming there's a method to set the type

        String name = "testFile.txt";
        entry.setName(name);

        // Verify that originalName is set correctly using a getter method
        assertEquals(name, entry.getOriginalName());
        // Verify that name is set correctly using a getter method
        assertEquals(name, entry.getName());
    }


}