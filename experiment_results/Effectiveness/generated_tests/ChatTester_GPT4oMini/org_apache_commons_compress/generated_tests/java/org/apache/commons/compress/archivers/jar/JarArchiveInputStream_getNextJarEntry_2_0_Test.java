package org.apache.commons.compress.archivers.jar;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;

public class JarArchiveInputStream_getNextJarEntry_2_0_Test {

    private JarArchiveInputStream jarArchiveInputStream;

    private InputStream mockInputStream;

    @BeforeEach
    public void setUp() {
        mockInputStream = mock(InputStream.class);
        jarArchiveInputStream = new JarArchiveInputStream(mockInputStream);
    }

    @Test
    public void testGetNextJarEntryReturnsNullWhenNoNextZipEntry() throws Exception {
        // Arrange
        setNextZipEntry(null);
        // Act
        JarArchiveEntry result = jarArchiveInputStream.getNextJarEntry();
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetNextJarEntryReturnsJarArchiveEntryWhenZipEntryExists() throws Exception {
        // Arrange
        ZipArchiveEntry mockZipEntry = mock(ZipArchiveEntry.class);
        when(mockZipEntry.getName()).thenReturn("mockEntry");
        setNextZipEntry(mockZipEntry);
        // Act
        JarArchiveEntry result = jarArchiveInputStream.getNextJarEntry();
        // Assert
        assertNotNull(result);
        assertEquals("mockEntry", result.getName());
    }

    private void setNextZipEntry(ZipArchiveEntry entry) throws Exception {
        // Using reflection to access the private method getNextZipEntry()
        java.lang.reflect.Method method = JarArchiveInputStream.class.getDeclaredMethod("getNextZipEntry");
        method.setAccessible(true);
        // Mocking the behavior of getNextZipEntry
        JarArchiveInputStream jarInputStreamSpy = spy(jarArchiveInputStream);
        doReturn(entry).when(jarInputStreamSpy).getNextZipEntry();
        // Reassign the spy to the original variable
        jarArchiveInputStream = jarInputStreamSpy;
    }
}
