package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.jar.JarOutputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.compress.harmony.pack200.Pack200Adapter;
import org.apache.commons.compress.java.util.jar.Pack200.Unpacker;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Pack200UnpackerAdapter_unpack_11_0_Test {

    private Pack200UnpackerAdapter pack200UnpackerAdapter;

    @BeforeEach
    void setUp() {
        pack200UnpackerAdapter = new Pack200UnpackerAdapter();
    }

    @Test
    void testUnpack_NullInputStream() {
        assertThrows(IllegalArgumentException.class, () -> {
            pack200UnpackerAdapter.unpack((InputStream) null, new JarOutputStream(new ByteArrayOutputStream()));
        });
    }

    @Test
    void testUnpack_NullOutputStream() {
        assertThrows(IllegalArgumentException.class, () -> {
            pack200UnpackerAdapter.unpack(new ByteArrayInputStream(new byte[0]), (JarOutputStream) null);
        });
    }

    @Test
    void testUnpack_ValidInput() throws IOException {
        byte[] validPack200Data = new byte[] { (byte) 0xCA, (byte) 0xFE, (byte) 0xD0, (byte) 0x0D };
        InputStream inputStream = new ByteArrayInputStream(validPack200Data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JarOutputStream jarOutputStream = new JarOutputStream(outputStream);
        assertDoesNotThrow(() -> {
            pack200UnpackerAdapter.unpack(inputStream, jarOutputStream);
        });
        assertTrue(outputStream.size() > 0);
    }

    @Test
    void testUnpack_Pack200Exception() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 0, 1, 2 });
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JarOutputStream jarOutputStream = new JarOutputStream(outputStream);
        assertThrows(IOException.class, () -> {
            pack200UnpackerAdapter.unpack(inputStream, jarOutputStream);
        });
    }

    private void invokeCompleted(double value) throws Exception {
        Method method = Pack200UnpackerAdapter.class.getDeclaredMethod("completed", double.class);
        method.setAccessible(true);
        method.invoke(pack200UnpackerAdapter, value);
    }

    @Test
    void testCompleted() throws Exception {
        assertDoesNotThrow(() -> invokeCompleted(1.0));
    }
}
