package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X5455_ExtendedTimestamp_getCentralDirectoryLength__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLengthWhenBit0ModifyTimePresentIsFalse() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        
        // Set the private field bit0_modifyTimePresent to false using reflection
        try {
            java.lang.reflect.Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
            field.setAccessible(true);
            field.setBoolean(instance, false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ZipShort result = instance.getCentralDirectoryLength();
        assertEquals(new ZipShort(1), result);
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLengthWhenBit0ModifyTimePresentIsTrue() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        
        // Set the private field bit0_modifyTimePresent to true using reflection
        try {
            java.lang.reflect.Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
            field.setAccessible(true);
            field.setBoolean(instance, true);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ZipShort result = instance.getCentralDirectoryLength();
        assertEquals(new ZipShort(5), result); // 1 + 4 = 5
    }

}