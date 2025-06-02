package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class archivers_zip_X5455_ExtendedTimestamp_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_SameFlagsAndTimes() {
        X5455_ExtendedTimestamp timestamp1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp timestamp2 = new X5455_ExtendedTimestamp();
        
        // Set the flags and times to be equal using setter methods
        timestamp1.setFlags((byte) 0x07); // Example flag
        timestamp2.setFlags((byte) 0x07); // Example flag
        timestamp1.setModifyTime(new ZipLong(123456789L)); // Example modify time
        timestamp2.setModifyTime(new ZipLong(123456789L)); // Example modify time
        timestamp1.setAccessTime(new ZipLong(987654321L)); // Example access time
        timestamp2.setAccessTime(new ZipLong(987654321L)); // Example access time

        assertTrue(timestamp1.equals(timestamp2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentFlags() {
        X5455_ExtendedTimestamp timestamp1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp timestamp2 = new X5455_ExtendedTimestamp();
        
        // Set different flags using setter methods
        timestamp1.setFlags((byte) 0x07); // Example flag
        timestamp2.setFlags((byte) 0x03); // Different flag

        assertFalse(timestamp1.equals(timestamp2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentModifyTime() {
        X5455_ExtendedTimestamp timestamp1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp timestamp2 = new X5455_ExtendedTimestamp();
        
        // Set the flags to be equal using setter methods
        timestamp1.setFlags((byte) 0x07); // Example flag
        timestamp2.setFlags((byte) 0x07); // Example flag
        timestamp1.setModifyTime(new ZipLong(123456789L)); // Example modify time
        timestamp2.setModifyTime(new ZipLong(987654321L)); // Different modify time

        assertFalse(timestamp1.equals(timestamp2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        assertFalse(timestamp.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_NonX5455Object() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        assertFalse(timestamp.equals(new Object()));
    }

}