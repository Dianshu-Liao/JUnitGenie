package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_realSkip_long_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testRealSkip() {
        // Arrange
        byte[] data = new byte[2048]; // Sample data larger than skipBuf
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 1500; // Value to skip

        try {
            // Access the private method using reflection
            Method realSkipMethod = ZipArchiveInputStream.class.getDeclaredMethod("realSkip", long.class);
            realSkipMethod.setAccessible(true);

            // Act
            realSkipMethod.invoke(zipInputStream, valueToSkip);
        } catch (Exception e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRealSkipThrowsIllegalArgumentException() {
        // Arrange
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = -1; // Invalid value to skip

        try {
            // Access the private method using reflection
            Method realSkipMethod = ZipArchiveInputStream.class.getDeclaredMethod("realSkip", long.class);
            realSkipMethod.setAccessible(true);

            // Act
            realSkipMethod.invoke(zipInputStream, valueToSkip);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

}