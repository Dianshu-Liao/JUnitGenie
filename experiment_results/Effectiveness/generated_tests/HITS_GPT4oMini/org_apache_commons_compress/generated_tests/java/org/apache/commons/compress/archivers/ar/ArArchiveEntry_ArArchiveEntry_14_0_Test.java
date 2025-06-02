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
    public void testConstructor_ValidParameters() {
        String name = "test.txt";
        long length = 100;
        int userId = 1000;
        int groupId = 1000;
        int mode = 33188;
        long lastModified = System.currentTimeMillis();
        ArArchiveEntry entry = new ArArchiveEntry(name, length, userId, groupId, mode, lastModified);
        assertNotNull(entry);
    }

    @Test
    public void testConstructor_NegativeLength_ThrowsIllegalArgumentException() {
        String name = "test.txt";
        // invalid length
        long length = -1;
        int userId = 1000;
        int groupId = 1000;
        int mode = 33188;
        long lastModified = System.currentTimeMillis();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new ArArchiveEntry(name, length, userId, groupId, mode, lastModified);
        });
        assertEquals("length must not be negative", thrown.getMessage());
    }

    @Test
    public void testConstructor_ZeroLength() {
        String name = "empty.txt";
        // valid length
        long length = 0;
        int userId = 1000;
        int groupId = 1000;
        int mode = 33188;
        long lastModified = System.currentTimeMillis();
        ArArchiveEntry entry = new ArArchiveEntry(name, length, userId, groupId, mode, lastModified);
        assertNotNull(entry);
    }
}
