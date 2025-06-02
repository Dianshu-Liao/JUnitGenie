package org.apache.commons.compress.harmony.unpack200;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

public class Pack200UnpackerAdapter_unwrap_8_0_Test {

    @Test
    public void testUnwrapWithValidFilterInputStream() throws Exception {
        // Arrange
        InputStream originalStream = new ByteArrayInputStream("test data".getBytes());
        FilterInputStream filterInputStream = new FilterInputStream(originalStream) {
        };
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        assertEquals(originalStream, unwrappedStream);
    }

    @Test
    public void testUnwrapWithNullInputStream() throws Exception {
        // Arrange
        FilterInputStream filterInputStream = mock(FilterInputStream.class);
        when(filterInputStream.read()).thenThrow(new IOException("Simulated IOException"));
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        assertNull(unwrappedStream);
    }

    @Test
    public void testUnwrapWithCustomFilterInputStream() throws Exception {
        // Arrange
        InputStream originalStream = new ByteArrayInputStream("custom data".getBytes());
        FilterInputStream filterInputStream = new FilterInputStream(originalStream) {
        };
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        assertEquals(originalStream, unwrappedStream);
    }

    @Test
    public void testUnwrapWithNonFilterInputStream() throws Exception {
        // Arrange
        InputStream nonFilterStream = new ByteArrayInputStream("data".getBytes());
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap((FilterInputStream) nonFilterStream);
        // Assert
        // Expecting null since it's not a FilterInputStream
        assertNull(unwrappedStream);
    }

    @Test
    public void testUnwrapWithInvalidFilterInputStream() {
        // Arrange
        FilterInputStream filterInputStream = new FilterInputStream(new ByteArrayInputStream(new byte[0])) {

            @Override
            public int read() {
                // Simulate end of stream
                return -1;
            }
        };
        // Act
        InputStream unwrappedStream = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Assert
        // Should return the underlying stream
        assertNotNull(unwrappedStream);
    }
}
