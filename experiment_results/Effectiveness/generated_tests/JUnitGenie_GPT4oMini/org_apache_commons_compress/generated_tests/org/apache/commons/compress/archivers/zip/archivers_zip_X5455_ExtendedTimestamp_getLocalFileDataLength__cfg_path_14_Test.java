package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X5455_ExtendedTimestamp_getLocalFileDataLength__cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataLength() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        
        // Set the fields to cover the CFG path
        // Assuming we have access to setters or can directly modify the private fields for testing
        // Here we are simulating the conditions for the test
        try {
            // Use reflection to set the private fields since setter methods are not available
            java.lang.reflect.Field bit0Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0ModifyTimePresent");
            bit0Field.setAccessible(true);
            bit0Field.set(timestamp, true); // Simulating the condition
            
            java.lang.reflect.Field bit1Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit1AccessTimePresent");
            bit1Field.setAccessible(true);
            bit1Field.set(timestamp, false); // Simulating the condition
            
            java.lang.reflect.Field bit2Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2CreateTimePresent");
            bit2Field.setAccessible(true);
            bit2Field.set(timestamp, false); // Simulating the condition
            
            // Call the method under test
            ZipShort result = timestamp.getLocalFileDataLength();
            
            // The expected value is 5 (1 + 4 from bit0_modifyTimePresent)
            assertEquals(new ZipShort(5), result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}