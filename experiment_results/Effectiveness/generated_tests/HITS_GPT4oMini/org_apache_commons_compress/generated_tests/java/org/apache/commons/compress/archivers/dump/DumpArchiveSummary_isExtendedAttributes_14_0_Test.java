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

public class DumpArchiveSummary_isExtendedAttributes_14_0_Test {

    private DumpArchiveSummary summaryWithExtendedAttributes;

    private DumpArchiveSummary summaryWithoutExtendedAttributes;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a buffer for the test
        byte[] buffer = new byte[0];
        // Initialize ZipEncoding using ZipEncodingHelper (or directly instantiate if appropriate)
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        // Create DumpArchiveSummary instances
        summaryWithExtendedAttributes = new DumpArchiveSummary(buffer, encoding);
        summaryWithoutExtendedAttributes = new DumpArchiveSummary(buffer, encoding);
        // Set flags to simulate extended attributes
        setFlags(summaryWithExtendedAttributes, 0x8000);
        setFlags(summaryWithoutExtendedAttributes, 0x0000);
    }

    private void setFlags(DumpArchiveSummary summary, int flags) {
        // Use reflection to set the private 'flags' field for testing
        try {
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, flags);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set flags", e);
        }
    }

    @Test
    public void testIsExtendedAttributes_WithExtendedAttributes() {
        assertTrue(summaryWithExtendedAttributes.isExtendedAttributes(), "Expected true for extended attributes");
    }

    @Test
    public void testIsExtendedAttributes_WithoutExtendedAttributes() {
        assertFalse(summaryWithoutExtendedAttributes.isExtendedAttributes(), "Expected false for no extended attributes");
    }
}
