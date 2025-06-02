package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.pack200.RunCodec;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.apache.commons.compress.utils.ExactMath;

class RunCodec_decode_0_1_Test {

    private Codec aCodecMock;

    private Codec bCodecMock;

    private RunCodec runCodec;

    @BeforeEach
    void setUp() throws Pack200Exception {
        aCodecMock = mock(Codec.class);
        bCodecMock = mock(Codec.class);
        runCodec = new RunCodec(5, aCodecMock, bCodecMock);
    }

    @Test
    void testDecodeWithACodec() throws IOException, Pack200Exception {
        InputStream in = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        when(aCodecMock.decode(in, 0)).thenReturn(10);
        int result = runCodec.decode(in);
        assertEquals(10, result);
        assertEquals(getLastField(runCodec), 10);
    }

    @Test
    void testDecodeWithBCodec() throws IOException, Pack200Exception {
        InputStream in = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        when(aCodecMock.decode(in, 0)).thenReturn(10);
        when(bCodecMock.decode(in, 10)).thenReturn(20);
        // Simulating k reaching 0
        runCodec.decode(in);
        runCodec.decode(in);
        runCodec.decode(in);
        runCodec.decode(in);
        // k should now be 0
        runCodec.decode(in);
        int result = runCodec.decode(in);
        assertEquals(20, result);
        assertEquals(getLastField(runCodec), 20);
    }

    @Test
    void testDecodeWithNegativeK() {
        assertThrows(Pack200Exception.class, () -> new RunCodec(-1, aCodecMock, bCodecMock));
    }

    @Test
    void testDecodeWithNullCodecs() {
        assertThrows(Pack200Exception.class, () -> new RunCodec(5, null, bCodecMock));
        assertThrows(Pack200Exception.class, () -> new RunCodec(5, aCodecMock, null));
    }

    private int getLastField(RunCodec runCodec) {
        try {
            Field lastField = RunCodec.class.getDeclaredField("last");
            lastField.setAccessible(true);
            return lastField.getInt(runCodec);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
