package org.apache.commons.compress.harmony.unpack200;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.jar.JarOutputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import org.apache.commons.compress.harmony.pack200.Pack200Adapter;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.java.util.jar.Pack200.Unpacker;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.lang3.reflect.FieldUtils;

class Pack200UnpackerAdapter_unpack_10_2_Test {

    private Pack200UnpackerAdapter unpacker;

    private File tempFile;

    private JarOutputStream jarOutputStream;

    @BeforeEach
    void setUp() throws IOException {
        unpacker = new Pack200UnpackerAdapter();
        tempFile = Files.createTempFile("test", ".pack").toFile();
        try (OutputStream os = new FileOutputStream(tempFile)) {
            // Simulating a pack file
            os.write(new byte[] { 1, 2, 3, 4 });
        }
        jarOutputStream = new JarOutputStream(new FileOutputStream("test.jar"));
    }

    @Test
    void testUnpack_NullFile_ThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeUnpackMethod(null, jarOutputStream);
        });
        assertEquals("Must specify input file.", exception.getMessage());
    }

    @Test
    void testUnpack_NullOutputStream_ThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeUnpackMethod(tempFile, null);
        });
        assertEquals("Must specify output stream.", exception.getMessage());
    }

    @Test
    void testUnpack_ValidFileAndOutputStream_Success() throws IOException {
        assertDoesNotThrow(() -> {
            invokeUnpackMethod(tempFile, jarOutputStream);
        });
    }

    @Test
    void testUnpack_EmptyFile_Success() throws IOException {
        File emptyFile = Files.createTempFile("empty", ".pack").toFile();
        assertDoesNotThrow(() -> {
            invokeUnpackMethod(emptyFile, jarOutputStream);
        });
    }

    @Test
    void testUnpack_FileDoesNotExist_ThrowsIOException() {
        File nonExistentFile = new File("non_existent.pack");
        IOException exception = assertThrows(IOException.class, () -> {
            invokeUnpackMethod(nonExistentFile, jarOutputStream);
        });
        assertTrue(exception.getMessage().contains("No such file or directory"));
    }

    @Test
    void testUnpack_FileWithSizeLessThanDefaultBufferSize_Success() throws IOException {
        File smallFile = Files.createTempFile("small", ".pack").toFile();
        try (OutputStream os = new FileOutputStream(smallFile)) {
            // Simulating a small pack file
            os.write(new byte[] { 1 });
        }
        assertDoesNotThrow(() -> {
            invokeUnpackMethod(smallFile, jarOutputStream);
        });
    }

    @Test
    void testUnpack_FileWithSizeGreaterThanDefaultBufferSize_Success() throws IOException {
        File largeFile = Files.createTempFile("large", ".pack").toFile();
        try (OutputStream os = new FileOutputStream(largeFile)) {
            // Simulating a large pack file
            os.write(new byte[1024 * 1024]);
        }
        assertDoesNotThrow(() -> {
            invokeUnpackMethod(largeFile, jarOutputStream);
        });
    }

    private void invokeUnpackMethod(File file, JarOutputStream out) throws Exception {
        Method method = Pack200UnpackerAdapter.class.getDeclaredMethod("unpack", File.class, JarOutputStream.class);
        method.setAccessible(true);
        method.invoke(unpacker, file, out);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (tempFile != null) {
            Files.deleteIfExists(tempFile.toPath());
        }
        if (jarOutputStream != null) {
            jarOutputStream.close();
        }
        Files.deleteIfExists(Paths.get("test.jar"));
    }
}
