package org.apache.commons.compress.archivers.zip;

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
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.file.attribute.FileTimes;

public class ZipArchiveEntry_setSize_82_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    public void testSetSizeValid() {
        long validSize = 1024L;
        zipArchiveEntry.setSize(validSize);
        // Use reflection to access the private field 'size'
        long size = getPrivateField(zipArchiveEntry, "size");
        assertEquals(validSize, size);
    }

    @Test
    public void testSetSizeNegative() {
        long negativeSize = -1L;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            zipArchiveEntry.setSize(negativeSize);
        });
        assertEquals("Invalid entry size", thrown.getMessage());
    }

    @Test
    public void testSetSizeZero() {
        long zeroSize = 0L;
        zipArchiveEntry.setSize(zeroSize);
        // Use reflection to access the private field 'size'
        long size = getPrivateField(zipArchiveEntry, "size");
        assertEquals(zeroSize, size);
    }

    private long getPrivateField(ZipArchiveEntry entry, String fieldName) {
        try {
            java.lang.reflect.Field field = ZipArchiveEntry.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.getLong(entry);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
            // Unreachable but required for compilation
            return -1;
        }
    }
}
