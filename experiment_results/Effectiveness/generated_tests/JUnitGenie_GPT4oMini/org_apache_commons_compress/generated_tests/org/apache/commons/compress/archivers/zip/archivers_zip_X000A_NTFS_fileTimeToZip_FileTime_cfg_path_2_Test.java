package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import static org.junit.Assert.assertNull;

public class archivers_zip_X000A_NTFS_fileTimeToZip_FileTime_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFileTimeToZip_NullInput() {
        try {
            // Accessing the private static method using reflection
            java.lang.reflect.Method method = X000A_NTFS.class.getDeclaredMethod("fileTimeToZip", FileTime.class);
            method.setAccessible(true);
            
            // Invoke the method with null input
            ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(null, (FileTime) null);
            
            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}