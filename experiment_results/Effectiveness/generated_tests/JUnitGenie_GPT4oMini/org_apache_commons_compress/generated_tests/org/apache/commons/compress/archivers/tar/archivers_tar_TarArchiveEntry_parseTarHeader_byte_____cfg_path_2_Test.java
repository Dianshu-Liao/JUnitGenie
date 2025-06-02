package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.io.IOException;
import java.io.UncheckedIOException;
import static org.junit.Assert.fail;

public class archivers_tar_TarArchiveEntry_parseTarHeader_byte_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testParseTarHeaderThrowsUncheckedIOException() {
        // Arrange
        byte[] header = new byte[512]; // Create a valid header size for TarArchiveEntry
        TarArchiveEntry entry = new TarArchiveEntry("test.txt"); // Create an instance of TarArchiveEntry with a valid name

        // Act
        try {
            entry.parseTarHeader(header);
        } catch (UncheckedIOException e) {
            // Assert
            // Verify that the exception is an instance of UncheckedIOException
            assert e.getCause() instanceof IOException;
            return; // Exit the test successfully if the exception is caught
        }
        // If no exception is thrown, fail the test
        fail("Expected UncheckedIOException was not thrown.");
    }

}