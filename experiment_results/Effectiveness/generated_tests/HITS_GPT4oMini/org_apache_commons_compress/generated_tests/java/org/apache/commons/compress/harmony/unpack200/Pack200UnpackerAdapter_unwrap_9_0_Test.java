package org.apache.commons.compress.harmony.unpack200;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
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

public class Pack200UnpackerAdapter_unwrap_9_0_Test {

    @Test
    public void testUnwrap_WithNonFilterInputStream_ShouldReturnSameStream() {
        // Given
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        // When
        InputStream result = Pack200UnpackerAdapter.unwrap(inputStream);
        // Then
        assertSame(inputStream, result);
    }

    @Test
    public void testUnwrap_WithFilterInputStream_ShouldReturnInnerStream() throws IOException {
        // Given
        InputStream innerStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        FilterInputStream filterInputStream = new FilterInputStream(innerStream) {
        };
        // When
        InputStream result = Pack200UnpackerAdapter.unwrap(filterInputStream);
        // Then
        assertSame(innerStream, result);
    }

    @Test
    public void testUnwrap_WithNullInputStream_ShouldThrowNullPointerException() {
        // Given
        InputStream inputStream = null;
        // When & Then
        assertThrows(NullPointerException.class, () -> {
            Pack200UnpackerAdapter.unwrap(inputStream);
        });
    }
}
