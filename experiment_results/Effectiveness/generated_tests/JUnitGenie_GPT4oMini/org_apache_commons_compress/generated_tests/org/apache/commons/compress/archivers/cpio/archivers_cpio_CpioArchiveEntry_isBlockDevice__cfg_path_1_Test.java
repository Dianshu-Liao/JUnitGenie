package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_cpio_CpioArchiveEntry_isBlockDevice__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsBlockDeviceWhenNotBlockDevice() {
        // Create an instance of CpioArchiveEntry with a valid header type.
        // The constructor requires a valid header type, so we will use a valid mode.
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry", 0); // Using a valid name and mode

        // We expect isBlockDevice() to return false since mode does not represent a block device
        try {
            boolean result = entry.isBlockDevice();
            assertFalse(result);
        } catch (Exception e) {
            // Handle any unexpected exceptions that may occur
            e.printStackTrace();
        }
    }


}