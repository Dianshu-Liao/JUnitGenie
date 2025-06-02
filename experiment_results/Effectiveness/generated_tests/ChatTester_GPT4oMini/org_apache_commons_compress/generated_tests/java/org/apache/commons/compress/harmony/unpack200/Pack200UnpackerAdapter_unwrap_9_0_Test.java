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

// Focal class
public class Pack200UnpackerAdapter_unwrap_9_0_Test {

    // Focal method
    static InputStream unwrap(final InputStream inputStream) {
        return inputStream instanceof FilterInputStream ? unwrap((FilterInputStream) inputStream) : inputStream;
    }

    // Overloaded unwrap method for FilterInputStream
    static InputStream unwrap(final FilterInputStream filterInputStream) {
        // Assume some logic here that processes the FilterInputStream
        // Placeholder return
        return filterInputStream;
    }
}

// Test class
class Pack200UnpackerAdapterTest {

    @Test
    void testUnwrapWithNonFilterInputStream() {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        InputStream result = Pack200UnpackerAdapter.unwrap(inputStream);
        assertSame(inputStream, result, "Expected the same InputStream returned.");
    }

    @Test
    void testUnwrapWithFilterInputStream() {
        FilterInputStream filterInputStream = new FilterInputStream(new ByteArrayInputStream(new byte[] {})) {
        };
        InputStream result = Pack200UnpackerAdapter.unwrap(filterInputStream);
        assertSame(filterInputStream, result, "Expected the same FilterInputStream returned.");
    }
}
