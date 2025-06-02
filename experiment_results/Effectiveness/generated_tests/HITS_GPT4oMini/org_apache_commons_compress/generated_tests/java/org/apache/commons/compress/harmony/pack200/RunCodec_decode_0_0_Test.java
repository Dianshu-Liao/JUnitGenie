package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.utils.ExactMath;

public class RunCodec_decode_0_0_Test {

    private Codec mockACodec;

    private Codec mockBCodec;

    private RunCodec runCodec;

    @BeforeEach
    public void setUp() throws Pack200Exception {
        mockACodec = mock(Codec.class);
        mockBCodec = mock(Codec.class);
        runCodec = new RunCodec(5, mockACodec, mockBCodec);
    }

    @Test
    public void testDecodeWithACodec() throws IOException, Pack200Exception {
        InputStream input = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        // assuming last is initially 0
        when(mockACodec.decode(input, 0)).thenReturn(10);
        int result = runCodec.decode(input);
        assertEquals(10, result);
        verify(mockACodec, times(1)).decode(input, 0);
        // Since we cannot access last directly, we assume it will be set to 10 if k is not zero
    }

    @Test
    public void testDecodeWithBCodec() throws IOException, Pack200Exception {
        runCodec = new RunCodec(0, mockACodec, mockBCodec);
        InputStream input = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        // assuming last was set to 10
        when(mockBCodec.decode(input, 10)).thenReturn(20);
        int result = runCodec.decode(input);
        assertEquals(20, result);
        verify(mockBCodec, times(1)).decode(input, 10);
    }

    @Test
    public void testDecodeWithNegativeK() {
        Exception exception = assertThrows(Pack200Exception.class, () -> {
            new RunCodec(-1, mockACodec, mockBCodec);
        });
        assertEquals("Cannot have a RunCodec for a negative number of numbers", exception.getMessage());
    }

    @Test
    public void testDecodeWithNullCodecs() {
        Exception exception = assertThrows(Pack200Exception.class, () -> {
            new RunCodec(5, null, mockBCodec);
        });
        assertEquals("Must supply both codecs for a RunCodec", exception.getMessage());
        exception = assertThrows(Pack200Exception.class, () -> {
            new RunCodec(5, mockACodec, null);
        });
        assertEquals("Must supply both codecs for a RunCodec", exception.getMessage());
    }
}
