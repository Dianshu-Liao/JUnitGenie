package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

public class TarFile_isDirectory_10_0_Test {

    private TarFile tarFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize TarFile with a mock content
        byte[] content = new byte[1024];
        tarFile = new TarFile(content);
    }

    @Test
    public void testIsDirectoryWhenCurrEntryIsNull() throws Exception {
        // Arrange
        // Simulate currEntry being null using reflection
        setCurrEntry(null);
        // Act
        boolean result = invokeIsDirectory();
        // Assert
        assertFalse(result, "Expected isDirectory to return false when currEntry is null");
    }

    @Test
    public void testIsDirectoryWhenCurrEntryIsNotADirectory() throws Exception {
        // Arrange
        // Example header for a non-directory entry
        byte[] headerBuf = new byte[100];
        // Setting up a non-directory entry using reflection
        setCurrEntry(new TarArchiveEntry(headerBuf));
        // Act
        boolean result = invokeIsDirectory();
        // Assert
        assertFalse(result, "Expected isDirectory to return false when currEntry is not a directory");
    }

    @Test
    public void testIsDirectoryWhenCurrEntryIsADirectory() throws Exception {
        // Arrange
        // Setting up a directory entry using reflection
        TarArchiveEntry directoryEntry = new TarArchiveEntry("testDir/");
        setCurrEntry(directoryEntry);
        // Act
        boolean result = invokeIsDirectory();
        // Assert
        assertTrue(result, "Expected isDirectory to return true when currEntry is a directory");
    }

    private void setCurrEntry(TarArchiveEntry entry) throws Exception {
        Field currEntryField = TarFile.class.getDeclaredField("currEntry");
        currEntryField.setAccessible(true);
        currEntryField.set(tarFile, entry);
    }

    private boolean invokeIsDirectory() throws Exception {
        Method isDirectoryMethod = TarFile.class.getDeclaredMethod("isDirectory");
        isDirectoryMethod.setAccessible(true);
        return (boolean) isDirectoryMethod.invoke(tarFile);
    }
}
