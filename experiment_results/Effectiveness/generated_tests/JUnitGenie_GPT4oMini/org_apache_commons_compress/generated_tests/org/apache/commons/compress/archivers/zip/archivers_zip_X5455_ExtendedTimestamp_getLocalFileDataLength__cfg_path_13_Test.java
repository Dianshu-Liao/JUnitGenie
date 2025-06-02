package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X5455_ExtendedTimestamp_getLocalFileDataLength__cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataLength() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        
        // Set the private fields to meet the conditions of the CFGPath
        try {
            // Using reflection to set private fields
            java.lang.reflect.Field bit0Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
            bit0Field.setAccessible(true);
            bit0Field.set(instance, true); // Set to true to include 4 in the calculation
            
            java.lang.reflect.Field bit1Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
            bit1Field.setAccessible(true);
            bit1Field.set(instance, false); // Set to false to skip accessTime
            
            java.lang.reflect.Field bit2Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
            bit2Field.setAccessible(true);
            bit2Field.set(instance, false); // Set to false to skip createTime
            
            // Call the method under test
            ZipShort result = instance.getLocalFileDataLength();
            
            // The expected value is 1 + 4 (from bit0_modifyTimePresent)
            assertEquals(new ZipShort(5), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}