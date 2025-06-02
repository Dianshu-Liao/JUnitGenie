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

public class ArArchiveEntry_ArArchiveEntry_13_0_Test {

    @Test
    public void testConstructorWithValidParameters() {
        String name = "testFile.txt";
        long length = 1024;
        ArArchiveEntry entry = new ArArchiveEntry(name, length);
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(length, entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        // Assuming DEFAULT_MODE is 33188
        assertEquals(33188, entry.getMode());
        assertTrue(entry.getLastModified() > 0);
    }

    @Test
    public void testConstructorWithZeroLength() {
        String name = "emptyFile.txt";
        long length = 0;
        ArArchiveEntry entry = new ArArchiveEntry(name, length);
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(length, entry.getLength());
    }

    @Test
    public void testConstructorWithNegativeLength() {
        String name = "negativeLengthFile.txt";
        long length = -1;
        ArArchiveEntry entry = new ArArchiveEntry(name, length);
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(length, entry.getLength());
    }

    @Test
    public void testConstructorWithLargeLength() {
        String name = "largeFile.txt";
        long length = Long.MAX_VALUE;
        ArArchiveEntry entry = new ArArchiveEntry(name, length);
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(length, entry.getLength());
    }
}
