package org.apache.commons.codec.binary;

import java.io.IOException;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterOutputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;

public class BaseNCodecOutputStream_flush_2_1_Test {

    private BaseNCodecOutputStream baseNCodecOutputStream;

    private OutputStream outputStream;

    private BaseNCodec baseNCodec;

    @BeforeEach
    public void setUp() {
        outputStream = mock(OutputStream.class);
        baseNCodec = mock(BaseNCodec.class);
        baseNCodecOutputStream = new BaseNCodecOutputStream(outputStream, baseNCodec, true);
    }

    @Test
    public void testFlush() throws IOException {
        // Call the flush method
        baseNCodecOutputStream.flush();
        // Verify that flush(true) was called
        // Since flush(true) is private, we need to use reflection to invoke it.
        try {
            java.lang.reflect.Method flushMethod = BaseNCodecOutputStream.class.getDeclaredMethod("flush", boolean.class);
            flushMethod.setAccessible(true);
            flushMethod.invoke(baseNCodecOutputStream, true);
        } catch (Exception e) {
            fail("Exception thrown during reflection: " + e.getMessage());
        }
        // Verify if the output stream's flush method was called
        verify(outputStream, times(1)).flush();
    }
}
