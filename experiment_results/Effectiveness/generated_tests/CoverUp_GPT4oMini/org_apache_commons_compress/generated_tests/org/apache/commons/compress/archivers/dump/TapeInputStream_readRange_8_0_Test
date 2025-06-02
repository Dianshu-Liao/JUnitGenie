package org.apache.commons.compress.archivers.dump;

import org.apache.commons.compress.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.utils.ExactMath;

class TapeInputStream_readRange_8_0_Test {

    private TapeInputStream tapeInputStream;

    @BeforeEach
    void setUp() {
        // Initialize with a sample input stream
        byte[] sampleData = new byte[DumpArchiveConstants.TP_SIZE];
        // Fill with sample data (e.g., all bytes set to 1)
        Arrays.fill(sampleData, (byte) 1);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sampleData);
        tapeInputStream = new TapeInputStream(inputStream);
    }

    @Test
    void testReadRange_ValidLength() throws Exception {
        // Invoke the private method readRange using reflection
        byte[] result = invokeReadRange(DumpArchiveConstants.TP_SIZE);
        assertNotNull(result);
        assertEquals(DumpArchiveConstants.TP_SIZE, result.length);
        // Check that the bytes are as expected
        assertTrue(Arrays.equals(new byte[DumpArchiveConstants.TP_SIZE], result));
    }

    @Test
    void testReadRange_ShortFileException() {
        // Create a stream with less data than requested
        byte[] sampleData = new byte[512];
        Arrays.fill(sampleData, (byte) 1);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sampleData);
        tapeInputStream = new TapeInputStream(inputStream);
        assertThrows(ShortFileException.class, () -> {
            // Attempt to read more than available
            invokeReadRange(DumpArchiveConstants.TP_SIZE);
        });
    }

    private byte[] invokeReadRange(int length) throws Exception {
        java.lang.reflect.Method method = TapeInputStream.class.getDeclaredMethod("readRange", int.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(tapeInputStream, length);
    }
}
