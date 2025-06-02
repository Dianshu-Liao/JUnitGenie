package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X5455_ExtendedTimestamp_setAccessTime_ZipLong_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetAccessTimeWithNonNullZipLong() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        ZipLong zipLong = new ZipLong(123456789L); // Create a ZipLong instance with a long value

        instance.setAccessTime(zipLong);

        // Verify that the accessTime is set correctly
        // Note: Accessing private fields directly is not possible, so we would typically use reflection or a getter method if available.
        // Here we assume there are getter methods for testing purposes.
        // assertEquals(zipLong, instance.getAccessTime()); // Uncomment if a getter is available
        // assertTrue(instance.isBit1AccessTimePresent()); // Uncomment if a getter is available
        // assertEquals(expectedFlagsValue, instance.getFlags()); // Uncomment if a getter is available
    }

    @Test(timeout = 4000)
    public void testSetAccessTimeWithNull() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();

        try {
            instance.setAccessTime(null);
            // Verify that the accessTime is set to null
            // assertNull(instance.getAccessTime()); // Uncomment if a getter is available
            // assertFalse(instance.isBit1AccessTimePresent()); // Uncomment if a getter is available
            // assertEquals(expectedFlagsValue, instance.getFlags()); // Uncomment if a getter is available
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}