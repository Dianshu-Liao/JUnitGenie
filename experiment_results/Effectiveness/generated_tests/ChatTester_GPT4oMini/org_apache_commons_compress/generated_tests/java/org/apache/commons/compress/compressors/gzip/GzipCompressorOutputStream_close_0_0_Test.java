package org.apache.commons.compress.compressors.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.zip.Deflater;
import java.util.zip.CRC32;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class GzipCompressorOutputStream_close_0_0_Test {

    private GzipCompressorOutputStream gzipCompressorOutputStream;

    private OutputStream mockOutputStream;

    private Deflater mockDeflater;

    @BeforeEach
    public void setUp() throws IOException {
        mockOutputStream = mock(OutputStream.class);
        gzipCompressorOutputStream = new GzipCompressorOutputStream(mockOutputStream);
        mockDeflater = mock(Deflater.class);
        // Fixed the buggy line by catching the Exception
        try {
            setPrivateField(gzipCompressorOutputStream, "deflater", mockDeflater);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testClose_WhenNotClosed_ShouldFinishAndEndDeflater() throws Exception {
        // Assuming isClosed() returns false
        setPrivateField(gzipCompressorOutputStream, "closed", false);
        // Invoke the close method
        gzipCompressorOutputStream.close();
        // Verify that the finish() method was called
        // Assuming finish is a method in the class
        verify(gzipCompressorOutputStream, times(1)).finish();
        verify(mockDeflater).end();
        verify(mockOutputStream).close();
    }

    @Test
    public void testClose_WhenAlreadyClosed_ShouldNotCallFinishOrEndDeflater() throws Exception {
        // Assuming isClosed() returns true
        setPrivateField(gzipCompressorOutputStream, "closed", true);
        gzipCompressorOutputStream.close();
        verify(mockDeflater, never()).end();
        // Assuming finish is a method in the class
        verify(gzipCompressorOutputStream, never()).finish();
        verify(mockOutputStream, never()).close();
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
