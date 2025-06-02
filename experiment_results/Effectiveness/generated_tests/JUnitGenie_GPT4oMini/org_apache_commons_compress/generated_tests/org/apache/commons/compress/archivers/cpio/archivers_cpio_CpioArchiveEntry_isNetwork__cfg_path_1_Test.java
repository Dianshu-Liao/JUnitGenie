package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_cpio_CpioArchiveEntry_isNetwork__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNetwork() {
        // Given: A mode value that does not satisfy the condition mode & 61440L == 36864L
        short mode = 0; // Changed from int to short to match the constructor
        CpioArchiveEntry entry = new CpioArchiveEntry(mode);

        // When: Calling the isNetwork method
        boolean result = entry.isNetwork();

        // Then: The result should be false as mode does not represent a network file
        assertFalse(result);
    }


}