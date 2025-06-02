package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class archivers_zip_ZipArchiveInputStream_skip_long_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testSkipWithPositiveValue() {
        // Arrange
        byte[] data = new byte[100]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 50;

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

    @Test(expected = IllegalArgumentException.class)
    public void testSkipWithNegativeValue() {
        // Arrange
        byte[] data = new byte[100]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = -10;

        // Act
        try {
            zipInputStream.skip(valueToSkip);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}