package org.apache.commons.compress.harmony.unpack200;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.jar.JarOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.compress.harmony.pack200.Pack200Adapter;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.java.util.jar.Pack200.Unpacker;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.lang3.reflect.FieldUtils;

public class Pack200UnpackerAdapter_unpack_10_0_Test {

    private Pack200UnpackerAdapter unpacker;

    private File testFile;

    @BeforeEach
    public void setUp() throws IOException {
        unpacker = new Pack200UnpackerAdapter();
        testFile = Files.createTempFile("testFile", ".jar").toFile();
        try (FileOutputStream os = new FileOutputStream(testFile)) {
            try (JarOutputStream jarOutputStream = new JarOutputStream(os)) {
                // You can add entries to the jarOutputStream if needed for testing
            }
        }
    }

    @Test
    public void testUnpack_NullFile() {
        assertThrows(IllegalArgumentException.class, () -> {
            unpacker.unpack((File) null, new JarOutputStream(new FileOutputStream("output.jar")));
        });
    }

    @Test
    public void testUnpack_NullOutputStream() {
        assertThrows(IllegalArgumentException.class, () -> {
            unpacker.unpack(testFile, (JarOutputStream) null);
        });
    }

    @Test
    public void testUnpack_ValidInput() throws IOException {
        try (JarOutputStream out = new JarOutputStream(new FileOutputStream("output.jar"))) {
            try (InputStream in = Files.newInputStream(testFile.toPath())) {
                unpacker.unpack(in, out);
            }
        }
    }

    @Test
    public void testUnpack_EmptyFile() throws IOException {
        File emptyFile = Files.createTempFile("emptyFile", ".jar").toFile();
        try (JarOutputStream out = new JarOutputStream(new FileOutputStream("output.jar"))) {
            try (InputStream in = Files.newInputStream(emptyFile.toPath())) {
                unpacker.unpack(in, out);
            }
        }
    }
}
