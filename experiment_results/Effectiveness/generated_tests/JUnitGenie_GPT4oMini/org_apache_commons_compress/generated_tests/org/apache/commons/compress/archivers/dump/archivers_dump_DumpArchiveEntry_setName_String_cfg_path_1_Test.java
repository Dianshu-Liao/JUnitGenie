package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_dump_DumpArchiveEntry_setName_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetNameWithValidName() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String name = "testName";
        
        entry.setName(name);
        
        // Verify that originalName is set correctly using a getter method
        assertEquals(name, entry.getOriginalName());
        // Verify that name is set correctly using a getter method
        assertEquals(name, entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithNull() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        
        entry.setName(null);
        
        // Verify that originalName is set to null using a getter method
        assertNull(entry.getOriginalName());
        // Verify that name is set to null using a getter method
        assertNull(entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithDirectoryType() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        // Assuming we have a way to set the type to something other than DIRECTORY
        // entry.setType(DumpArchiveEntry.TYPE.FILE); // Set type to FILE for testing
        
        String name = "directoryName";
        entry.setName(name);
        
        // Verify that originalName is set correctly using a getter method
        assertEquals(name, entry.getOriginalName());
        // Verify that name is set correctly using a getter method
        assertEquals(name, entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithDirectoryNameWithoutSlash() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        // Assuming we have a way to set the type to something other than DIRECTORY
        // entry.setType(DumpArchiveEntry.TYPE.FILE); // Set type to FILE for testing
        
        String name = "directoryName";
        entry.setName(name);
        
        // Verify that name ends with a slash using a getter method
        assertEquals("directoryName/", entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithStartsWithDot() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String name = "./testName";
        
        entry.setName(name);
        
        // Verify that originalName is set correctly using a getter method
        assertEquals(name, entry.getOriginalName());
        // Verify that name is set correctly after substring operation using a getter method
        assertEquals("testName", entry.getName());
    }


}