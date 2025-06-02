package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_dump_DumpArchiveEntry_setName_String_cfg_path_3_Test {

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
    public void testSetNameWithDirectoryCondition() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String name = "testDir";
        
        // Mocking isDirectory to return true
        // Assuming we have a way to set the type of the entry to something other than DIRECTORY
        // This part is pseudo-code, as we cannot directly set the type without reflection
        // entry.setType(DumpArchiveEntry.TYPE.FILE); // This should be a valid type other than DIRECTORY
        
        entry.setName(name);
        
        // Verify that name ends with "/"
        assertEquals(name + "/", entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithStartsWithDot() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String name = "./testName";
        
        entry.setName(name);
        
        // Verify that name is set correctly after removing "./"
        assertEquals("testName", entry.getName());
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


}