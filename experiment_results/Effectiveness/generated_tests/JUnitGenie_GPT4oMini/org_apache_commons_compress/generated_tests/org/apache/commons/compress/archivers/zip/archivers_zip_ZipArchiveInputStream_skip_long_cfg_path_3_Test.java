package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class archivers_zip_ZipArchiveInputStream_skip_long_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSkipValidValue() {
        // Arrange
        byte[] data = new byte[2048]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 512; // Valid skip value

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
        byte[] data = new byte[2048]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long negativeValueToSkip = -1; // Invalid skip value

        // Act & Assert
        try {
            zipInputStream.skip(negativeValueToSkip);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("Negative skip value", e.getMessage());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSkipEndOfStream() {
        // Arrange
        byte[] data = new byte[512]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 1024; // Skip more than available

        // Act
        long skipped = 0;
        try {
            skipped = zipInputStream.skip(valueToSkip);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        assertEquals(data.length, skipped); // Should skip all available bytes
    }

}