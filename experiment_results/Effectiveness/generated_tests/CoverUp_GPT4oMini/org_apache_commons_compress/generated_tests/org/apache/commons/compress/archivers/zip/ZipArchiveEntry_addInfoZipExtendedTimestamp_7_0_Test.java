package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
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

class ZipArchiveEntry_addInfoZipExtendedTimestamp_7_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry.zip");
    }

    @Test
    void testAddInfoZipExtendedTimestampWithAllTimestamps() throws Exception {
        FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis() - 10000);
        FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis() - 20000);
        invokeAddInfoZipExtendedTimestamp(lastModifiedTime, lastAccessTime, creationTime);
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(1, extraFields.length);
        assertTrue(extraFields[0] instanceof X5455_ExtendedTimestamp);
        X5455_ExtendedTimestamp timestamp = (X5455_ExtendedTimestamp) extraFields[0];
        assertEquals(lastModifiedTime, timestamp.getModifyFileTime());
        assertEquals(lastAccessTime, timestamp.getAccessFileTime());
        assertEquals(creationTime, timestamp.getCreateFileTime());
    }

    @Test
    void testAddInfoZipExtendedTimestampWithNullLastAccessAndCreation() throws Exception {
        FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime lastAccessTime = null;
        FileTime creationTime = null;
        invokeAddInfoZipExtendedTimestamp(lastModifiedTime, lastAccessTime, creationTime);
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(1, extraFields.length);
        X5455_ExtendedTimestamp timestamp = (X5455_ExtendedTimestamp) extraFields[0];
        assertEquals(lastModifiedTime, timestamp.getModifyFileTime());
        assertNull(timestamp.getAccessFileTime());
        assertNull(timestamp.getCreateFileTime());
    }

    @Test
    void testAddInfoZipExtendedTimestampWithAllNullTimestamps() throws Exception {
        FileTime lastModifiedTime = null;
        FileTime lastAccessTime = null;
        FileTime creationTime = null;
        invokeAddInfoZipExtendedTimestamp(lastModifiedTime, lastAccessTime, creationTime);
        ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
        assertNotNull(extraFields);
        assertEquals(1, extraFields.length);
        X5455_ExtendedTimestamp timestamp = (X5455_ExtendedTimestamp) extraFields[0];
        assertNull(timestamp.getModifyFileTime());
        assertNull(timestamp.getAccessFileTime());
        assertNull(timestamp.getCreateFileTime());
    }

    private void invokeAddInfoZipExtendedTimestamp(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime creationTime) throws Exception {
        Method method = ZipArchiveEntry.class.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
        method.setAccessible(true);
        method.invoke(zipArchiveEntry, lastModifiedTime, lastAccessTime, creationTime);
    }
}
