package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Method;
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

class ZipArchiveEntry_getExtraFields_24_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    private Function<ZipShort, ZipExtraField> extraFieldFactory;

    @BeforeEach
    void setUp() {
        extraFieldFactory = mock(Function.class);
        try {
            zipArchiveEntry = new ZipArchiveEntry(new ZipEntry("testEntry"));
        } catch (ZipException e) {
            fail("Failed to create ZipArchiveEntry: " + e.getMessage());
        }
    }

    @Test
    void testGetExtraFields_WithIncludeUnparseableTrue() throws Exception {
        // Prepare mock data
        ZipExtraField[] expectedFields = new ZipExtraField[] { mock(ZipExtraField.class), mock(ZipExtraField.class) };
        // Use reflection to set the extraFields field directly
        setPrivateField(zipArchiveEntry, "extraFields", expectedFields);
        // Invoke the method
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(true);
        // Assert the result
        assertArrayEquals(expectedFields, result);
    }

    @Test
    void testGetExtraFields_WithIncludeUnparseableFalse() throws Exception {
        // Prepare mock data
        ZipExtraField[] expectedFields = new ZipExtraField[] { mock(ZipExtraField.class), mock(ZipExtraField.class) };
        // Use reflection to set the extraFields field directly
        setPrivateField(zipArchiveEntry, "extraFields", expectedFields);
        // Invoke the method
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(false);
        // Assert the result
        assertArrayEquals(expectedFields, result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
