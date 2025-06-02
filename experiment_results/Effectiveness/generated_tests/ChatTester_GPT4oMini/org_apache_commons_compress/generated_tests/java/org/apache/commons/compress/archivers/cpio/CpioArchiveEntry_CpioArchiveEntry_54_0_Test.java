package org.apache.commons.compress.archivers.cpio;

import java.io.File;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

public class CpioArchiveEntry_CpioArchiveEntry_54_0_Test {

    private static final short FORMAT = 1;

    // Example mode for directory
    private static final long C_ISDIR = 0x4000;

    // Example mode for regular file
    private static final long C_ISREG = 0x8000;

    private CpioArchiveEntry entry;

    private File mockFile;

    @BeforeEach
    public void setUp() {
        mockFile = mock(File.class);
    }

    @Test
    public void testConstructorWithFileAsDirectory() {
        when(mockFile.isFile()).thenReturn(false);
        when(mockFile.isDirectory()).thenReturn(true);
        when(mockFile.getName()).thenReturn("testDir");
        when(mockFile.lastModified()).thenReturn(1000L);
        when(mockFile.length()).thenReturn(0L);
        entry = new CpioArchiveEntry(FORMAT, mockFile, "testDir");
        assertNotNull(entry);
        assertEquals(C_ISDIR, invokePrivateMethod(entry, "getMode"));
        assertEquals("testDir", invokePrivateMethod(entry, "getName"));
        // Check time in seconds
        assertEquals(1000L / 1000, invokePrivateMethod(entry, "getTime"));
    }

    @Test
    public void testConstructorWithFileAsRegularFile() {
        when(mockFile.isFile()).thenReturn(true);
        when(mockFile.isDirectory()).thenReturn(false);
        when(mockFile.getName()).thenReturn("testFile");
        when(mockFile.lastModified()).thenReturn(2000L);
        when(mockFile.length()).thenReturn(100L);
        entry = new CpioArchiveEntry(FORMAT, mockFile, "testFile");
        assertNotNull(entry);
        assertEquals(C_ISREG, invokePrivateMethod(entry, "getMode"));
        assertEquals("testFile", invokePrivateMethod(entry, "getName"));
        // Check time in seconds
        assertEquals(2000L / 1000, invokePrivateMethod(entry, "getTime"));
    }

    @Test
    public void testConstructorWithInvalidFile() {
        when(mockFile.isFile()).thenReturn(false);
        when(mockFile.isDirectory()).thenReturn(false);
        when(mockFile.getName()).thenReturn("invalidFile");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            entry = new CpioArchiveEntry(FORMAT, mockFile, "invalidFile");
        });
        assertEquals("Cannot determine type of file invalidFile", thrown.getMessage());
    }

    private Object invokePrivateMethod(Object obj, String methodName, Class<?>... parameterTypes) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method.invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
