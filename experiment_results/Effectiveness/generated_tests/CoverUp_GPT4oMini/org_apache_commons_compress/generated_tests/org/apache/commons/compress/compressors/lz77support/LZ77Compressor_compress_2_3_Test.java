package org.apache.commons.compress.compressors.lz77support;

import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import java.io.IOException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import org.apache.commons.lang3.ArrayFill;

@ExtendWith(MockitoExtension.class)
class LZ77Compressor_compress_2_3_Test {

    private LZ77Compressor compressor;

    private Parameters parameters;

    private LZ77Compressor.Callback callback;

    @BeforeEach
    void setUp() {
        // Mocking Parameters since it has private constructor
        parameters = mock(Parameters.class);
        callback = mock(LZ77Compressor.Callback.class);
        compressor = new LZ77Compressor(parameters, callback);
    }

    @Test
    void testCompress_withValidData() throws IOException {
        byte[] data = "Hello, LZ77 Compression!".getBytes();
        assertDoesNotThrow(() -> compressor.compress(data));
    }

    @Test
    void testCompress_withEmptyData() throws IOException {
        byte[] data = new byte[0];
        assertDoesNotThrow(() -> compressor.compress(data));
    }

    @Test
    void testCompress_withLargeData() throws IOException {
        // Larger than window size
        byte[] data = new byte[2048];
        assertDoesNotThrow(() -> compressor.compress(data));
    }

    @Test
    void testCompress_withNullData() {
        assertThrows(NullPointerException.class, () -> compressor.compress(null));
    }

    @Test
    void testCompress_withPartialData() throws IOException {
        byte[] data = "Partial Data".getBytes();
        assertDoesNotThrow(() -> compressor.compress(data));
    }

    // Reflection test for private method if exists
    @Test
    void testDoCompress() throws Exception {
        Method doCompressMethod = LZ77Compressor.class.getDeclaredMethod("doCompress", byte[].class, int.class, int.class);
        doCompressMethod.setAccessible(true);
        byte[] data = "Test Data".getBytes();
        int offset = 0;
        int length = data.length;
        assertDoesNotThrow(() -> doCompressMethod.invoke(compressor, data, offset, length));
    }
}
