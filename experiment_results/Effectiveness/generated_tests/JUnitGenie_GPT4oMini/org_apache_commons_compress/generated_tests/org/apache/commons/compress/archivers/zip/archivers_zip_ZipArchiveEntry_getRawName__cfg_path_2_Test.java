package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class archivers_zip_ZipArchiveEntry_getRawName__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetRawNameWhenRawNameIsNull() {
        // Create an instance of ZipArchiveEntry using reflection
        ZipArchiveEntry entry = new ZipArchiveEntry((String) null);
        
        // Call the method under test
        byte[] result = entry.getRawName();
        
        // Verify the result
        assertNull(result);
    }

}