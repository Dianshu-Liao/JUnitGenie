package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.utils.TimeUtils;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class archivers_zip_X5455_ExtendedTimestamp_fileTimeToZipLong_FileTime_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFileTimeToZipLong_ValidFileTime() {
        try {
            // Create a valid FileTime instance
            FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());

            // Access the private static method using reflection
            Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
            method.setAccessible(true);

            // Invoke the method
            ZipLong result = (ZipLong) method.invoke(null, fileTime);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testFileTimeToZipLong_NullFileTime() {
        try {
            // Access the private static method using reflection
            Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
            method.setAccessible(true);

            // Invoke the method with null
            ZipLong result = (ZipLong) method.invoke(null, (FileTime) null);

            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}