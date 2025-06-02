package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.unpack200.Pack200UnpackerAdapter;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarOutputStream;
import org.apache.commons.compress.harmony.pack200.Pack200Adapter;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.java.util.jar.Pack200.Unpacker;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Pack200UnpackerAdapter_unwrap_8_2_Test {

    @Test
    void testUnwrapWithCloseShieldInputStream() throws IOException {
        // Arrange
        InputStream originalInputStream = new ByteArrayInputStream("Test data".getBytes());
        FilterInputStream filterInputStream = new CloseShieldInputStream(originalInputStream);
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        assertNotNull(unwrappedStream);
        byte[] buffer = new byte[10];
        int bytesRead = unwrappedStream.read(buffer);
        assertEquals("Test data", new String(buffer, 0, bytesRead));
    }

    @Test
    void testUnwrapWithBoundedInputStream() throws IOException {
        // Arrange
        InputStream originalInputStream = new ByteArrayInputStream("Bounded data".getBytes());
        FilterInputStream filterInputStream = new BoundedInputStream(originalInputStream, 12);
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        assertNotNull(unwrappedStream);
        byte[] buffer = new byte[12];
        int bytesRead = unwrappedStream.read(buffer);
        assertEquals("Bounded data", new String(buffer, 0, bytesRead));
    }

    @Test
    void testUnwrapWithSequenceInputStream() throws IOException {
        // Arrange
        InputStream firstStream = new ByteArrayInputStream("First part ".getBytes());
        InputStream secondStream = new ByteArrayInputStream("Second part".getBytes());
        InputStream filterInputStream = new SequenceInputStream(firstStream, secondStream);
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(new CloseShieldInputStream(filterInputStream));
        // Assert
        assertNotNull(unwrappedStream);
        byte[] buffer = new byte[25];
        int bytesRead = unwrappedStream.read(buffer);
        assertEquals("First part Second part", new String(buffer, 0, bytesRead).trim());
    }
}
