package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_dump_DumpArchiveEntry_setName_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSetName() {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        String testName = "testName";

        // Call the focal method
        entry.setName(testName);

        // Verify the originalName is set correctly using a getter method
        assertEquals(testName, entry.getOriginalName());
        // Verify the name is set correctly using a getter method
        assertEquals(testName, entry.getName());
    }

    @Test(timeout = 4000)
    public void testSetNameWithNull() {
        DumpArchiveEntry entry = new DumpArchiveEntry();

        // Call the focal method with null
        entry.setName(null);

        // Verify the originalName is set to null using a getter method
        assertEquals(null, entry.getOriginalName());
        // Verify the name is set to null using a getter method
        assertEquals(null, entry.getName());
    }


}