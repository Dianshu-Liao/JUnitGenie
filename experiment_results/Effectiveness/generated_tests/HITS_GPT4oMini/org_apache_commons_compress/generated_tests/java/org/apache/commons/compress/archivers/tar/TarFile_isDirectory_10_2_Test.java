package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.input.BoundedInputStream;

public class TarFile_isDirectory_10_2_Test {

    private TarFile tarFile;

    private TarArchiveEntry mockEntry;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize TarFile with a dummy content
        byte[] dummyContent = new byte[] {};
        tarFile = new TarFile(dummyContent);
        mockEntry = Mockito.mock(TarArchiveEntry.class);
    }

    @Test
    public void testIsDirectoryWhenCurrentEntryIsNull() throws Exception {
        // Given: currEntry is null
        // When: isDirectory is called
        boolean result = invokeIsDirectory();
        // Then: it should return false
        assertFalse(result, "Expected isDirectory to return false when currEntry is null");
    }

    @Test
    public void testIsDirectoryWhenCurrentEntryIsNotADirectory() throws Exception {
        // Given: a non-directory TarArchiveEntry
        Mockito.when(mockEntry.isDirectory()).thenReturn(false);
        setCurrentEntry(mockEntry);
        // When: isDirectory is called
        boolean result = invokeIsDirectory();
        // Then: it should return false
        assertFalse(result, "Expected isDirectory to return false when currEntry is a file");
    }

    @Test
    public void testIsDirectoryWhenCurrentEntryIsADirectory() throws Exception {
        // Given: a directory TarArchiveEntry
        Mockito.when(mockEntry.isDirectory()).thenReturn(true);
        setCurrentEntry(mockEntry);
        // When: isDirectory is called
        boolean result = invokeIsDirectory();
        // Then: it should return true
        assertTrue(result, "Expected isDirectory to return true when currEntry is a directory");
    }

    @Test
    public void testIsDirectoryWithDirectoryEntryWithoutTrailingSlash() throws Exception {
        // Given: a directory TarArchiveEntry without trailing slash
        Mockito.when(mockEntry.isDirectory()).thenReturn(true);
        setCurrentEntry(mockEntry);
        // When: isDirectory is called
        boolean result = invokeIsDirectory();
        // Then: it should return true as we handle directories without trailing slash
        assertTrue(result, "Expected isDirectory to return true for a directory entry without trailing slash");
    }

    private boolean invokeIsDirectory() throws Exception {
        // Use reflection to access the private isDirectory method
        Field currEntryField = TarFile.class.getDeclaredField("currEntry");
        currEntryField.setAccessible(true);
        currEntryField.set(tarFile, mockEntry);
        return (boolean) TarFile.class.getDeclaredMethod("isDirectory").invoke(tarFile);
    }

    private void setCurrentEntry(TarArchiveEntry entry) throws Exception {
        Field currEntryField = TarFile.class.getDeclaredField("currEntry");
        currEntryField.setAccessible(true);
        currEntryField.set(tarFile, entry);
    }
}
