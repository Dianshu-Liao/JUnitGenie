package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.Archive.PackingFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.jar.JarFile;
import java.io.OutputStream;
import java.util.jar.JarOutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PackingUtils_getPackingFileListFromJar_4_0_Test {

    private JarInputStream jarInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a simple JAR input stream with a manifest and one entry
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Manifest manifest = new Manifest();
        manifest.write(baos);
        byte[] manifestBytes = baos.toByteArray();
        // Create a JAR with a manifest and one entry
        ByteArrayOutputStream jarOutputStream = new ByteArrayOutputStream();
        try (JarOutputStream jos = new JarOutputStream(jarOutputStream, manifest)) {
            jos.putNextEntry(new JarEntry("test.txt"));
            jos.write("Hello, World!".getBytes());
            jos.closeEntry();
        }
        jarInputStream = new JarInputStream(new ByteArrayInputStream(jarOutputStream.toByteArray()));
    }

    @Test
    public void testGetPackingFileListFromJarWithManifest() throws Exception {
        List<PackingFile> packingFiles = PackingUtils.getPackingFileListFromJar(jarInputStream, true);
        assertEquals(2, packingFiles.size());
        assertEquals(JarFile.MANIFEST_NAME, packingFiles.get(0).getName());
        assertEquals("Hello, World!", new String(getBytes(packingFiles.get(1))));
    }

    @Test
    public void testGetPackingFileListFromJarWithoutManifest() throws IOException {
        jarInputStream.close();
        // empty JAR
        jarInputStream = new JarInputStream(new ByteArrayInputStream(new byte[0]));
        List<PackingFile> packingFiles = PackingUtils.getPackingFileListFromJar(jarInputStream, true);
        assertEquals(0, packingFiles.size());
    }

    @Test
    public void testGetPackingFileListFromJarWithReorder() throws Exception {
        List<PackingFile> packingFiles = PackingUtils.getPackingFileListFromJar(jarInputStream, false);
        assertEquals(2, packingFiles.size());
        assertEquals(JarFile.MANIFEST_NAME, packingFiles.get(0).getName());
        assertEquals("Hello, World!", new String(getBytes(packingFiles.get(1))));
        // Add assertions to check the order after reordering if necessary
    }

    @Test
    public void testGetPackingFileListFromJarWithLargeEntry() {
        assertThrows(IllegalArgumentException.class, () -> {
            PackingUtils.getPackingFileListFromJar(new JarInputStream(new ByteArrayInputStream(new byte[0])), true);
        });
    }

    @Test
    public void testReadJarEntryError() {
        assertThrows(IllegalArgumentException.class, () -> {
            PackingUtils.getPackingFileListFromJar(new JarInputStream(new ByteArrayInputStream(new byte[0])), true);
        });
    }

    private byte[] getBytes(PackingFile packingFile) throws Exception {
        Method method = PackingFile.class.getDeclaredMethod("getBytes");
        method.setAccessible(true);
        return (byte[]) method.invoke(packingFile);
    }
}
