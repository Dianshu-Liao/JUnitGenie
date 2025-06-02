package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X5455_ExtendedTimestamp_getLocalFileDataLength__cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataLength() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        
        // Set the fields to cover the CFG path
        // Assuming we have access to setter methods or can directly modify the private fields for testing
        // Here we are simulating the conditions for the test
        try {
            // Simulating the conditions where:
            // bit0_modifyTimePresent = true
            // bit1_accessTimePresent = true and accessTime is not null
            // bit2_createTimePresent = true and createTime is not null
            
            // Using reflection to set private fields for testing
            java.lang.reflect.Field bit0Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
            bit0Field.setAccessible(true);
            bit0Field.set(timestamp, true);
            
            java.lang.reflect.Field bit1Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
            bit1Field.setAccessible(true);
            bit1Field.set(timestamp, true);
            
            java.lang.reflect.Field accessTimeField = X5455_ExtendedTimestamp.class.getDeclaredField("accessTime");
            accessTimeField.setAccessible(true);
            accessTimeField.set(timestamp, new ZipLong(123456789L)); // Simulating a non-null value
            
            java.lang.reflect.Field bit2Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
            bit2Field.setAccessible(true);
            bit2Field.set(timestamp, true);
            
            java.lang.reflect.Field createTimeField = X5455_ExtendedTimestamp.class.getDeclaredField("createTime");
            createTimeField.setAccessible(true);
            createTimeField.set(timestamp, new ZipLong(987654321L)); // Simulating a non-null value
            
            // Now we can call the method and check the result
            ZipShort result = timestamp.getLocalFileDataLength();
            assertEquals(new ZipShort(12), result); // 1 + 4 + 4 + 4 = 12
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}