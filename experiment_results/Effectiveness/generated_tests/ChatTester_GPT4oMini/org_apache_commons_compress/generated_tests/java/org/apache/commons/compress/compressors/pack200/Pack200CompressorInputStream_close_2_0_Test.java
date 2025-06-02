// Test method
package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.util.jar.JarOutputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.java.util.jar.Pack200;
import org.apache.commons.io.IOUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Pack200CompressorInputStream_close_2_0_Test {

    private Pack200CompressorInputStream pack200CompressorInputStream;

    private InputStream mockInputStream;

    private AbstractStreamBridge mockAbstractStreamBridge;

    @BeforeEach
    void setUp() throws IOException {
        mockInputStream = mock(InputStream.class);
        mockAbstractStreamBridge = mock(AbstractStreamBridge.class);
        pack200CompressorInputStream = Mockito.spy(new Pack200CompressorInputStream(mockInputStream, new HashMap<>()));
        // Repairing the buggy line to catch the exception properly
        try {
            setPrivateField(pack200CompressorInputStream, "originalInputStream", mockInputStream);
            setPrivateField(pack200CompressorInputStream, "abstractStreamBridge", mockAbstractStreamBridge);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testClose_callsStopAndClosesInputStream() throws IOException {
        // Act
        pack200CompressorInputStream.close();
        // Assert
        verify(mockAbstractStreamBridge).stop();
        verify(mockInputStream).close();
    }

    @Test
    void testClose_handlesIOExceptionFromStop() throws IOException {
        // Arrange
        doThrow(new IOException("Stop failed")).when(mockAbstractStreamBridge).stop();
        // Act
        pack200CompressorInputStream.close();
        // Assert
        verify(mockInputStream).close();
    }

    @Test
    void testClose_handlesIOExceptionFromClose() throws IOException {
        // Arrange
        doThrow(new IOException("Close failed")).when(mockInputStream).close();
        // Act
        pack200CompressorInputStream.close();
        // Assert
        verify(mockAbstractStreamBridge).stop();
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
