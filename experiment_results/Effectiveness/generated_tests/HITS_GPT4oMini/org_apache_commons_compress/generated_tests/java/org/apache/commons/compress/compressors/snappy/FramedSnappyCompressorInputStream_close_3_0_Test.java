package org.apache.commons.compress.compressors.snappy;

import org.apache.commons.compress.compressors.CompressorInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.PushbackInputStream;
import org.apache.commons.codec.digest.PureJavaCrc32C;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.compress.utils.IOUtils;

public class FramedSnappyCompressorInputStream_close_3_0_Test {

    private FramedSnappyCompressorInputStream framedSnappyCompressorInputStream;

    private SnappyCompressorInputStream mockCompressedChunk;

    private InputStream inputStream;

    @BeforeEach
    public void setUp() throws IOException {
        inputStream = new ByteArrayInputStream(new byte[0]);
        framedSnappyCompressorInputStream = new FramedSnappyCompressorInputStream(inputStream);
        mockCompressedChunk = mock(SnappyCompressorInputStream.class);
        setPrivateField("currentCompressedChunk", mockCompressedChunk);
    }

    private void setPrivateField(String fieldName, Object value) {
        try {
            Field field = FramedSnappyCompressorInputStream.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(framedSnappyCompressorInputStream, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }

    @Test
    public void testClose_whenCurrentCompressedChunkIsNotNull_shouldCloseCurrentCompressedChunk() throws IOException {
        framedSnappyCompressorInputStream.close();
        verify(mockCompressedChunk, times(1)).close();
    }

    @Test
    public void testClose_whenCurrentCompressedChunkIsNull_shouldNotThrowException() throws IOException {
        setPrivateField("currentCompressedChunk", null);
        framedSnappyCompressorInputStream.close();
        // No exception should be thrown
    }

    @Test
    public void testClose_shouldCloseInputStream() throws IOException {
        framedSnappyCompressorInputStream.close();
        // Verify that the inputStream is closed
        assertTrue(inputStream.available() == 0);
    }
}
