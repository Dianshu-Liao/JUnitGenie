package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_zip_X5455_ExtendedTimestamp_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameFlagsAndTimes() {
        X5455_ExtendedTimestamp timestamp1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp timestamp2 = new X5455_ExtendedTimestamp();
        
        // Use setter methods to set the flags and times
        timestamp1.setFlags((byte) 0x07); // Example flag
        timestamp2.setFlags((byte) 0x07); // Example flag
        timestamp1.setModifyTime(new ZipLong(123456789L));
        timestamp2.setModifyTime(new ZipLong(123456789L));
        timestamp1.setAccessTime(new ZipLong(987654321L));
        timestamp2.setAccessTime(new ZipLong(987654321L));
        timestamp1.setCreateTime(new ZipLong(111111111L));
        timestamp2.setCreateTime(new ZipLong(111111111L));
        
        assertTrue(timestamp1.equals(timestamp2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentFlags() {
        X5455_ExtendedTimestamp timestamp1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp timestamp2 = new X5455_ExtendedTimestamp();
        
        // Use setter methods to set different flags
        timestamp1.setFlags((byte) 0x07); // Example flag
        timestamp2.setFlags((byte) 0x03); // Different flag
        
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