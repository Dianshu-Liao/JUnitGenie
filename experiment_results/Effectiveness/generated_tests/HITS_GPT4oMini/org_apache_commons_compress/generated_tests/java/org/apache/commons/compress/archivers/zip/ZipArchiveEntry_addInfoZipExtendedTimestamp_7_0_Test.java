package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Method;
import java.nio.file.attribute.FileTime;
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

public class ZipArchiveEntry_addInfoZipExtendedTimestamp_7_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    private void invokeAddInfoZipExtendedTimestamp(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime creationTime) throws Exception {
        Method method = ZipArchiveEntry.class.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
        method.setAccessible(true);
        method.invoke(zipArchiveEntry, lastModifiedTime, lastAccessTime, creationTime);
    }

    @Test
    public void testAddInfoZipExtendedTimestamp_withAllTimestamps() throws Exception {
        FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis() - 10000);
        FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis() - 20000);
        invokeAddInfoZipExtendedTimestamp(lastModifiedTime, lastAccessTime, creationTime);
        X5455_ExtendedTimestamp extendedTimestamp = (X5455_ExtendedTimestamp) zipArchiveEntry.getExtraField(X5455_ExtendedTimestamp.HEADER_ID);
        assertNotNull(extendedTimestamp);
        assertNotNull(extendedTimestamp.getModifyFileTime());
        assertNotNull(extendedTimestamp.getAccessFileTime());
        assertNotNull(extendedTimestamp.getCreateFileTime());
    }

    @Test
    public void testAddInfoZipExtendedTimestamp_withNullLastAccessTime() throws Exception {
        FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis() - 20000);
        invokeAddInfoZipExtendedTimestamp(lastModifiedTime, null, creationTime);
        X5455_ExtendedTimestamp extendedTimestamp = (X5455_ExtendedTimestamp) zipArchiveEntry.getExtraField(X5455_ExtendedTimestamp.HEADER_ID);
        assertNotNull(extendedTimestamp);
        assertNotNull(extendedTimestamp.getModifyFileTime());
        assertNull(extendedTimestamp.getAccessFileTime());
        assertNotNull(extendedTimestamp.getCreateFileTime());
    }

    @Test
    public void testAddInfoZipExtendedTimestamp_withNullCreationTime() throws Exception {
        FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis() - 10000);
        invokeAddInfoZipExtendedTimestamp(lastModifiedTime, lastAccessTime, null);
        X5455_ExtendedTimestamp extendedTimestamp = (X5455_ExtendedTimestamp) zipArchiveEntry.getExtraField(X5455_ExtendedTimestamp.HEADER_ID);
        assertNotNull(extendedTimestamp);
        assertNotNull(extendedTimestamp.getModifyFileTime());
        assertNotNull(extendedTimestamp.getAccessFileTime());
        assertNull(extendedTimestamp.getCreateFileTime());
    }
}
