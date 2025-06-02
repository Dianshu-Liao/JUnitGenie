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

public class DumpArchiveSummary_isNewInode_17_1_Test {

    private DumpArchiveSummary dumpArchiveSummary;

    @BeforeEach
    public void setUp() throws IOException {
        // Dummy buffer
        byte[] buffer = new byte[0];
        // No specific encoding needed for this test
        ZipEncoding encoding = null;
        dumpArchiveSummary = new DumpArchiveSummary(buffer, encoding);
    }

    @Test
    public void testIsNewInode_WhenFlagsSet_ShouldReturnTrue() throws Exception {
        // Set flags to 0x0002 (new inode)
        setFlags(0x0002);
        // Invoke the method
        boolean result = invokeIsNewInode();
        // Assert the result
        assertTrue(result);
    }

    @Test
    public void testIsNewInode_WhenFlagsNotSet_ShouldReturnFalse() throws Exception {
        // Set flags to 0x0000 (no new inode)
        setFlags(0x0000);
        // Invoke the method
        boolean result = invokeIsNewInode();
        // Assert the result
        assertFalse(result);
    }

    private void setFlags(int flags) throws Exception {
        Method setFlagsMethod = DumpArchiveSummary.class.getDeclaredMethod("setFlags", int.class);
        setFlagsMethod.setAccessible(true);
        setFlagsMethod.invoke(dumpArchiveSummary, flags);
    }

    private boolean invokeIsNewInode() throws Exception {
        Method isNewInodeMethod = DumpArchiveSummary.class.getDeclaredMethod("isNewInode");
        isNewInodeMethod.setAccessible(true);
        return (boolean) isNewInodeMethod.invoke(dumpArchiveSummary);
    }
}
