package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.zip.ZipEncoding;

public class DumpArchiveSummary_isMetaDataOnly_15_2_Test {

    private DumpArchiveSummary dumpArchiveSummaryMetaDataOnly;

    private DumpArchiveSummary dumpArchiveSummaryNotMetaDataOnly;

    @BeforeEach
    public void setUp() throws IOException {
        // Create instances of DumpArchiveSummary with flags set for testing
        // Dummy buffer
        byte[] buffer = new byte[0];
        dumpArchiveSummaryMetaDataOnly = new DumpArchiveSummary(buffer, null);
        dumpArchiveSummaryNotMetaDataOnly = new DumpArchiveSummary(buffer, null);
        // Set flags directly for testing purposes (assuming flags is accessible)
        // Using reflection to set the flags field since it's private
        // Metadata only
        setFlags(dumpArchiveSummaryMetaDataOnly, 0x0100);
        // Not metadata only
        setFlags(dumpArchiveSummaryNotMetaDataOnly, 0x0000);
    }

    private void setFlags(DumpArchiveSummary summary, int flags) {
        try {
            java.lang.reflect.Field field = DumpArchiveSummary.class.getDeclaredField("flags");
            field.setAccessible(true);
            field.setInt(summary, flags);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Unable to set flags for testing", e);
        }
    }

    @Test
    public void testIsMetaDataOnly_ReturnsTrue_WhenFlagsIndicateMetaDataOnly() {
        assertTrue(dumpArchiveSummaryMetaDataOnly.isMetaDataOnly(), "Expected isMetaDataOnly to return true when flags indicate metadata only");
    }

    @Test
    public void testIsMetaDataOnly_ReturnsFalse_WhenFlagsDoNotIndicateMetaDataOnly() {
        assertFalse(dumpArchiveSummaryNotMetaDataOnly.isMetaDataOnly(), "Expected isMetaDataOnly to return false when flags do not indicate metadata only");
    }
}
