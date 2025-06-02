package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.io.UncheckedIOException;
import static org.junit.Assert.fail;

public class archivers_tar_TarArchiveEntry_parseTarHeader_byte_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testParseTarHeaderWithValidInput() {
        // Create a valid TarArchiveEntry with a proper header size
        byte[] validHeader = new byte[512]; // Assuming a standard TAR header size
        TarArchiveEntry tarEntry = new TarArchiveEntry(validHeader);

        // Sample header for testing
        byte[] header = new byte[]{0x01, 0x02, 0x03}; // This should be a valid header

        try {
            tarEntry.parseTarHeader(header);
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseTarHeaderThrowsUncheckedIOException() {
        // Create a TarArchiveEntry with a proper header size
        byte[] invalidHeader = new byte[512]; // Assuming a standard TAR header size
        TarArchiveEntry tarEntry = new TarArchiveEntry(invalidHeader);

        // Simulating the exception by providing invalid data
        byte[] header = new byte[]{0x00}; // Invalid header to trigger an exception

        try {
            tarEntry.parseTarHeader(header);
            fail("Expected an UncheckedIOException to be thrown");
        } catch (UncheckedIOException e) {
            // Expected UncheckedIOException
        }
    }

}