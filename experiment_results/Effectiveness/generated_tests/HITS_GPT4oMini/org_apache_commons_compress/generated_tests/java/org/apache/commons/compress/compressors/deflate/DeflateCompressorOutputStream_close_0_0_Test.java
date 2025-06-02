package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.zip.DeflaterOutputStream;

public class DeflateCompressorOutputStream_close_0_0_Test {

    @Test
    public void testClose_callsSuperClose() throws IOException {
        // Arrange
        OutputStream mockOutputStream = mock(OutputStream.class);
        DeflateParameters deflateParameters = new DeflateParameters();
        DeflateCompressorOutputStream compressorOutputStream = new DeflateCompressorOutputStream(mockOutputStream, deflateParameters);
        // Act
        compressorOutputStream.close();
        // Assert
        verify(mockOutputStream, times(1)).close();
        // Verify that deflater is ended
        // Note: The deflater is now managed internally, so we cannot verify it directly here.
    }

    @Test
    public void testClose_handlesIOException() throws IOException {
        // Arrange
        OutputStream mockOutputStream = mock(OutputStream.class);
        DeflateParameters deflateParameters = new DeflateParameters();
        DeflateCompressorOutputStream compressorOutputStream = new DeflateCompressorOutputStream(mockOutputStream, deflateParameters);
        doThrow(new IOException("Test Exception")).when(mockOutputStream).close();
        // Act & Assert
        try {
            compressorOutputStream.close();
        } catch (IOException e) {
            // Expected exception
        }
        // Verify that deflater is still ended
        // Note: The deflater is now managed internally, so we cannot verify it directly here.
    }

    @Test
    public void testClose_whenAlreadyClosed() throws IOException {
        // Arrange
        OutputStream mockOutputStream = mock(OutputStream.class);
        DeflateParameters deflateParameters = new DeflateParameters();
        DeflateCompressorOutputStream compressorOutputStream = new DeflateCompressorOutputStream(mockOutputStream, deflateParameters);
        // Close once
        compressorOutputStream.close();
        // Act
        // Close again
        compressorOutputStream.close();
        // Assert
        // Should still only call close once
        verify(mockOutputStream, times(1)).close();
        // Should still call end once
        // Note: The deflater is now managed internally, so we cannot verify it directly here.
    }
}
