package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData;
import java.util.Arrays;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ZipArchiveEntry_getExtraFields_23_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    void testGetExtraFieldsWithNoExtraFields() {
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(0, extraFields.length);
    }

    @Test
    void testGetExtraFieldsWithParseableExtraFields() {
        ZipExtraField field1 = mock(ZipExtraField.class);
        ZipExtraField field2 = mock(ZipExtraField.class);
        when(field1.getHeaderId()).thenReturn(new ZipShort((short) 1));
        when(field2.getHeaderId()).thenReturn(new ZipShort((short) 2));
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { field1, field2 });
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(2, extraFields.length);
        assertTrue(Arrays.asList(extraFields).contains(field1));
        assertTrue(Arrays.asList(extraFields).contains(field2));
    }

    @Test
    void testGetExtraFieldsWithUnparseableExtraField() {
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { unparseableField });
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(1, extraFields.length);
        assertTrue(Arrays.asList(extraFields).contains(unparseableField));
    }

    @Test
    void testGetExtraFieldsWithMixedExtraFields() {
        ZipExtraField parseableField = mock(ZipExtraField.class);
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        when(parseableField.getHeaderId()).thenReturn(new ZipShort((short) 3));
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { parseableField, unparseableField });
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(2, extraFields.length);
        assertTrue(Arrays.asList(extraFields).contains(parseableField));
        assertTrue(Arrays.asList(extraFields).contains(unparseableField));
    }
}
