package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.LinkOption;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class ZipArchiveEntry_setExtraTimeFields_70_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    void setUp() {
        // Initialize a ZipArchiveEntry with a dummy file
        File dummyFile = new File("dummy.txt");
        try {
            if (!dummyFile.exists()) {
                dummyFile.createNewFile();
            }
            zipArchiveEntry = new ZipArchiveEntry(dummyFile, "dummy.txt");
        } catch (IOException e) {
            fail("Setup failed: " + e.getMessage());
        }
    }

    private void invokeSetExtraTimeFields() {
        try {
            Method method = ZipArchiveEntry.class.getDeclaredMethod("setExtraTimeFields");
            method.setAccessible(true);
            method.invoke(zipArchiveEntry);
        } catch (Exception e) {
            fail("Failed to invoke setExtraTimeFields: " + e.getMessage());
        }
    }

    @Test
    void testSetExtraTimeFieldsWithNoExtraFields() {
        zipArchiveEntry.setTime(FileTime.fromMillis(System.currentTimeMillis()));
        zipArchiveEntry.setLastAccessTime(FileTime.fromMillis(System.currentTimeMillis()));
        zipArchiveEntry.setCreationTime(FileTime.fromMillis(System.currentTimeMillis()));
        // Call the method under test
        invokeSetExtraTimeFields();
        // Verify that extra time fields are set correctly
        assertNotNull(zipArchiveEntry.getExtraFields());
        assertTrue(zipArchiveEntry.getExtraFields().length > 0);
    }

    @Test
    void testSetExtraTimeFieldsWithExistingExtraFields() {
        // Add existing extra fields
        zipArchiveEntry.setExtraFields(new ZipExtraField[] { new X5455_ExtendedTimestamp() });
        // Call the method under test
        invokeSetExtraTimeFields();
        // Ensure extra fields are still present after method call
        assertNotNull(zipArchiveEntry.getExtraFields());
        assertTrue(zipArchiveEntry.getExtraFields().length > 0);
    }

    @Test
    void testSetExtraTimeFieldsWithNoLastModified() {
        // Set time without last modified date
        // Simulate no last modified time
        zipArchiveEntry.setTime(-1);
        // Call the method under test
        invokeSetExtraTimeFields();
        // Verify that no extra time fields were added
        assertEquals(0, zipArchiveEntry.getExtraFields().length);
    }

    @Test
    void testSetExtraTimeFieldsWithValidTimes() {
        // Set valid times
        FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis());
        zipArchiveEntry.setLastModifiedTime(lastModifiedTime);
        zipArchiveEntry.setLastAccessTime(lastAccessTime);
        zipArchiveEntry.setCreationTime(creationTime);
        // Call the method under test
        invokeSetExtraTimeFields();
        // Verify that extra time fields were added
        assertNotNull(zipArchiveEntry.getExtraFields());
        assertTrue(zipArchiveEntry.getExtraFields().length > 0);
    }
}
