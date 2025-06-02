package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.DeflaterOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class DeflateCompressorOutputStream_close_0_1_Test {

    private Deflater deflater;

    private OutputStream outputStream;

    private DeflateCompressorOutputStream compressorOutputStream;

    @BeforeEach
    public void setUp() {
        deflater = mock(Deflater.class);
        outputStream = mock(OutputStream.class);
        compressorOutputStream = new DeflateCompressorOutputStream(outputStream);
        // Use reflection to set the private deflater field
        try {
            java.lang.reflect.Field deflaterField = DeflateCompressorOutputStream.class.getDeclaredField("deflater");
            deflaterField.setAccessible(true);
            deflaterField.set(compressorOutputStream, deflater);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Setup failed: " + e.getMessage());
        }
    }

    @Test
    public void testClose() throws IOException {
        // Mock the behavior of the super class close method
        doNothing().when(outputStream).close();
        // Invoke the close method
        compressorOutputStream.close();
        // Verify that deflater.end() is called
        verify(deflater).end();
    }

    @Test
    public void testCloseHandlesIOException() throws IOException {
        // Mock the behavior of the super class close method to throw IOException
        doThrow(new IOException("Test exception")).when(outputStream).close();
        // Invoke the close method and verify that deflater.end() is still called
        assertThrows(IOException.class, () -> compressorOutputStream.close());
        verify(deflater).end();
    }
}
