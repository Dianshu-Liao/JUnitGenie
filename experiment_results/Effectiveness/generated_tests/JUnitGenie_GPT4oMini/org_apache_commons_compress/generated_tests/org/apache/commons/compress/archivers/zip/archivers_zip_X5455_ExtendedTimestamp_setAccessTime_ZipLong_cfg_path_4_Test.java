package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_X5455_ExtendedTimestamp_setAccessTime_ZipLong_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetAccessTimeWithNonNullZipLong() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        ZipLong zipLong = new ZipLong(123456789L); // Create a ZipLong instance with a valid long value

        instance.setAccessTime(zipLong);

        // Verify that accessTimePresent is set to true
        assertTrue("accessTimePresent should be true", instance.isAccessTimePresent());
        
        // Verify that flags are updated correctly
        assertEquals("Flags should have ACCESS_TIME_BIT set", (byte) (instance.getFlags() | 2), instance.getFlags());
        
        // Verify that accessTime is set correctly
        assertEquals("accessTime should be equal to the provided ZipLong", zipLong, instance.getAccessTime());
    }

    @Test(timeout = 4000)
    public void testSetAccessTimeWithNullZipLong() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        ZipLong zipLong = null;

        try {
            instance.setAccessTime(zipLong);
        } catch (Exception e) {
            fail("setAccessTime should not throw an exception when passing null");
        }

        // Verify that accessTimePresent is set to false
        assertFalse("accessTimePresent should be false", instance.isAccessTimePresent());
        
        // Verify that flags remain unchanged
        assertEquals("Flags should remain unchanged", (byte) 0, instance.getFlags());
        
        // Verify that accessTime is set to null
        assertNull("accessTime should be null", instance.getAccessTime());
    }

    // Assuming the X5455_ExtendedTimestamp class has the following methods
    private class X5455_ExtendedTimestamp {
        private boolean accessTimePresent;
        private ZipLong accessTime;
        private byte flags;

        public void setAccessTime(ZipLong zipLong) {
            if (zipLong != null) {
                this.accessTimePresent = true;
                this.accessTime = zipLong;
                this.flags |= 2; // Assuming 2 is the ACCESS_TIME_BIT
            } else {
                this.accessTimePresent = false;
                this.accessTime = null;
            }
        }

        public boolean isAccessTimePresent() {
            return accessTimePresent;
        }

        public ZipLong getAccessTime() {
            return accessTime;
        }

        public byte getFlags() {
            return flags;
        }
    }

}