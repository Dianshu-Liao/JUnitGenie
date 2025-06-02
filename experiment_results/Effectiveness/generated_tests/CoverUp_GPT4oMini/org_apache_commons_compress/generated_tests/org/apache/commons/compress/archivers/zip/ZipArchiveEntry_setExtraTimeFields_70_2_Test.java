package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.file.attribute.FileTimes;

class ZipArchiveEntry_setExtraTimeFields_70_2_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    void testSetExtraTimeFieldsWithNoExtraFields() throws Exception {
        invokeSetExtraTimeFields();
        assertNull(zipArchiveEntry.getExtraField(X5455_ExtendedTimestamp.HEADER_ID));
        assertNull(zipArchiveEntry.getExtraField(X000A_NTFS.HEADER_ID));
    }

    @Test
    void testSetExtraTimeFieldsWithExtendedTimestamp() throws Exception {
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { new X5455_ExtendedTimestamp() });
        invokeSetExtraTimeFields();
        assertNull(zipArchiveEntry.getExtraField(X5455_ExtendedTimestamp.HEADER_ID));
    }

    @Test
    void testSetExtraTimeFieldsWithNTFSTimestamp() throws Exception {
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { new X000A_NTFS() });
        invokeSetExtraTimeFields();
        assertNull(zipArchiveEntry.getExtraField(X000A_NTFS.HEADER_ID));
    }

    @Test
    void testSetExtraTimeFieldsWithValidTimestamps() throws Exception {
        // Set last modified, access and creation times
        zipArchiveEntry.setTime(FileTime.fromMillis(System.currentTimeMillis()));
        zipArchiveEntry.setLastAccessTime(FileTime.fromMillis(System.currentTimeMillis()));
        zipArchiveEntry.setCreationTime(FileTime.fromMillis(System.currentTimeMillis()));
        invokeSetExtraTimeFields();
        assertNotNull(zipArchiveEntry.getExtraField(X5455_ExtendedTimestamp.HEADER_ID));
        assertNotNull(zipArchiveEntry.getExtraField(X000A_NTFS.HEADER_ID));
    }

    private void invokeSetExtraTimeFields() throws Exception {
        Method method = ZipArchiveEntry.class.getDeclaredMethod("setExtraTimeFields");
        method.setAccessible(true);
        method.invoke(zipArchiveEntry);
    }
}
