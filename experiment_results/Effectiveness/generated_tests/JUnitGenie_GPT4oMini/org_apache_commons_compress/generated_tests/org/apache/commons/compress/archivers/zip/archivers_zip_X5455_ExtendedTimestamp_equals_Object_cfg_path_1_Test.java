package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_zip_X5455_ExtendedTimestamp_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNonX5455ExtendedTimestampObject() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        Object nonTimestampObject = new Object();

        try {
            // Test that equals returns false when a non-X5455_ExtendedTimestamp object is provided
            assertFalse(timestamp.equals(nonTimestampObject));
        } catch (Exception e) {
            // Handle potential exceptions (if any)
            e.printStackTrace();
        }
    }

}