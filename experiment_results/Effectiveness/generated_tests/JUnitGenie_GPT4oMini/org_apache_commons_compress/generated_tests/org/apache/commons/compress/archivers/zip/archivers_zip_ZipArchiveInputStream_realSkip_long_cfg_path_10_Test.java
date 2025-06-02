package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_realSkip_long_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testRealSkip() {
        // Prepare the input stream with some data
        byte[] data = new byte[100]; // Example data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);

        try {
            // Access the private method using reflection
            Method realSkipMethod = ZipArchiveInputStream.class.getDeclaredMethod("realSkip", long.class);
            realSkipMethod.setAccessible(true);

            // Call the method with a valid value
            realSkipMethod.invoke(zipInputStream, 50L);

            // If we reach here, the method executed without throwing an exception
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }


}