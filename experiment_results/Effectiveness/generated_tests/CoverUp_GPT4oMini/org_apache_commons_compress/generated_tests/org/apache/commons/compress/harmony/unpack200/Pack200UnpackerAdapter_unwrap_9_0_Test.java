package org.apache.commons.compress.harmony.unpack200;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
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

class Pack200UnpackerAdapter_unwrap_9_0_Test {

    @Test
    void testUnwrapWithNormalInputStream() {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        InputStream result = Pack200UnpackerAdapter.unwrap(inputStream);
        assertSame(inputStream, result, "Should return the same InputStream when not a FilterInputStream");
    }

    @Test
    void testUnwrapWithFilterInputStream() throws Exception {
        InputStream originalStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        FilterInputStream filterInputStream = new FilterInputStream(originalStream) {
        };
        InputStream result = Pack200UnpackerAdapter.unwrap(filterInputStream);
        InputStream unwrappedStream = readField(filterInputStream, "in");
        assertSame(unwrappedStream, result, "Should return the unwrapped InputStream from FilterInputStream");
    }

    @Test
    void testUnwrapWithNullInputStream() {
        assertThrows(NullPointerException.class, () -> {
            Pack200UnpackerAdapter.unwrap(null);
        }, "Should throw NullPointerException when InputStream is null");
    }

    private InputStream readField(FilterInputStream filterInputStream, String fieldName) throws Exception {
        Field field = FilterInputStream.class.getDeclaredField("in");
        field.setAccessible(true);
        return (InputStream) field.get(filterInputStream);
    }
}
