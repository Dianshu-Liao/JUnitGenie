package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class archivers_zip_ZipArchiveInputStream_skip_long_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSkipValidValue() throws IOException {
        // Arrange
        byte[] data = new byte[2048]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long valueToSkip = 512; // Valid skip value

        // Act
        long skipped = zipInputStream.skip(valueToSkip);

        // Assert
        assertEquals(valueToSkip, skipped);
    }

    @Test(timeout = 4000)
    public void testSkipNegativeValue() {
        // Arrange
        byte[] data = new byte[2048]; // Sample data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(inputStream);
        long negativeValue = -1; // Invalid skip value

        // Act & Assert
        try {
            zipInputStream.skip(negativeValue);
        } catch (IllegalArgumentException e) {
            assertEquals("Negative skip value", e.getMessage());
        } catch (IOException e) {
            // Handle IOException if it occurs
        }
    }

}