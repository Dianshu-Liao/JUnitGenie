package org.apache.commons.compress.archivers.dump;

import org.apache.commons.compress.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.utils.ExactMath;

class TapeInputStream_readRange_8_0_Test {

    private TapeInputStream tapeInputStream;

    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setUp() {
        byte[] data = new byte[DumpArchiveConstants.TP_SIZE];
        Arrays.fill(data, (byte) 1);
        inputStream = new ByteArrayInputStream(data);
        tapeInputStream = new TapeInputStream(inputStream);
    }

    private byte[] invokeReadRange(int length) throws Exception {
        Method method = TapeInputStream.class.getDeclaredMethod("readRange", int.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(tapeInputStream, length);
    }

    @Test
    void testReadRange_Success() throws Exception {
        byte[] expected = new byte[100];
        Arrays.fill(expected, (byte) 1);
        byte[] result = invokeReadRange(100);
        assertArrayEquals(expected, result);
    }

    @Test
    void testReadRange_ShortFileException() {
        assertThrows(ShortFileException.class, () -> {
            invokeReadRange(DumpArchiveConstants.TP_SIZE + 1);
        });
    }

    @Test
    void testReadRange_ZeroLength() throws Exception {
        byte[] result = invokeReadRange(0);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testReadRange_NegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            invokeReadRange(-1);
        });
    }
}
