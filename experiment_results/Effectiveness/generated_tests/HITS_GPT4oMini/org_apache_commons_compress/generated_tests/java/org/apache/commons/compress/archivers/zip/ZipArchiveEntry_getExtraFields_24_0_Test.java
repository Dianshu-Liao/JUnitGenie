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

public class ZipArchiveEntry_getExtraFields_24_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    public void testGetExtraFields_WithIncludeUnparseableTrue() {
        // Given: Set up the extra fields including unparseable
        ZipExtraField mockField1 = mock(ZipExtraField.class);
        // Use ZipShort instead of String
        when(mockField1.getHeaderId()).thenReturn(new ZipShort(1));
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { mockField1, unparseableField });
        // When: Calling getExtraFields with true
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(true);
        // Then: It should return all extra fields including unparseable
        assertEquals(2, result.length);
        // Check ZipShort value
        assertEquals(1, ((ZipShort) result[0].getHeaderId()).getValue());
        assertTrue(result[1] instanceof UnparseableExtraFieldData);
    }

    @Test
    public void testGetExtraFields_WithIncludeUnparseableFalse() {
        // Given: Set up the extra fields without unparseable
        ZipExtraField mockField1 = mock(ZipExtraField.class);
        // Use ZipShort instead of String
        when(mockField1.getHeaderId()).thenReturn(new ZipShort(1));
        ZipExtraField mockField2 = mock(ZipExtraField.class);
        // Use ZipShort instead of String
        when(mockField2.getHeaderId()).thenReturn(new ZipShort(2));
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { mockField1, mockField2 });
        // When: Calling getExtraFields with false
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(false);
        // Then: It should return only parseable extra fields
        assertEquals(2, result.length);
        // Check ZipShort value
        assertEquals(1, ((ZipShort) result[0].getHeaderId()).getValue());
        // Check ZipShort value
        assertEquals(2, ((ZipShort) result[1].getHeaderId()).getValue());
    }

    @Test
    public void testGetExtraFields_NoExtraFields() {
        // When: Calling getExtraFields with true
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(true);
        // Then: It should return an empty array
        assertEquals(0, result.length);
    }

    @Test
    public void testGetExtraFields_WithOnlyUnparseableField() {
        // Given: Set up only unparseable extra field
        UnparseableExtraFieldData unparseableField = new UnparseableExtraFieldData();
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { unparseableField });
        // When: Calling getExtraFields with false
        ZipExtraField[] result = zipArchiveEntry.getExtraFields(false);
        // Then: It should return an empty array as there are no parseable fields
        assertEquals(0, result.length);
    }
}
