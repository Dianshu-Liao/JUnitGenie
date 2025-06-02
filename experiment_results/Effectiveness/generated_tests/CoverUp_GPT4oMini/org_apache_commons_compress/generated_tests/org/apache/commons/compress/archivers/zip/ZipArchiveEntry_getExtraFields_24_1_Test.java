package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class ZipArchiveEntry_getExtraFields_24_1_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    public void testGetExtraFieldsWithParseableFields() {
        ZipExtraField parseableField = mock(ZipExtraField.class);
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { parseableField });
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(false);
        assertArrayEquals(new ZipExtraField[] { parseableField }, result);
    }

    @Test
    public void testGetExtraFieldsWithUnparseableFields() {
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { unparseableField });
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(true);
        assertEquals(1, result.length);
        assertSame(unparseableField, result[0]);
    }

    @Test
    public void testGetExtraFieldsWhenNoFieldsSet() {
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(false);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testGetExtraFieldsWithMixedFields() {
        ZipExtraField parseableField = mock(ZipExtraField.class);
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { parseableField, unparseableField });
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(true);
        assertEquals(2, result.length);
        assertSame(parseableField, result[0]);
        assertSame(unparseableField, result[1]);
    }

    @Test
    public void testGetExtraFieldsWithOnlyUnparseableField() {
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { unparseableField });
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(false);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    // Reflection test for private method
    @Test
    public void testInvokePrivateMethod() throws Exception {
        Method method = ZipArchiveEntry.class.getDeclaredMethod("getAllExtraFields");
        method.setAccessible(true);
        ZipExtraField[] result = (ZipExtraField[]) method.invoke(zipArchiveEntry);
        assertNotNull(result);
    }
}
