package org.apache.commons.compress.compressors.lz4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.zip.CheckedInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

class FramedLZ4CompressorInputStream_close_3_0_Test {

    private FramedLZ4CompressorInputStream lz4CompressorInputStream;

    private InputStream mockInputStream;

    @BeforeEach
    void setUp() throws IOException {
        // Example LZ4 signature
        byte[] mockData = new byte[] { 0x4, 0x22, 0x4d, 0x18 };
        mockInputStream = new ByteArrayInputStream(mockData);
        lz4CompressorInputStream = new FramedLZ4CompressorInputStream(mockInputStream);
    }

    @Test
    void testClose() throws Exception {
        // Close the stream normally
        lz4CompressorInputStream.close();
        // Verify that the currentBlock is set to null
        Field currentBlockField = FramedLZ4CompressorInputStream.class.getDeclaredField("currentBlock");
        currentBlockField.setAccessible(true);
        assertNull(currentBlockField.get(lz4CompressorInputStream));
    }

    @Test
    void testCloseWithIOException() throws Exception {
        // Create a mock InputStream that throws IOException on close
        InputStream faultyInputStream = Mockito.mock(InputStream.class);
        Mockito.when(faultyInputStream.read()).thenReturn(-1);
        Mockito.doThrow(new IOException("Forced IOException on close")).when(faultyInputStream).close();
        lz4CompressorInputStream = new FramedLZ4CompressorInputStream(faultyInputStream);
        // Expect the IOException to be thrown when close is called
        assertThrows(IOException.class, lz4CompressorInputStream::close);
    }
}
