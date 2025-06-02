package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_dump_DumpArchiveEntry_setName_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetNameWithValidName() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String name = "testName";
        
        // Set the name
        entry.setName(name);
        
        // Verify that the originalName is set correctly
        assertEquals(name, entry.getOriginalName()); // Use getter method
        // Verify that the name is set correctly
        assertEquals(name, entry.getName()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetNameWithDirectoryCondition() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String name = "testDir";
        
        // Mocking isDirectory to return true
        // Assuming we have a way to set the type of the entry to not be DIRECTORY
        // entry.setType(DumpArchiveEntry.TYPE.FILE); // This should be a valid type that is not DIRECTORY
        
        entry.setName(name);
        
        // Verify that the name ends with "/"
        assertEquals(name + "/", entry.getName()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetNameWithNull() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        
        // Set the name to null
        entry.setName(null);
        
        // Verify that the originalName is set to null
        assertNull(entry.getOriginalName()); // Use getter method
        // Verify that the name is set to null
        assertNull(entry.getName()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetNameWithStartsWithDot() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String name = "./testName";
        
        // Set the name
        entry.setName(name);
        
        // Verify that the name is set correctly without the "./"
        assertEquals("testName", entry.getName()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetNameWithEndsWithSlash() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String name = "testDir/";
        
        // Mocking isDirectory to return true
        // Assuming we have a way to set the type of the entry to not be DIRECTORY
        // entry.setType(DumpArchiveEntry.TYPE.FILE); // This should be a valid type that is not DIRECTORY
        
        entry.setName(name);
        
        // Verify that the name remains unchanged
        assertEquals(name, entry.getName()); // Use getter method
    }


}