package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Objects;

public class DumpArchiveSummary_isMetaDataOnly_15_0_Test {

    private DumpArchiveSummary dumpArchiveSummary;

    @BeforeEach
    public void setUp() throws IOException {
        // Assuming a valid byte array and a mock ZipEncoding for the constructor
        byte[] buffer = new byte[0];
        // Create a mock ZipEncoding
        ZipEncoding encoding = mock(ZipEncoding.class);
        dumpArchiveSummary = new DumpArchiveSummary(buffer, encoding);
    }

    @Test
    public void testIsMetaDataOnly_WithFlagsSet() throws Exception {
        // Set flags to 0x0100 to test the positive case
        setFlags(0x0100);
        assertTrue(dumpArchiveSummary.isMetaDataOnly());
    }

    @Test
    public void testIsMetaDataOnly_WithFlagsNotSet() throws Exception {
        // Set flags to 0x0000 to test the negative case
        setFlags(0x0000);
        assertFalse(dumpArchiveSummary.isMetaDataOnly());
    }

    private void setFlags(int flags) throws Exception {
        Method setFlagsMethod = DumpArchiveSummary.class.getDeclaredMethod("setFlags", int.class);
        setFlagsMethod.setAccessible(true);
        setFlagsMethod.invoke(dumpArchiveSummary, flags);
    }
}
