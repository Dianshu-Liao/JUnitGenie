package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.io.input.BoundedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.io.BufferedInputStream;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.lang3.reflect.FieldUtils;

public class Pack200UnpackerAdapter_unwrap_8_1_Test {

    @Test
    public void testUnwrapWithBoundedInputStream() throws Exception {
        // Arrange
        byte[] data = "test data".getBytes();
        InputStream byteArrayInputStream = new ByteArrayInputStream(data);
        FilterInputStream boundedInputStream = new BoundedInputStream(byteArrayInputStream, data.length);
        // Act
        InputStream result = Pack200UnpackerAdapter.unwrap(boundedInputStream);
        // Assert
        assertEquals(byteArrayInputStream, result);
    }

    @Test
    public void testUnwrapWithCloseShieldInputStream() throws Exception {
        // Arrange
        byte[] data = "test data".getBytes();
        InputStream byteArrayInputStream = new ByteArrayInputStream(data);
        FilterInputStream closeShieldInputStream = new CloseShieldInputStream(byteArrayInputStream);
        // Act
        InputStream result = Pack200UnpackerAdapter.unwrap(closeShieldInputStream);
        // Assert
        assertEquals(byteArrayInputStream, result);
    }

    @Test
    public void testUnwrapWithNullInputStream() throws Exception {
        // Arrange
        FilterInputStream nullInputStream = null;
        // Act
        InputStream result = Pack200UnpackerAdapter.unwrap(nullInputStream);
        // Assert
        assertNull(result);
    }

    @Test
    public void testUnwrapWithInvalidField() throws Exception {
        // Arrange
        FilterInputStream invalidInputStream = new FilterInputStream(new ByteArrayInputStream(new byte[0])) {
        };
        // Act
        InputStream result = Pack200UnpackerAdapter.unwrap(invalidInputStream);
        // Assert
        assertNull(result);
    }

    @Test
    public void testUnwrapWithBufferedInputStream() throws Exception {
        // Arrange
        byte[] data = "test data".getBytes();
        InputStream byteArrayInputStream = new ByteArrayInputStream(data);
        FilterInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        // Act
        InputStream result = Pack200UnpackerAdapter.unwrap(bufferedInputStream);
        // Assert
        assertEquals(byteArrayInputStream, result);
    }

    private InputStream readField(FilterInputStream filterInputStream, String fieldName) throws Exception {
        Field field = FilterInputStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (InputStream) field.get(filterInputStream);
    }
}
