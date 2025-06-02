package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
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

class ZipArchiveEntry_getRawName_39_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    void setUp() {
        // Set up a new instance of ZipArchiveEntry before each test
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    void testGetRawNameWithNonNullRawName() {
        // Set the rawName field using reflection
        byte[] rawNameValue = new byte[] { 1, 2, 3, 4 };
        setPrivateField("rawName", rawNameValue);
        // Invoke the focal method
        byte[] result = zipArchiveEntry.getRawName();
        // Assert that the result is a copy of the rawName
        assertNotNull(result);
        assertArrayEquals(rawNameValue, result);
    }

    @Test
    void testGetRawNameWithNullRawName() {
        // Ensure rawName is null
        setPrivateField("rawName", null);
        // Invoke the focal method
        byte[] result = zipArchiveEntry.getRawName();
        // Assert that the result is null
        assertNull(result);
    }

    private void setPrivateField(String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = ZipArchiveEntry.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(zipArchiveEntry, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
