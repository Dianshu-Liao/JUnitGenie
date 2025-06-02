package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_realSkip_long_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testRealSkip() {
        // Arrange
        byte[] data = new byte[2048]; // Sample data larger than skipBuf
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 1500; // Value to skip

        try {
            // Act
            Method method = ZipArchiveInputStream.class.getDeclaredMethod("realSkip", long.class);
            method.setAccessible(true);
            method.invoke(zipArchiveInputStream, valueToSkip);
        } catch (Exception e) {
            // Handle the exception
            fail("Exception thrown during realSkip: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRealSkipWithNegativeValue() {
        // Arrange
        byte[] data = new byte[2048];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = -1; // Negative value to trigger IllegalArgumentException

        try {
            // Act
            Method method = ZipArchiveInputStream.class.getDeclaredMethod("realSkip", long.class);
            method.setAccessible(true);
            method.invoke(zipArchiveInputStream, valueToSkip);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            // Handle unexpected exceptions
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}