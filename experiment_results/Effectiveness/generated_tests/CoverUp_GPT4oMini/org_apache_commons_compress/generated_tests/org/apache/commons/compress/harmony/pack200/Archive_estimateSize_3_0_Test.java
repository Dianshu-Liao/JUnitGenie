package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.Archive;
import org.apache.commons.compress.harmony.pack200.PackingOptions;
import org.apache.commons.compress.harmony.pack200.Archive.PackingFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.jar.JarFile;
import java.lang.reflect.Constructor;
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
import java.util.jar.JarInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;

public class Archive_estimateSize_3_0_Test {

    private Archive archive;

    private PackingOptions options;

    @BeforeEach
    public void setUp() throws IOException {
        options = new PackingOptions();
        // Assuming a JarFile is created for the purpose of testing
        JarFile jarFile = new JarFile("test.jar");
        OutputStream outputStream = new ByteArrayOutputStream();
        archive = new Archive(jarFile, outputStream, options);
    }

    @Test
    public void testEstimateSize_EmptyPackingFile() throws Exception {
        PackingFile packingFile = createPackingFile("META-INF/manifest.mf", new byte[0]);
        long size = invokeEstimateSize(packingFile);
        assertEquals(0, size);
    }

    @Test
    public void testEstimateSize_NegativeFileSize() throws Exception {
        PackingFile packingFile = createPackingFile("test.txt", new byte[-10]);
        long size = invokeEstimateSize(packingFile);
        assertEquals(14, size);
    }

    @Test
    public void testEstimateSize_ValidPackingFile() throws Exception {
        PackingFile packingFile = createPackingFile("test.txt", new byte[10]);
        long size = invokeEstimateSize(packingFile);
        assertEquals(19, size);
    }

    private long invokeEstimateSize(PackingFile packingFile) throws Exception {
        Method method = Archive.class.getDeclaredMethod("estimateSize", PackingFile.class);
        method.setAccessible(true);
        return (long) method.invoke(archive, packingFile);
    }

    private PackingFile createPackingFile(String name, byte[] contents) throws Exception {
        Constructor<PackingFile> constructor = PackingFile.class.getDeclaredConstructor(String.class, byte[].class, long.class);
        constructor.setAccessible(true);
        return constructor.newInstance(name, contents, contents.length);
    }
}
