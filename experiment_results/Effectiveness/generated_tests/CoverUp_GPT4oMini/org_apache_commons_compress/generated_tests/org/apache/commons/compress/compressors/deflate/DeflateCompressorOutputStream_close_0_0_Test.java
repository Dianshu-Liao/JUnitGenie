package org.apache.commons.compress.compressors.deflate;

import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream;
import org.apache.commons.compress.compressors.deflate.DeflateParameters;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.zip.Deflater;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.DeflaterOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class DeflateCompressorOutputStream_close_0_0_Test {

    private DeflateCompressorOutputStream compressorOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        compressorOutputStream = new DeflateCompressorOutputStream(byteArrayOutputStream);
    }

    @Test
    void testClose() throws Exception {
        // Close the stream and verify that it does not throw an exception
        assertDoesNotThrow(() -> {
            invokePrivateClose(compressorOutputStream);
        });
    }

    @Test
    void testCloseTwice() throws Exception {
        // Close the stream twice and verify that it does not throw an exception
        invokePrivateClose(compressorOutputStream);
        assertDoesNotThrow(() -> {
            invokePrivateClose(compressorOutputStream);
        });
    }

    @Test
    void testCloseWithDeflaterEnd() throws Exception {
        // Create a DeflateCompressorOutputStream with a custom deflater
        DeflateParameters parameters = new DeflateParameters();
        parameters.setCompressionLevel(Deflater.BEST_COMPRESSION);
        compressorOutputStream = new DeflateCompressorOutputStream(byteArrayOutputStream, parameters);
        // Close the stream and verify that it does not throw an exception
        assertDoesNotThrow(() -> {
            invokePrivateClose(compressorOutputStream);
        });
    }

    private void invokePrivateClose(DeflateCompressorOutputStream stream) throws Exception {
        Method closeMethod = DeflateCompressorOutputStream.class.getDeclaredMethod("close");
        closeMethod.setAccessible(true);
        closeMethod.invoke(stream);
    }
}
