package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.GeneralPurposeBit;
import java.lang.reflect.Method;
import java.util.Arrays;
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

class ZipArchiveEntry_getRawName_39_0_Test {

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    void setUp() {
        zipArchiveEntry = new ZipArchiveEntry("testEntry");
    }

    @Test
    void testGetRawName_WhenRawNameIsNotNull() throws Exception {
        // Prepare the rawName
        byte[] expectedRawName = "testRawName".getBytes();
        setRawName(zipArchiveEntry, expectedRawName);
        // Call the method under test
        byte[] actualRawName = zipArchiveEntry.getRawName();
        // Assert the expected outcome
        assertNotNull(actualRawName);
        assertArrayEquals(expectedRawName, actualRawName);
    }

    @Test
    void testGetRawName_WhenRawNameIsNull() throws Exception {
        // Ensure rawName is null
        assertNull(zipArchiveEntry.getRawName());
    }

    private void setRawName(ZipArchiveEntry entry, byte[] rawName) throws Exception {
        Method method = ZipArchiveEntry.class.getDeclaredMethod("setName", String.class, byte[].class);
        method.setAccessible(true);
        method.invoke(entry, "testEntry", rawName);
    }
}
