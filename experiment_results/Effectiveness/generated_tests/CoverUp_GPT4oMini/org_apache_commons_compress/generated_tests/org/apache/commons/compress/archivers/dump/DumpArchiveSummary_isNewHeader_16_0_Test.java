package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;

public class DumpArchiveSummary_isNewHeader_16_0_Test {

    private DumpArchiveSummary dumpArchiveSummary;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize with dummy data, flags set to 0 for initial case
        // Dummy buffer
        byte[] buffer = new byte[0];
        // Using null for simplicity, can be mocked if necessary
        ZipEncoding encoding = null;
        dumpArchiveSummary = new DumpArchiveSummary(buffer, encoding);
    }

    @Test
    public void testIsNewHeader_FlagIsSet() throws Exception {
        // Set flags to 1 (0x0001) to test true case
        setFlags(1);
        assertTrue(dumpArchiveSummary.isNewHeader());
    }

    @Test
    public void testIsNewHeader_FlagIsNotSet() throws Exception {
        // Set flags to 0 to test false case
        setFlags(0);
        assertFalse(dumpArchiveSummary.isNewHeader());
    }

    private void setFlags(int flags) throws Exception {
        // Use reflection to set the private flags field
        java.lang.reflect.Field field = DumpArchiveSummary.class.getDeclaredField("flags");
        field.setAccessible(true);
        field.setInt(dumpArchiveSummary, flags);
    }
}
