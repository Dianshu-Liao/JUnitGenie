package org.apache.commons.compress.archivers.cpio;
import static org.junit.Assert.assertFalse;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;

public class archivers_cpio_CpioArchiveEntry_isRegularFile__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsRegularFileWhenNotRegularFile() {
        // Given: Instantiate CpioArchiveEntry with a mode such that mode & 61440 != 32768
        // The mode value should be a valid header type. Using a valid mode value for a non-regular file.
        short modeValue = (short) 0; // Example value that ensures the condition mode & 61440 != 32768
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry", modeValue);
        
        // When: Call the isRegularFile method
        boolean result = entry.isRegularFile();
        
        // Then: Assert that it returns false
        assertFalse(result);
    }

}