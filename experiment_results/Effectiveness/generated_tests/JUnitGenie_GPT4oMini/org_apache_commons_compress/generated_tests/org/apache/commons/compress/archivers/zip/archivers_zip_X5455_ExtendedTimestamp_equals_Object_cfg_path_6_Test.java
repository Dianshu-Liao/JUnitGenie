package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_X5455_ExtendedTimestamp_equals_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEquals_SameFlagsAndTimes() {
        X5455_ExtendedTimestamp instance1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp instance2 = new X5455_ExtendedTimestamp();

        // Set same flags and modifyTime for testing equality
        instance1.setFlags((byte) 0x07); // Example byte value (last 3 bits are important)
        instance2.setFlags((byte) 0x07); 
        instance1.setModifyTime(new ZipLong(1000L)); // Example time
        instance2.setModifyTime(new ZipLong(1000L)); // Same time
        
        assertTrue("Instances should be equal", instance1.equals(instance2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentFlags() {
        X5455_ExtendedTimestamp instance1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp instance2 = new X5455_ExtendedTimestamp();

        // Set different flags
        instance1.setFlags((byte) 0x07); 
        instance2.setFlags((byte) 0x01); 

        assertFalse("Instances should not be equal due to different flags", instance1.equals(instance2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentModifyTime() {
        X5455_ExtendedTimestamp instance1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp instance2 = new X5455_ExtendedTimestamp();

        instance1.setFlags((byte) 0x07); 
        instance2.setFlags((byte) 0x07); 
        instance1.setModifyTime(new ZipLong(1000L)); 
        instance2.setModifyTime(new ZipLong(2000L)); // Different time

        assertFalse("Instances should not be equal due to different modify times", instance1.equals(instance2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        assertFalse("Instance should not be equal to null", instance.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        Object notX5455 = new Object();
        assertFalse("Instance should not be equal to an object of a different class", instance.equals(notX5455));
    }


}