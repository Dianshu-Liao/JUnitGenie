package org.apache.commons.compress.archivers.dump;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;

public class DumpArchiveSummary_isNewHeader_16_1_Test {

    private DumpArchiveSummary summaryWithNewHeader;

    private DumpArchiveSummary summaryWithoutNewHeader;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a byte array to simulate the buffer for the DumpArchiveSummary constructor
        byte[] buffer = new byte[0];
        // Use a valid encoding here
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        // Create a summary with the new header (flags = 0x0001)
        summaryWithNewHeader = new DumpArchiveSummary(buffer, encoding);
        // Set the flag to indicate a new header
        setFlags(summaryWithNewHeader, 0x0001);
        // Create a summary without the new header (flags = 0x0000)
        summaryWithoutNewHeader = new DumpArchiveSummary(buffer, encoding);
        // Set the flag to indicate no new header
        setFlags(summaryWithoutNewHeader, 0x0000);
    }

    private void setFlags(DumpArchiveSummary summary, int flags) {
        try {
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, flags);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIsNewHeader_WithNewHeader_ReturnsTrue() {
        assertTrue(summaryWithNewHeader.isNewHeader(), "Expected isNewHeader() to return true for new header");
    }

    @Test
    public void testIsNewHeader_WithoutNewHeader_ReturnsFalse() {
        assertFalse(summaryWithoutNewHeader.isNewHeader(), "Expected isNewHeader() to return false for no new header");
    }
}
