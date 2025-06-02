// Test method
package org.apache.commons.compress.archivers.zip;

import java.util.function.Function;
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
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ZipArchiveEntry_setExtraFields_69_1_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    void setUp() {
        zipArchiveEntry = new ZipArchiveEntry();
    }

    @Test
    void testSetExtraFields_NullFields() {
        // Arrange
        ZipExtraField[] fields = null;
        // Act
        zipArchiveEntry.setExtraFields(fields);
        // Assert
        assertNull(getPrivateField(zipArchiveEntry, "unparseableExtra"));
        assertArrayEquals(ZipArchiveEntry.EMPTY_ARRAY, getPrivateField(zipArchiveEntry, "extraFields"));
    }

    @Test
    void testSetExtraFields_EmptyFields() {
        // Arrange
        ZipExtraField[] fields = new ZipExtraField[0];
        // Act
        zipArchiveEntry.setExtraFields(fields);
        // Assert
        assertNull(getPrivateField(zipArchiveEntry, "unparseableExtra"));
        assertArrayEquals(ZipArchiveEntry.EMPTY_ARRAY, getPrivateField(zipArchiveEntry, "extraFields"));
    }

    @Test
    void testSetExtraFields_WithUnparseableField() {
        // Arrange
        UnparseableExtraFieldData unparseableField = Mockito.mock(UnparseableExtraFieldData.class);
        ZipExtraField[] fields = new ZipExtraField[] { unparseableField };
        // Act
        zipArchiveEntry.setExtraFields(fields);
        // Assert
        assertEquals(unparseableField, getPrivateField(zipArchiveEntry, "unparseableExtra"));
        assertArrayEquals(ZipArchiveEntry.EMPTY_ARRAY, getPrivateField(zipArchiveEntry, "extraFields"));
    }

    @Test
    void testSetExtraFields_WithValidFields() {
        // Arrange
        ZipExtraField validField1 = Mockito.mock(ZipExtraField.class);
        ZipExtraField validField2 = Mockito.mock(ZipExtraField.class);
        ZipExtraField[] fields = new ZipExtraField[] { validField1, validField2 };
        // Act
        zipArchiveEntry.setExtraFields(fields);
        // Assert
        assertNull(getPrivateField(zipArchiveEntry, "unparseableExtra"));
        assertArrayEquals(new ZipExtraField[] { validField1, validField2 }, getPrivateField(zipArchiveEntry, "extraFields"));
    }

    @Test
    void testSetExtraFields_WithMixedFields() {
        // Arrange
        UnparseableExtraFieldData unparseableField = Mockito.mock(UnparseableExtraFieldData.class);
        ZipExtraField validField = Mockito.mock(ZipExtraField.class);
        ZipExtraField[] fields = new ZipExtraField[] { unparseableField, validField };
        // Act
        zipArchiveEntry.setExtraFields(fields);
        // Assert
        assertEquals(unparseableField, getPrivateField(zipArchiveEntry, "unparseableExtra"));
        assertArrayEquals(new ZipExtraField[] { validField }, getPrivateField(zipArchiveEntry, "extraFields"));
    }

    private <T> T getPrivateField(Object obj, String fieldName) {
        try {
            // Fixed line: Use the correct type for the variable declaration
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
