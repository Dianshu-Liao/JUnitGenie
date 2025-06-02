package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.jar.JarFile;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.jar.JarOutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.commons.compress.harmony.pack200.Archive.PackingFile;

public class PackingUtils_getPackingFileListFromJar_4_0_Test {

    private JarInputStream jarInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Mocking a JarInputStream with a manifest and some entries
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Manifest manifest = new Manifest();
        manifest.write(baos);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        jarInputStream = Mockito.mock(JarInputStream.class);
        Mockito.when(jarInputStream.getManifest()).thenReturn(manifest);
        Mockito.when(jarInputStream.getNextJarEntry()).thenReturn(createJarEntry("testFile1.txt", 100), createJarEntry("testFile2.txt", 200), null);
        Mockito.when(jarInputStream.read(Mockito.any(byte[].class))).thenAnswer(invocation -> {
            byte[] buffer = invocation.getArgument(0);
            if (buffer.length >= 100) {
                // Simulate reading 100 bytes for the first file
                return 100;
            } else {
                // End of stream
                return -1;
            }
        });
    }

    private JarEntry createJarEntry(String name, long size) {
        JarEntry entry = new JarEntry(name);
        entry.setSize(size);
        return entry;
    }

    @Test
    public void testGetPackingFileListFromJar_withManifest() throws IOException {
        List<PackingFile> packingFiles = PackingUtils.getPackingFileListFromJar(jarInputStream, true);
        assertEquals(3, packingFiles.size());
        assertEquals(JarFile.MANIFEST_NAME, packingFiles.get(0).getName());
    }

    @Test
    public void testGetPackingFileListFromJar_withEntries() throws IOException {
        List<PackingFile> packingFiles = PackingUtils.getPackingFileListFromJar(jarInputStream, true);
        assertEquals(3, packingFiles.size());
        assertEquals("testFile1.txt", packingFiles.get(1).getName());
        assertEquals("testFile2.txt", packingFiles.get(2).getName());
    }

    @Test
    public void testGetPackingFileListFromJar_withoutKeepingFileOrder() throws IOException {
        Mockito.when(jarInputStream.getNextJarEntry()).thenReturn(createJarEntry("testFile2.txt", 200), createJarEntry("testFile1.txt", 100), null);
        List<PackingFile> packingFiles = PackingUtils.getPackingFileListFromJar(jarInputStream, false);
        assertEquals(3, packingFiles.size());
        assertEquals(JarFile.MANIFEST_NAME, packingFiles.get(0).getName());
        assertNotEquals("testFile1.txt", packingFiles.get(1).getName());
        assertNotEquals("testFile2.txt", packingFiles.get(2).getName());
    }

    @Test
    public void testGetPackingFileListFromJar_withEmptyJar() throws IOException {
    }
}
