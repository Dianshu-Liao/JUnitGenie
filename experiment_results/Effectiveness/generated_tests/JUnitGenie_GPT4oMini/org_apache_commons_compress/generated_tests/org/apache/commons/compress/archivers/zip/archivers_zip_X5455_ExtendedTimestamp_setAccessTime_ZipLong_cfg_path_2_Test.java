package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_X5455_ExtendedTimestamp_setAccessTime_ZipLong_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetAccessTimeWhenZipLongIsNull() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        ZipLong l = null;

        // Call the method under test
        instance.setAccessTime(l);

        // Validate that accessTimePresent is set to false
        // Assuming the method isAccessTimePresent() is replaced with a valid check
        assertFalse(instance.getAccessTime() != null); // Check if accessTime is null

        // Validate that flags remain unchanged (assumed initial value 0 here for simplicity)
        assertEquals(0, instance.getFlags());

        // Validate that accessTime remains null
        assertNull(instance.getAccessTime());
    }

    @Test(timeout = 4000)
    public void testSetAccessTimeWhenZipLongIsNotNull() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        ZipLong l = new ZipLong(123456789L); // Create a ZipLong with a valid long value

        // Call the method under test
        instance.setAccessTime(l);

        // Validate that accessTimePresent is set to true
        // Assuming the method isAccessTimePresent() is replaced with a valid check
        assertTrue(instance.getAccessTime() != null); // Check if accessTime is not null

        // Validate that flags have the ACCESS_TIME_BIT set, assuming original flags value is 0
        assertEquals(2, instance.getFlags()); // Assuming ACCESS_TIME_BIT is defined as 2 (0b10)

        // Validate that accessTime is set to the provided ZipLong
        assertEquals(l, instance.getAccessTime());
    }

}