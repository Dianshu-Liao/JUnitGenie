package org.apache.commons.compress.archivers.zip;

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

@ExtendWith(MockitoExtension.class)
public class ZipArchiveEntry_getExtraFields_23_1_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    public void testGetExtraFields_NoExtraFields() {
        // Test when there are no extra fields set
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(0, extraFields.length);
    }

    @Test
    public void testGetExtraFields_WithExtraFields() {
        // Test when extra fields are set
        ZipExtraField extraField1 = mock(ZipExtraField.class);
        ZipExtraField extraField2 = mock(ZipExtraField.class);
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { extraField1, extraField2 });
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(2, extraFields.length);
        assertEquals(extraField1, extraFields[0]);
        assertEquals(extraField2, extraFields[1]);
    }

    @Test
    public void testGetExtraFields_WithUnparseableExtraField() {
        // Test when there is an unparseable extra field
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { unparseableField });
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(1, extraFields.length);
        assertEquals(unparseableField, extraFields[0]);
    }

    @Test
    public void testGetExtraFields_WithNullExtraFields() {
        // Test when extra fields are set to null
        zipArchiveEntry.setExtraFields(null);
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(0, extraFields.length);
    }

    @Test
    public void testGetExtraFields_WithMixedExtraFields() {
        // Test when there are mixed extra fields (parseable and unparseable)
        ZipExtraField parseableField = mock(ZipExtraField.class);
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { parseableField, unparseableField });
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(2, extraFields.length);
        assertEquals(parseableField, extraFields[0]);
        assertEquals(unparseableField, extraFields[1]);
    }
}
