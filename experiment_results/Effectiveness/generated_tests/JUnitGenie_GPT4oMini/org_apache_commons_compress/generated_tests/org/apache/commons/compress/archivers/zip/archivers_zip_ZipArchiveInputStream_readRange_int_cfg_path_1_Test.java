package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_readRange_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadRangeThrowsIOException() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[5]); // Simulate an input stream with 5 bytes
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
        int len = 10; // Requesting more bytes than available to trigger IOException

        try {
            // Act
            Method method = ZipArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
            method.setAccessible(true);
            method.invoke(zipArchiveInputStream, len);
            fail("Expected IOException to be thrown");
        } catch (Exception e) {
            // Check if the exception is an instance of IOException
            if (e.getCause() instanceof IOException) {
                // Expected exception
            } else {
                fail("Unexpected exception thrown: " + e.getMessage());
            }
        }
    }

}