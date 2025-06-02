package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.commons.compress.harmony.pack200.Archive.PackingFile;

public class PackingUtils_getPackingFileListFromJar_4_1_Test {

    @Test
    public void testGetPackingFileListFromJar_withManifest() throws IOException {
        // Prepare a JarInputStream with a manifest and a sample file
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (JarOutputStream jos = new JarOutputStream(baos)) {
            // Add a manifest
            jos.putNextEntry(new JarEntry(JarFile.MANIFEST_NAME));
            jos.write("Manifest-Version: 1.0\n".getBytes());
            jos.closeEntry();
            // Add a sample file
            jos.putNextEntry(new JarEntry("sample.txt"));
            jos.write("Sample content".getBytes());
            jos.closeEntry();
        }
        try (JarInputStream jarInputStream = new JarInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            List<PackingFile> packingFiles = PackingUtils.getPackingFileListFromJar(jarInputStream, false);
            assertNotNull(packingFiles);
            assertEquals(2, packingFiles.size());
            assertEquals(JarFile.MANIFEST_NAME, packingFiles.get(0).getName());
            assertEquals("sample.txt", packingFiles.get(1).getName());
        }
    }

    @Test
    public void testGetPackingFileListFromJar_withoutManifest() throws IOException {
        // Prepare a JarInputStream without a manifest
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (JarOutputStream jos = new JarOutputStream(baos)) {
            // Add a sample file
            jos.putNextEntry(new JarEntry("sample.txt"));
            jos.write("Sample content".getBytes());
            jos.closeEntry();
        }
        try (JarInputStream jarInputStream = new JarInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            List<PackingFile> packingFiles = PackingUtils.getPackingFileListFromJar(jarInputStream, false);
            assertNotNull(packingFiles);
            assertEquals(1, packingFiles.size());
            assertEquals("sample.txt", packingFiles.get(0).getName());
        }
    }
}
