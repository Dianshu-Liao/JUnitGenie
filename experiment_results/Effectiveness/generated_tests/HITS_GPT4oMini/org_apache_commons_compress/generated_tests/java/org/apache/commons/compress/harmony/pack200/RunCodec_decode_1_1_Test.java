package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.apache.commons.compress.utils.ExactMath;

public class RunCodec_decode_1_1_Test {

    @Mock
    private Codec aCodec;

    @Mock
    private Codec bCodec;

    private RunCodec runCodec;

    @BeforeEach
    public void setUp() throws Pack200Exception {
        MockitoAnnotations.openMocks(this);
        runCodec = new RunCodec(5, aCodec, bCodec);
    }

    @Test
    public void testDecodeWithACodec() throws Exception {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        // Changed Long to int
        when(aCodec.decode(inputStream, 0)).thenReturn(10);
        // First call to set last value
        runCodec.decode(inputStream, 0);
        // Act
        // Changed long to int
        int result = runCodec.decode(inputStream, 0);
        // Assert
        assertEquals(10, result);
        verify(aCodec, times(1)).decode(inputStream, 0);
    }

    @Test
    public void testDecodeWithBCodec() throws Exception {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        // First call to set last value
        runCodec.decode(inputStream, 0);
        // Changed Long to int
        when(bCodec.decode(inputStream, 10)).thenReturn(20);
        // Act
        // Changed long to int
        int result = runCodec.decode(inputStream, 10);
        // Assert
        assertEquals(20, result);
        verify(bCodec, times(1)).decode(inputStream, 10);
    }
}
