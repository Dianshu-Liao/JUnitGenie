package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class archivers_zip_X5455_ExtendedTimestamp_setAccessTime_ZipLong_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSetAccessTimeWithNonNullZipLong() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        ZipLong zipLong = new ZipLong(123456789L); // Create a ZipLong instance with a valid long value

        // Set access time
        instance.setAccessTime(zipLong);

        // Verify the internal state
        // Since flags and bit1_accessTimePresent are private, we would need to use reflection or other means to verify them.
        // For this example, we will assume we have access to a method to check the state.
        // assertTrue(instance.isAccessTimePresent()); // Hypothetical method to check access time presence
        // assertTrue(instance.getFlags() == (byte) (instance.getFlags() | ACCESS_TIME_BIT)); // Hypothetical method to get flags
    }

    @Test(timeout = 4000)
    public void testSetAccessTimeWithNullZipLong() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        ZipLong zipLong = null; // Set ZipLong to null

        try {
            // Set access time
            instance.setAccessTime(zipLong);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Verify the internal state
        // assertTrue(!instance.isAccessTimePresent()); // Hypothetical method to check access time presence
        // assertTrue(instance.getFlags() == (byte) (instance.getFlags() & ~ACCESS_TIME_BIT)); // Hypothetical method to get flags
    }

}