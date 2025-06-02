package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_cpio_CpioArchiveEntry_isSocket__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSocketWithNonSocketMode() {
        // Given: Create an instance of CpioArchiveEntry with a mode that does not satisfy the condition
        short mode = 0; // Changed to short
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry"); // Use a valid name for the entry

        // Set the mode using reflection or a method if available
        // Assuming there's a method to set the mode, otherwise, this needs to be handled differently
        entry.setMode(mode); // Hypothetical method to set mode

        // When: Call the isSocket method
        boolean result = entry.isSocket();

        // Then: Assert that the result is false
        assertFalse(result);
    }

}