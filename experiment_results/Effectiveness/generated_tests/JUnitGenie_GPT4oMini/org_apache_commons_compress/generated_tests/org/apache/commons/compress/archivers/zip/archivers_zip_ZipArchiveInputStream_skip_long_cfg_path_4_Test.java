package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class archivers_zip_ZipArchiveInputStream_skip_long_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSkipValidValue() {
        // Arrange
        byte[] data = new byte[2048]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 512; // Valid skip value

        // Act
        long skippedBytes = 0;
        try {
            skippedBytes = zipInputStream.skip(valueToSkip);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        assertEquals(valueToSkip, skippedBytes);
    }

    @Test(timeout = 4000)
    public void testSkipNegativeValue() {
        // Arrange
        byte[] data = new byte[2048]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = -1; // Invalid skip value

        // Act & Assert
        try {
            zipInputStream.skip(valueToSkip);
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testSkipExceedingValue() {
        // Arrange
        byte[] data = new byte[2048]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 2048; // Skip value equal to data length

        // Act
        long skippedBytes = 0;
        try {
            skippedBytes = zipInputStream.skip(valueToSkip);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        assertEquals(2048, skippedBytes);
    }

}