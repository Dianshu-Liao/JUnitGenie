package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;

@ExtendWith(MockitoExtension.class)
public class Archive_doZeroEffortPack_2_0_Test {

    private Archive archive;

    @Mock
    private JarInputStream mockJarInputStream;

    @Mock
    private JarFile mockJarFile;

    private OutputStream mockOutputStream;

    private PackingOptions mockOptions;

    @BeforeEach
    public void setUp() {
        mockOutputStream = new ByteArrayOutputStream();
        mockOptions = new PackingOptions();
    }

    @Test
    public void testDoZeroEffortPack_WithJarInputStream() throws Exception {
        // Arrange
        archive = new Archive(mockJarInputStream, mockOutputStream, mockOptions);
        when(mockJarInputStream.getNextJarEntry()).thenReturn(new JarEntry("testEntry.jar"), null);
        try (MockedStatic<PackingUtils> mockedPackingUtils = mockStatic(PackingUtils.class)) {
            // Act
            invokeDoZeroEffortPack(archive);
            // Assert
            mockedPackingUtils.verify(() -> PackingUtils.copyThroughJar(mockJarInputStream, mockOutputStream), times(1));
        }
    }

    @Test
    public void testDoZeroEffortPack_WithJarFile() throws Exception {
        // Arrange
        archive = new Archive(mockJarFile, mockOutputStream, mockOptions);
        JarEntry mockEntry = new JarEntry("testEntry.jar");
        when(mockJarFile.entries()).thenReturn(new Enumeration<JarEntry>() {

            private boolean hasMore = true;

            @Override
            public boolean hasMoreElements() {
                return hasMore;
            }

            @Override
            public JarEntry nextElement() {
                if (hasMore) {
                    hasMore = false;
                    return mockEntry;
                } else {
                    return null;
                }
            }
        });
        try (MockedStatic<PackingUtils> mockedPackingUtils = mockStatic(PackingUtils.class)) {
            // Act
            invokeDoZeroEffortPack(archive);
            // Assert
            mockedPackingUtils.verify(() -> PackingUtils.copyThroughJar(mockJarFile, mockOutputStream), times(1));
        }
    }

    // Helper method to invoke the private method using reflection
    private void invokeDoZeroEffortPack(Archive archive) throws Exception {
        Method method = Archive.class.getDeclaredMethod("doZeroEffortPack");
        method.setAccessible(true);
        method.invoke(archive);
    }
}
