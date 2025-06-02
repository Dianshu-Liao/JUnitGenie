package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X000A_NTFS_setModifyTime_ZipEightByteInteger_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetModifyTime_NonNullValue() {
        // Arrange
        X000A_NTFS instance = new X000A_NTFS();
        ZipEightByteInteger expectedTime = new ZipEightByteInteger(123456789L);

        // Act
        instance.setModifyTime(expectedTime);

        // Assert
        // Accessing the private field modifyTime using reflection for verification
        try {
            java.lang.reflect.Field field = X000A_NTFS.class.getDeclaredField("modifyTime");
            field.setAccessible(true);
            ZipEightByteInteger actualTime = (ZipEightByteInteger) field.get(instance);
            assertEquals(expectedTime, actualTime);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSetModifyTime_NullValue() {
        // Arrange
        X000A_NTFS instance = new X000A_NTFS();

        // Act
        instance.setModifyTime(null);

        // Assert
        // Accessing the private field modifyTime using reflection for verification
        try {
            java.lang.reflect.Field field = X000A_NTFS.class.getDeclaredField("modifyTime");
            field.setAccessible(true);
            ZipEightByteInteger actualTime = (ZipEightByteInteger) field.get(instance);
            assertEquals(ZipEightByteInteger.ZERO, actualTime);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}