package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.Archive;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.apache.commons.compress.harmony.pack200.PackingUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;

class Archive_doZeroEffortPack_2_0_Test {

    private Archive archive;

    private JarFile mockJarFile;

    private JarInputStream mockJarInputStream;

    private OutputStream mockOutputStream;

    private PackingOptions mockPackingOptions;

    @BeforeEach
    void setUp() throws IOException {
        mockJarFile = mock(JarFile.class);
        mockJarInputStream = mock(JarInputStream.class);
        mockOutputStream = new ByteArrayOutputStream();
        mockPackingOptions = new PackingOptions();
        // Initialize Archive with JarFile
        archive = new Archive(mockJarFile, mockOutputStream, mockPackingOptions);
    }

    @Test
    void testDoZeroEffortPackWithJarFile() throws Exception {
        // Arrange
        // Prepare the mock behavior for PackingUtils
        doNothing().when(mockJarFile).close();
        doNothing().when(mockOutputStream).close();
        // Act
        invokeDoZeroEffortPack();
        // Assert
        verify(mockJarFile, times(1)).close();
        verify(mockOutputStream, times(1)).close();
    }

    @Test
    void testDoZeroEffortPackWithJarInputStream() throws Exception {
        // Arrange
        archive = new Archive(mockJarInputStream, mockOutputStream, mockPackingOptions);
        // Prepare the mock behavior for PackingUtils
        doNothing().when(mockJarInputStream).close();
        doNothing().when(mockOutputStream).close();
        // Act
        invokeDoZeroEffortPack();
        // Assert
        verify(mockJarInputStream, times(1)).close();
        verify(mockOutputStream, times(1)).close();
    }

    private void invokeDoZeroEffortPack() throws Exception {
        Method method = Archive.class.getDeclaredMethod("doZeroEffortPack");
        method.setAccessible(true);
        method.invoke(archive);
    }
}
