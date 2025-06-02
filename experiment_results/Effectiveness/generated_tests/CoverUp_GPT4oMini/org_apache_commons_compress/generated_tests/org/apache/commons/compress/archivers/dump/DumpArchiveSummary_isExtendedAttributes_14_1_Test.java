package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.apache.commons.compress.archivers.dump.DumpArchiveSummary;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;

public class DumpArchiveSummary_isExtendedAttributes_14_1_Test {

    private DumpArchiveSummary summary;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a byte array and ZipEncoding mock for testing
        // Placeholder for actual buffer
        byte[] buffer = new byte[0];
        // Placeholder for actual ZipEncoding
        ZipEncoding encoding = null;
        // Use reflection to access the private constructor
        Constructor<DumpArchiveSummary> constructor = DumpArchiveSummary.class.getDeclaredConstructor(byte[].class, ZipEncoding.class);
        constructor.setAccessible(true);
        summary = constructor.newInstance(buffer, encoding);
    }

    @Test
    public void testIsExtendedAttributesWhenFlagsSet() throws Exception {
        // Set flags to indicate extended attributes
        setFlags(0x8000);
        assertTrue(summary.isExtendedAttributes(), "Expected isExtendedAttributes() to return true when flags indicate extended attributes.");
    }

    @Test
    public void testIsExtendedAttributesWhenFlagsNotSet() throws Exception {
        // Set flags to indicate no extended attributes
        setFlags(0x0000);
        assertFalse(summary.isExtendedAttributes(), "Expected isExtendedAttributes() to return false when flags do not indicate extended attributes.");
    }

    private void setFlags(int flagsValue) throws Exception {
        Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
        flagsField.setAccessible(true);
        flagsField.setInt(summary, flagsValue);
    }
}
