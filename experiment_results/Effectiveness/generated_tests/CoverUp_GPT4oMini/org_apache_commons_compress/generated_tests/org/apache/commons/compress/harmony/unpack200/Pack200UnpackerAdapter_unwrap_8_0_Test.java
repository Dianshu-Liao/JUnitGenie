package org.apache.commons.compress.harmony.unpack200;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class Pack200UnpackerAdapter_unwrap_8_0_Test {

    @Test
    void testUnwrapWithValidFilterInputStream() throws Exception {
        // Arrange
        InputStream originalInputStream = new ByteArrayInputStream("test data".getBytes());
        FilterInputStream filterInputStream = new FilterInputStream(originalInputStream) {
        };
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        assertNotNull(unwrappedStream);
        int data = unwrappedStream.read();
        assertEquals('t', data);
    }

    @Test
    void testUnwrapWithNullInputStream() throws Exception {
        // Arrange
        FilterInputStream filterInputStream = new FilterInputStream(new ByteArrayInputStream(new byte[0])) {
        };
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        assertNotNull(unwrappedStream);
        int data = unwrappedStream.read();
        // No data should be available
        assertEquals(-1, data);
    }

    @Test
    void testUnwrapWithEmptyStream() throws Exception {
        // Arrange
        InputStream originalInputStream = new ByteArrayInputStream(new byte[0]);
        FilterInputStream filterInputStream = new FilterInputStream(originalInputStream) {
        };
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        assertNotNull(unwrappedStream);
        int data = unwrappedStream.read();
        // No data should be available
        assertEquals(-1, data);
    }

    @Test
    void testUnwrapWithNullFilterInputStream() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            Pack200UnpackerAdapter.unwrap(null);
        });
    }
}
