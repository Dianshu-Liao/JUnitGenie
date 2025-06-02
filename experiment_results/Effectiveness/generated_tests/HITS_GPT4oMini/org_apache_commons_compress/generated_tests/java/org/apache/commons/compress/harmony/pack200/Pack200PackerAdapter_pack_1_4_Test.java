package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.jar.JarFile;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.jar.JarInputStream;
import org.apache.commons.compress.java.util.jar.Pack200.Packer;
import org.apache.commons.compress.utils.ParsingUtils;

public class Pack200PackerAdapter_pack_1_4_Test {

    private Pack200PackerAdapter packerAdapter;

    private JarFile mockJarFile;

    private ByteArrayOutputStream mockOutputStream;

    @BeforeEach
    public void setUp() {
        packerAdapter = new Pack200PackerAdapter();
        mockJarFile = mock(JarFile.class);
        mockOutputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testPack_ValidInputs() throws IOException {
        // Given
        // A valid JarFile and OutputStream are already set up
        // When
        assertDoesNotThrow(() -> packerAdapter.pack(mockJarFile, mockOutputStream));
        // Then
        // Check that the output stream has data (not empty)
        assertTrue(mockOutputStream.size() > 0);
    }

    @Test
    public void testPack_NullJarFile() {
        // Given
        JarFile nullJarFile = null;
        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> packerAdapter.pack(nullJarFile, mockOutputStream));
        assertEquals("Must specify both input and output streams", exception.getMessage());
    }

    @Test
    public void testPack_NullOutputStream() {
        // Given
        OutputStream nullOutputStream = null;
        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> packerAdapter.pack(mockJarFile, nullOutputStream));
        assertEquals("Must specify both input and output streams", exception.getMessage());
    }

    @Test
    public void testPack_Pack200Exception() throws IOException {
        // Given
        doThrow(new Pack200Exception("Packing error")).when(mockJarFile).close();
        // When & Then
        IOException exception = assertThrows(IOException.class, () -> packerAdapter.pack(mockJarFile, mockOutputStream));
        assertTrue(exception.getMessage().contains("Failed to pack Jar:"));
    }
}
