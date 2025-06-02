package org.apache.commons.compress.harmony.unpack200;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.java.util.jar.Pack200.Unpacker;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.lang3.reflect.FieldUtils;

public class Pack200UnpackerAdapter_unpack_11_1_Test {

    private final Pack200UnpackerAdapter unpacker = new Pack200UnpackerAdapter();

    @Test
    public void testUnpack_NullInputStream_ThrowsIllegalArgumentException() {
        // Arrange
        InputStream in = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            unpacker.unpack(in, new JarOutputStream(outputStream));
        }, "Must specify input stream.");
    }

    @Test
    public void testUnpack_NullOutputStream_ThrowsIllegalArgumentException() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        JarOutputStream out = null;
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            unpacker.unpack(inputStream, out);
        }, "Must specify output stream.");
    }

    @Test
    public void testUnpack_ValidStreams_DoesNotThrowException() throws IOException {
        // Arrange
        // A dummy input stream
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JarOutputStream jarOutputStream = new JarOutputStream(outputStream);
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> {
            unpacker.unpack(inputStream, jarOutputStream);
        });
    }
}
