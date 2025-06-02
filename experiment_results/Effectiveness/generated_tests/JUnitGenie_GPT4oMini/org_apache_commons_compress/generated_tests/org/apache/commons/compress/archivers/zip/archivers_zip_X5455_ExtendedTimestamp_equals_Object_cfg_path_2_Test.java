package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_zip_X5455_ExtendedTimestamp_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        Object differentObject = new Object(); // Different type

        // Testing equals method with a different object type
        assertFalse(timestamp.equals(differentObject));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();

        // Testing equals method with null
        assertFalse(timestamp.equals(null));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameObject() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();

        // Testing equals method with the same object
        assertFalse(timestamp.equals(timestamp));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentFlags() {
        X5455_ExtendedTimestamp timestamp1 = new X5455_ExtendedTimestamp();
        X5455_ExtendedTimestamp timestamp2 = new X5455_ExtendedTimestamp();
        
        // Use a method to set flags instead of accessing the private field directly
        timestamp1.setFlags((byte) 0x01); // Example flag
        timestamp2.setFlags((byte) 0x02); // Different flag

        // Testing equals method with different flags
        assertFalse(timestamp1.equals(timestamp2));
    }

}