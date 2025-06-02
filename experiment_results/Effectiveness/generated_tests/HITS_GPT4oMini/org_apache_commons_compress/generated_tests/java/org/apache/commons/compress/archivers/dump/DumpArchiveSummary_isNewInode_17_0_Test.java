package org.apache.commons.compress.archivers.dump;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;

public class DumpArchiveSummary_isNewInode_17_0_Test {

    private DumpArchiveSummary summaryWithNewInode;

    private DumpArchiveSummary summaryWithoutNewInode;

    @BeforeEach
    public void setUp() throws IOException {
        byte[] bufferWithNewInode = new byte[0];
        ZipEncoding encoding = null;
        summaryWithNewInode = new DumpArchiveSummary(bufferWithNewInode, encoding);
        // Using setter to set flags for new inode
        summaryWithNewInode.setFlags(0x0002);
        byte[] bufferWithoutNewInode = new byte[0];
        summaryWithoutNewInode = new DumpArchiveSummary(bufferWithoutNewInode, encoding);
        // Using setter to set flags for no new inode
        summaryWithoutNewInode.setFlags(0x0000);
    }

    @Test
    public void testIsNewInode_WhenFlagsIndicateNewInode_ShouldReturnTrue() {
        assertTrue(summaryWithNewInode.isNewInode(), "Expected isNewInode() to return true when flags indicate new inode.");
    }

    @Test
    public void testIsNewInode_WhenFlagsDoNotIndicateNewInode_ShouldReturnFalse() {
        assertFalse(summaryWithoutNewInode.isNewInode(), "Expected isNewInode() to return false when flags do not indicate new inode.");
    }
}
