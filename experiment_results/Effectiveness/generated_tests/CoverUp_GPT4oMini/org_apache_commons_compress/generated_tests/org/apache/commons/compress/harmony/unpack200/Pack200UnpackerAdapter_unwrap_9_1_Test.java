package org.apache.commons.compress.harmony.unpack200;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.apache.commons.compress.harmony.unpack200.Pack200UnpackerAdapter;
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

class Pack200UnpackerAdapter_unwrap_9_1_Test {

    private Pack200UnpackerAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new Pack200UnpackerAdapter();
    }

    @Test
    void testUnwrap_WithNonFilterInputStream() {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        InputStream result = Pack200UnpackerAdapter.unwrap(inputStream);
        assertSame(inputStream, result, "The result should be the same instance as the input stream.");
    }

    @Test
    void testUnwrap_WithFilterInputStream() throws Exception {
        // Create a mock FilterInputStream
        InputStream mockInputStream = new FilterInputStream(new ByteArrayInputStream(new byte[] { 1, 2, 3 })) {
        };
        // Use reflection to invoke the private unwrap method
        Method unwrapMethod = Pack200UnpackerAdapter.class.getDeclaredMethod("unwrap", FilterInputStream.class);
        unwrapMethod.setAccessible(true);
        InputStream result = (InputStream) unwrapMethod.invoke(adapter, mockInputStream);
        // Use reflection to access the private field "in" of FilterInputStream
        InputStream innerStream = (InputStream) FieldUtils.readField(mockInputStream, "in", true);
        assertNotNull(result, "The result should not be null.");
        assertSame(innerStream, result, "The result should be the inner InputStream of the FilterInputStream.");
    }
}
