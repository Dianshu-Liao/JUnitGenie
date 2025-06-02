package org.apache.commons.compress.archivers.ar;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class ArArchiveEntry_ArArchiveEntry_14_0_Test {

    @Test
    public void testConstructorValidParameters() {
        String name = "testEntry";
        long length = 100;
        int userId = 1;
        int groupId = 1;
        int mode = 33188;
        long lastModified = System.currentTimeMillis();
        ArArchiveEntry entry = new ArArchiveEntry(name, length, userId, groupId, mode, lastModified);
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(length, entry.getLength());
        assertEquals(userId, entry.getUserId());
        assertEquals(groupId, entry.getGroupId());
        assertEquals(mode, entry.getMode());
        assertEquals(lastModified, entry.getLastModified());
    }

    @Test
    public void testConstructorNegativeLength() {
        String name = "testEntry";
        // Negative length
        long length = -1;
        int userId = 1;
        int groupId = 1;
        int mode = 33188;
        long lastModified = System.currentTimeMillis();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new ArArchiveEntry(name, length, userId, groupId, mode, lastModified);
        });
        assertEquals("length must not be negative", thrown.getMessage());
    }

    @Test
    public void testConstructorEdgeCases() {
        String name = "edgeEntry";
        // Edge case for zero length
        long length = 0;
        // Edge case for userId
        int userId = 0;
        // Edge case for groupId
        int groupId = 0;
        // Edge case for mode
        int mode = 0;
        // Edge case for lastModified
        long lastModified = 0;
        ArArchiveEntry entry = new ArArchiveEntry(name, length, userId, groupId, mode, lastModified);
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(length, entry.getLength());
        assertEquals(userId, entry.getUserId());
        assertEquals(groupId, entry.getGroupId());
        assertEquals(mode, entry.getMode());
        assertEquals(lastModified, entry.getLastModified());
    }
}
