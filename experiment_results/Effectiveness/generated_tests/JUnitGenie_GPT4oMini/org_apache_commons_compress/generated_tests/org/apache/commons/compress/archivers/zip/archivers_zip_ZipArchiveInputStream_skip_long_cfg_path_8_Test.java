package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class archivers_zip_ZipArchiveInputStream_skip_long_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testSkipValidValue() {
        // Arrange
        byte[] data = new byte[2048]; // Create a byte array with more than 1024 bytes
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 512; // Valid value to skip

        // Act
        long skipped = 0;
        try {
            skipped = zipInputStream.skip(valueToSkip);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        assertEquals(valueToSkip, skipped);
    }

    @Test(timeout = 4000)
    public void testSkipNegativeValue() {
        // Arrange
        byte[] data = new byte[2048];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = -1; // Invalid value to skip

        // Act & Assert
        try {
            zipInputStream.skip(valueToSkip);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("Negative skip value", e.getMessage());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSkipExceedingValue() {
        // Arrange
        byte[] data = new byte[2048];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 2048; // Value to skip exceeds available data

        // Act
        long skipped = 0;
        try {
            skipped = zipInputStream.skip(valueToSkip);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        assertEquals(2048, skipped);
    }

}