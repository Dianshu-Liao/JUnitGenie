// Test method
package org.apache.commons.compress.compressors.snappy;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SnappyCompressorOutputStream_finish_2_0_Test {

    @Mock
    private LZ77Compressor compressor;

    @Mock
    private ByteUtils.ByteConsumer consumer;

    @Mock
    private OutputStream outputStream;

    @InjectMocks
    private SnappyCompressorOutputStream snappyCompressorOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        // Assuming some default values
        snappyCompressorOutputStream = new SnappyCompressorOutputStream(outputStream, 100);
    }

    @Test
    public void testFinish_WhenNotFinished_ShouldCallCompressorFinishAndSuperFinish() throws IOException {
        // Repairing the buggy line by using reflection to access the protected method
        setPrivateField(snappyCompressorOutputStream, "finished", false);
        // Act
        snappyCompressorOutputStream.finish();
        // Assert
        verify(compressor).finish();
        verify(snappyCompressorOutputStream, times(1)).finish();
    }

    @Test
    public void testFinish_WhenAlreadyFinished_ShouldNotCallCompressorFinish() throws IOException {
        // Repairing the buggy line by using reflection to access the protected method
        setPrivateField(snappyCompressorOutputStream, "finished", true);
        // Act
        snappyCompressorOutputStream.finish();
        // Assert
        verify(compressor, never()).finish();
        verify(snappyCompressorOutputStream, times(1)).finish();
    }

    private void setPrivateField(Object obj, String fieldName, boolean value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setBoolean(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
