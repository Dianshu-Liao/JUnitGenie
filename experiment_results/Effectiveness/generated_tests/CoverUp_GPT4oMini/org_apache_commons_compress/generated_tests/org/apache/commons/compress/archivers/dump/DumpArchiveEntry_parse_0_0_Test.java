package org.apache.commons.compress.archivers.dump;

import java.lang.reflect.Method;
import java.util.Date;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;

@ExtendWith(MockitoExtension.class)
class DumpArchiveEntry_parse_0_0_Test {

    @Test
    void testParse() throws Exception {
        // Prepare a test byte array that simulates the expected input format
        byte[] buffer = new byte[512];
        // Populate the buffer with test data
        // Example data (you'll need to adjust these values based on your actual expectations)
        // Segment type
        buffer[0] = 0;
        // Dump date
        buffer[4] = 0;
        // Volume
        buffer[12] = 1;
        // Inode
        buffer[20] = 5;
        // Mode (type)
        buffer[32] = 0b00010000;
        // Nlink
        buffer[34] = 2;
        // Size
        long size = 100L;
        System.arraycopy(longToBytes(size), 0, buffer, 40, 8);
        // Access time
        buffer[48] = 1;
        // Last modified time
        buffer[56] = 2;
        // Creation time
        buffer[64] = 3;
        // Generation
        buffer[140] = 4;
        // User ID
        buffer[144] = (byte) 1000;
        // Group ID
        buffer[148] = (byte) 1001;
        // Header count
        buffer[160] = 1;
        // Invoke the private parse method using reflection
        Method parseMethod = DumpArchiveEntry.class.getDeclaredMethod("parse", byte[].class);
        parseMethod.setAccessible(true);
        DumpArchiveEntry entry = (DumpArchiveEntry) parseMethod.invoke(null, (Object) buffer);
        // Assertions to verify the state of the DumpArchiveEntry object
        assertNotNull(entry);
        assertEquals(1, entry.getVolume());
        assertEquals(5, entry.getIno());
        assertEquals(2, entry.getNlink());
        assertEquals(100, entry.getSize());
        assertEquals(4, entry.getGeneration());
        assertEquals(1000, entry.getUserId());
        assertEquals(1001, entry.getGroupId());
        assertEquals(1, entry.getHeaderCount());
        assertEquals(0, entry.getHeaderHoles());
        assertEquals(new Date(1000L * 1), entry.getAccessTime());
        assertEquals(new Date(1000L * 2), entry.getLastModifiedDate());
        assertEquals(new Date(1000L * 3), entry.getCreationTime());
    }

    private byte[] longToBytes(long x) {
        return new byte[] { (byte) (x >> 56), (byte) (x >> 48), (byte) (x >> 40), (byte) (x >> 32), (byte) (x >> 24), (byte) (x >> 16), (byte) (x >> 8), (byte) (x) };
    }
}
