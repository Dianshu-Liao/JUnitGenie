package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
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

    private TarArchiveEntry mockEntry;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize TarFile with a mock SeekableByteChannel or any other constructor as needed
        tarFile = new TarFile(new byte[] {});
        mockEntry = mock(TarArchiveEntry.class);
    }

    @Test
    public void testIsDirectory_WhenCurrEntryIsNull_ShouldReturnFalse() throws Exception {
        // Use reflection to access the private field currEntry
        setCurrEntry(tarFile, null);
        Method isDirectoryMethod = TarFile.class.getDeclaredMethod("isDirectory");
        isDirectoryMethod.setAccessible(true);
        boolean result = (boolean) isDirectoryMethod.invoke(tarFile);
        assertFalse(result);
    }

    @Test
    public void testIsDirectory_WhenCurrEntryIsNotDirectory_ShouldReturnFalse() throws Exception {
        // Set up a non-directory entry
        when(mockEntry.isDirectory()).thenReturn(false);
        setCurrEntry(tarFile, mockEntry);
        Method isDirectoryMethod = TarFile.class.getDeclaredMethod("isDirectory");
        isDirectoryMethod.setAccessible(true);
        boolean result = (boolean) isDirectoryMethod.invoke(tarFile);
        assertFalse(result);
    }

    @Test
    public void testIsDirectory_WhenCurrEntryIsDirectory_ShouldReturnTrue() throws Exception {
        // Set up a directory entry
        when(mockEntry.isDirectory()).thenReturn(true);
        setCurrEntry(tarFile, mockEntry);
        Method isDirectoryMethod = TarFile.class.getDeclaredMethod("isDirectory");
        isDirectoryMethod.setAccessible(true);
        boolean result = (boolean) isDirectoryMethod.invoke(tarFile);
        assertTrue(result);
    }

    private void setCurrEntry(TarFile tarFile, TarArchiveEntry entry) throws Exception {
        // Use reflection to set the private field currEntry
        java.lang.reflect.Field currEntryField = TarFile.class.getDeclaredField("currEntry");
        currEntryField.setAccessible(true);
        currEntryField.set(tarFile, entry);
    }
}
