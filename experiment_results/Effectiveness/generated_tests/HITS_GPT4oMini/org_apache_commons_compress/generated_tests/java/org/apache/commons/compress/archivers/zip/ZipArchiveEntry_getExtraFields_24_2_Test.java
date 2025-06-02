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

public class ZipArchiveEntry_getExtraFields_24_2_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    public void testGetExtraFieldsWithIncludeUnparseableTrue() {
        // Given: Extra fields set
        ZipExtraField field1 = mock(ZipExtraField.class);
        ZipExtraField field2 = mock(ZipExtraField.class);
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { field1, field2 });
        // When: Getting extra fields with includeUnparseable as true
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields(true);
        // Then: The extra fields should be returned
        assertNotNull(extraFields);
        assertArrayEquals(new ZipExtraField[] { field1, field2 }, extraFields);
    }

    @Test
    public void testGetExtraFieldsWithIncludeUnparseableFalse() {
        // Given: Extra fields set
        ZipExtraField field1 = mock(ZipExtraField.class);
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { field1 });
        // When: Getting extra fields with includeUnparseable as false
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields(false);
        // Then: The parseable extra fields should be returned
        assertNotNull(extraFields);
        assertArrayEquals(new ZipExtraField[] { field1 }, extraFields);
    }

    @Test
    public void testGetExtraFieldsWhenNoExtraFields() {
        // When: Getting extra fields when none are set
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields(true);
        // Then: Should return an empty array
        assertNotNull(extraFields);
        assertArrayEquals(new ZipExtraField[] {}, extraFields);
    }

    @Test
    public void testGetExtraFieldsWithUnparseableField() {
        // Given: An unparseable extra field
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { unparseableField });
        // When: Getting extra fields with includeUnparseable as true
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields(true);
        // Then: Should return the unparseable extra field
        assertNotNull(extraFields);
        assertArrayEquals(new ZipExtraField[] { unparseableField }, extraFields);
    }
}
