package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class archivers_zip_X5455_ExtendedTimestamp_fileTimeToZipLong_FileTime_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFileTimeToZipLong_NullInput() {
        try {
            // Access the private static method using reflection
            Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
            method.setAccessible(true);

            // Call the method with null input
            ZipLong result = (ZipLong) method.invoke(null, (FileTime) null);

            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}