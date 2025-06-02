package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_readFully_byte_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadFullyThrowsEOFException() {
        // Arrange
        byte[] b = new byte[10];
        int off = 5; // Setting offset to ensure we read less than the length of the byte array
        InputStream inputStream = new ByteArrayInputStream(new byte[5]); // InputStream with less data than expected
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);

        try {
            // Act
            Method method = ZipArchiveInputStream.class.getDeclaredMethod("readFully", byte[].class, int.class);
            method.setAccessible(true);
            method.invoke(zipArchiveInputStream, b, off);
            fail("Expected EOFException to be thrown");
        } catch (Exception e) {
            // Check if the exception is an instance of EOFException
            if (e.getCause() instanceof IOException && e.getCause().getMessage().contains("EOF")) {
                // Expected exception
            } else {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }


}