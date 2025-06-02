// Test method
package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarInputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.jar.JarFile;
import org.apache.commons.compress.java.util.jar.Pack200.Packer;
import org.apache.commons.compress.utils.ParsingUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Pack200PackerAdapter_pack_2_1_Test {

    private Pack200PackerAdapter packerAdapter;

    private JarInputStream mockJarInputStream;

    private OutputStream mockOutputStream;

    @BeforeEach
    public void setUp() {
        packerAdapter = new Pack200PackerAdapter();
        mockJarInputStream = Mockito.mock(JarInputStream.class);
        mockOutputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testPack_NullInputStream_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Fixed line
            packerAdapter.pack((JarFile) null, mockOutputStream);
        });
    }

    @Test
    public void testPack_NullOutputStream_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            packerAdapter.pack(mockJarInputStream, null);
        });
    }

    @Test
    public void testPack_ValidInputAndOutput_Success() throws Exception {
        // Arrange
        Archive mockArchive = Mockito.mock(Archive.class);
        doNothing().when(mockArchive).pack();
        // Use reflection to set the private Archive instance
        java.lang.reflect.Field archiveField = Pack200PackerAdapter.class.getDeclaredField("archive");
        archiveField.setAccessible(true);
        archiveField.set(packerAdapter, mockArchive);
        // Act
        packerAdapter.pack(mockJarInputStream, mockOutputStream);
        // Assert
        verify(mockArchive).pack();
        verify(mockJarInputStream).close();
    }

    @Test
    public void testPack_Pack200Exception_ThrowsIOException() throws Exception {
        // Arrange
        Archive mockArchive = Mockito.mock(Archive.class);
        doThrow(new Pack200Exception("Packing error")).when(mockArchive).pack();
        // Use reflection to set the private Archive instance
        java.lang.reflect.Field archiveField = Pack200PackerAdapter.class.getDeclaredField("archive");
        archiveField.setAccessible(true);
        archiveField.set(packerAdapter, mockArchive);
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            packerAdapter.pack(mockJarInputStream, mockOutputStream);
        });
        assertEquals("Failed to pack Jar:Packing error", exception.getMessage());
    }
}
