package org.apache.commons.compress.archivers.dump;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.IOUtils;

public class DumpArchiveInputStream_matches_0_0_Test {

    @Test
    public void testMatches_WithInsufficientLength_ReturnsFalse() {
        // Length is less than 32
        byte[] buffer = new byte[31];
        int length = buffer.length;
        assertFalse(DumpArchiveInputStream.matches(buffer, length));
    }

    @Test
    public void testMatches_WithValidHeader_ReturnsTrue() {
        // Length is >= TP_SIZE
        byte[] buffer = new byte[DumpArchiveConstants.TP_SIZE];
        // Mock behavior for verify method
        DumpArchiveUtil mockUtil = Mockito.mock(DumpArchiveUtil.class);
        Mockito.when(mockUtil.verify(buffer)).thenReturn(true);
        int length = buffer.length;
        assertTrue(DumpArchiveInputStream.matches(buffer, length));
    }

    @Test
    public void testMatches_WithValidMagic_ReturnsTrue() {
        byte[] buffer = new byte[32];
        // Fill buffer to simulate a valid magic number at position 24
        buffer[24] = (byte) (DumpArchiveConstants.NFS_MAGIC & 0xFF);
        buffer[25] = (byte) ((DumpArchiveConstants.NFS_MAGIC >> 8) & 0xFF);
        buffer[26] = (byte) ((DumpArchiveConstants.NFS_MAGIC >> 16) & 0xFF);
        buffer[27] = (byte) ((DumpArchiveConstants.NFS_MAGIC >> 24) & 0xFF);
        int length = buffer.length;
        assertTrue(DumpArchiveInputStream.matches(buffer, length));
    }

    @Test
    public void testMatches_WithInvalidMagic_ReturnsFalse() {
        byte[] buffer = new byte[32];
        // Fill buffer with an invalid magic number
        // Not matching NFS_MAGIC
        buffer[24] = 0;
        buffer[25] = 0;
        buffer[26] = 0;
        buffer[27] = 0;
        int length = buffer.length;
        assertFalse(DumpArchiveInputStream.matches(buffer, length));
    }
}
