package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class archivers_zip_X000A_NTFS_fileTimeToZip_FileTime_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFileTimeToZip_ValidTime() {
        try {
            // Create a valid FileTime instance
            FileTime time = FileTime.fromMillis(System.currentTimeMillis());
            
            // Access the private static method using reflection
            Method method = X000A_NTFS.class.getDeclaredMethod("fileTimeToZip", FileTime.class);
            method.setAccessible(true);
            
            // Invoke the method
            ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(null, time);
            
            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testFileTimeToZip_NullTime() {
        try {
            // Access the private static method using reflection
            Method method = X000A_NTFS.class.getDeclaredMethod("fileTimeToZip", FileTime.class);
            method.setAccessible(true);
            
            // Invoke the method with null
            ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(null, null);
            
            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}