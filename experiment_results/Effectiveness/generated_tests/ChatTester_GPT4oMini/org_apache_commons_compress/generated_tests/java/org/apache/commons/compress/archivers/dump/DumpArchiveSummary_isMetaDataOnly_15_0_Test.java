package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DumpArchiveSummary_isMetaDataOnly_15_0_Test {

    private DumpArchiveSummary dumpArchiveSummary;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize with a sample byte array and ZipEncoding
        // Replace with actual byte data if needed
        byte[] buffer = new byte[0];
        // Use a mock for ZipEncoding since it's abstract
        ZipEncoding encoding = mock(ZipEncoding.class);
        dumpArchiveSummary = new DumpArchiveSummary(buffer, encoding);
    }

    @Test
    public void testIsMetaDataOnly_WithFlagsSet() throws Exception {
        // Set the flags to 0x0100 using reflection
        setPrivateField("flags", 0x0100);
        assertTrue(dumpArchiveSummary.isMetaDataOnly(), "Expected isMetaDataOnly to return true when flags are set to 0x0100");
    }

    @Test
    public void testIsMetaDataOnly_WithFlagsNotSet() throws Exception {
        // Set the flags to a value that does not include 0x0100
        setPrivateField("flags", 0x0000);
        assertFalse(dumpArchiveSummary.isMetaDataOnly(), "Expected isMetaDataOnly to return false when flags are not set to 0x0100");
    }

    private void setPrivateField(String fieldName, int value) throws Exception {
        // Repaired line: Use the correct type for the field variable
        java.lang.reflect.Field field = DumpArchiveSummary.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(dumpArchiveSummary, value);
    }
}
