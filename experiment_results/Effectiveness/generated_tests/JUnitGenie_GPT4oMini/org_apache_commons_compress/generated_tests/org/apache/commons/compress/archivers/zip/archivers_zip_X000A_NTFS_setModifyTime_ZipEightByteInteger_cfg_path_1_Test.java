package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X000A_NTFS_setModifyTime_ZipEightByteInteger_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetModifyTime_NonNullValue() {
        X000A_NTFS instance = new X000A_NTFS();
        ZipEightByteInteger time = new ZipEightByteInteger(123456789L);
        
        instance.setModifyTime(time);
        
        // Since modifyTime is private, we need to use reflection to access it for verification
        try {
            java.lang.reflect.Field field = X000A_NTFS.class.getDeclaredField("modifyTime");
            field.setAccessible(true);
            ZipEightByteInteger result = (ZipEightByteInteger) field.get(instance);
            assertEquals(time, result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSetModifyTime_NullValue() {
        X000A_NTFS instance = new X000A_NTFS();
        
        instance.setModifyTime(null);
        
        // Since modifyTime is private, we need to use reflection to access it for verification
        try {
            java.lang.reflect.Field field = X000A_NTFS.class.getDeclaredField("modifyTime");
            field.setAccessible(true);
            ZipEightByteInteger result = (ZipEightByteInteger) field.get(instance);
            assertEquals(ZipEightByteInteger.ZERO, result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}