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

class ArArchiveEntry_ArArchiveEntry_14_0_Test {

    private ArArchiveEntry entry;

    @BeforeEach
    void setUp() {
        entry = new ArArchiveEntry("test.txt", 1000, 1001, 1002, 33188, System.currentTimeMillis());
    }

    @Test
    void testConstructorValidParameters() {
        assertNotNull(entry);
        assertEquals("test.txt", entry.getName());
        assertEquals(1000, entry.getLength());
        assertEquals(1001, entry.getUserId());
        assertEquals(1002, entry.getGroupId());
        assertEquals(33188, entry.getMode());
    }

    @Test
    void testConstructorNegativeLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ArArchiveEntry("test.txt", -1, 1001, 1002, 33188, System.currentTimeMillis());
        });
        assertEquals("length must not be negative", exception.getMessage());
    }

    @Test
    void testGetLastModified() {
        long lastModified = System.currentTimeMillis();
        ArArchiveEntry entryWithLastModified = new ArArchiveEntry("test.txt", 1000, 1001, 1002, 33188, lastModified);
        assertEquals(lastModified, entryWithLastModified.getLastModified());
    }

    @Test
    void testGetLastModifiedDate() {
        long lastModified = System.currentTimeMillis();
        ArArchiveEntry entryWithLastModified = new ArArchiveEntry("test.txt", 1000, 1001, 1002, 33188, lastModified);
        assertNotNull(entryWithLastModified.getLastModifiedDate());
    }

    @Test
    void testGetSize() {
        assertEquals(entry.getLength(), entry.getSize());
    }
}
