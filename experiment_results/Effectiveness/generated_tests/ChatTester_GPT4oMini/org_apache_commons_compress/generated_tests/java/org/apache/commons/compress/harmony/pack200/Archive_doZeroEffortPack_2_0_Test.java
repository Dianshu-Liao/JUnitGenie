package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
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

    private PackingOptions mockOptions;

    @BeforeEach
    void setUp() throws IOException {
        mockJarFile = mock(JarFile.class);
        mockJarInputStream = mock(JarInputStream.class);
        mockOutputStream = mock(OutputStream.class);
        mockOptions = mock(PackingOptions.class);
        archive = new Archive(mockJarFile, mockOutputStream, mockOptions);
    }

    @Test
    void testDoZeroEffortPackWithJarInputStream() throws Exception {
        // Arrange
        archive = new Archive(mockJarInputStream, mockOutputStream, mockOptions);
        // Act
        invokePrivateMethod("doZeroEffortPack");
        // Assert
        verify(mockOutputStream, times(1)).write(any(byte[].class), anyInt(), anyInt());
    }

    @Test
    void testDoZeroEffortPackWithJarFile() throws Exception {
        // Act
        invokePrivateMethod("doZeroEffortPack");
        // Assert
        verify(mockOutputStream, times(1)).write(any(byte[].class), anyInt(), anyInt());
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = Archive.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(archive);
    }
}
