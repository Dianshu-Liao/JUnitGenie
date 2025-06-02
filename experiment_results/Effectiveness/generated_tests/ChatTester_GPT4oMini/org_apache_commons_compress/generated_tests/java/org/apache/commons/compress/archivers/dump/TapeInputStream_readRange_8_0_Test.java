package org.apache.commons.compress.archivers.dump;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.FilterInputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.IOUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TapeInputStream_readRange_8_0_Test {

    private InputStream mockInputStream;

    private TapeInputStream tapeInputStream;

    @BeforeEach
    void setUp() {
        mockInputStream = new ByteArrayInputStream(new byte[DumpArchiveConstants.TP_SIZE]);
        tapeInputStream = new TapeInputStream(mockInputStream);
    }

    @Test
    void testReadRangeSuccessful() throws Exception {
        byte[] result = invokeReadRange(tapeInputStream, DumpArchiveConstants.TP_SIZE);
        assertNotNull(result);
        assertEquals(DumpArchiveConstants.TP_SIZE, result.length);
    }

    @Test
    void testReadRangeThrowsShortFileException() {
        // Create an InputStream that has fewer bytes than requested
        InputStream shortInputStream = new ByteArrayInputStream(new byte[DumpArchiveConstants.TP_SIZE - 1]);
        tapeInputStream = new TapeInputStream(shortInputStream);
        assertThrows(ShortFileException.class, () -> {
            invokeReadRange(tapeInputStream, DumpArchiveConstants.TP_SIZE);
        });
    }

    private byte[] invokeReadRange(TapeInputStream tapeInputStream, int len) throws Exception {
        // Fixed the buggy line by replacing 'var' with 'java.lang.reflect.Method'
        java.lang.reflect.Method method = TapeInputStream.class.getDeclaredMethod("readRange", int.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(tapeInputStream, len);
    }
}
