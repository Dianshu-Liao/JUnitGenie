package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.Archive;
import org.apache.commons.compress.harmony.pack200.Pack200PackerAdapter;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.jar.JarInputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.jar.JarFile;
import org.apache.commons.compress.java.util.jar.Pack200.Packer;
import org.apache.commons.compress.utils.ParsingUtils;

class Pack200PackerAdapter_pack_2_1_Test {

    private Pack200PackerAdapter packerAdapter;

    @BeforeEach
    void setUp() {
        packerAdapter = new Pack200PackerAdapter();
    }

    @Test
    void testPack_NullInputStream_ThrowsIllegalArgumentException() {
        OutputStream out = new ByteArrayOutputStream();
        assertThrows(IllegalArgumentException.class, () -> packerAdapter.pack((JarInputStream) null, out));
    }

    @Test
    void testPack_NullOutputStream_ThrowsIllegalArgumentException() {
        JarInputStream in = mock(JarInputStream.class);
        assertThrows(IllegalArgumentException.class, () -> packerAdapter.pack(in, null));
    }

    @Test
    void testPack_ValidInputStreamAndOutputStream_CallsPackMethod() throws IOException {
        JarInputStream in = mock(JarInputStream.class);
        OutputStream out = new ByteArrayOutputStream();
        Archive archiveMock = mock(Archive.class);
        // Use reflection to set the private Archive in Pack200PackerAdapter
        try {
            java.lang.reflect.Field archiveField = Pack200PackerAdapter.class.getDeclaredField("archive");
            archiveField.setAccessible(true);
            archiveField.set(packerAdapter, archiveMock);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        packerAdapter.pack(in, out);
        verify(archiveMock).pack();
    }

    @Test
    void testPack_Pack200Exception_ThrowsIOException() throws IOException {
        JarInputStream in = mock(JarInputStream.class);
        OutputStream out = new ByteArrayOutputStream();
        Archive archiveMock = mock(Archive.class);
        // Use reflection to set the private Archive in Pack200PackerAdapter
        try {
            java.lang.reflect.Field archiveField = Pack200PackerAdapter.class.getDeclaredField("archive");
            archiveField.setAccessible(true);
            archiveField.set(packerAdapter, archiveMock);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        doThrow(new Pack200Exception("Packing failed")).when(archiveMock).pack();
        assertThrows(IOException.class, () -> packerAdapter.pack(in, out));
    }
}
