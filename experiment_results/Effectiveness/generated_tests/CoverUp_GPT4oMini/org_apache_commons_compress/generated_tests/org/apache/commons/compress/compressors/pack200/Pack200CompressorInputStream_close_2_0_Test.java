package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.UncheckedIOException;
import org.apache.commons.compress.java.util.jar.Pack200;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.jar.JarOutputStream;

@ExtendWith(MockitoExtension.class)
class Pack200CompressorInputStream_close_2_0_Test {

    private Pack200CompressorInputStream compressorInputStream;

    private InputStream mockInputStream;

    private AbstractStreamBridge mockStreamBridge;

    @BeforeEach
    void setUp() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        mockInputStream = mock(InputStream.class);
        mockStreamBridge = mock(AbstractStreamBridge.class);
        // Use reflection to invoke the private constructor
        Constructor<Pack200CompressorInputStream> constructor = Pack200CompressorInputStream.class.getDeclaredConstructor(InputStream.class, File.class, Pack200Strategy.class, Map.class);
        constructor.setAccessible(true);
        compressorInputStream = constructor.newInstance(mockInputStream, null, null, new HashMap<>());
    }

    @Test
    void testCloseSuccessfully() throws IOException {
        // Arrange
        doNothing().when(mockStreamBridge).stop();
        // Act
        compressorInputStream.close();
        // Assert
        verify(mockStreamBridge, times(1)).stop();
        verify(mockInputStream, times(1)).close();
    }

    @Test
    void testCloseThrowsIOExceptionFromStreamBridge() throws IOException {
        // Arrange
        doThrow(new IOException("StreamBridge error")).when(mockStreamBridge).stop();
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            compressorInputStream.close();
        });
        verify(mockStreamBridge, times(1)).stop();
        verify(mockInputStream, times(1)).close();
        assertEquals("StreamBridge error", exception.getMessage());
    }

    @Test
    void testCloseThrowsIOExceptionFromInputStream() throws IOException {
        // Arrange
        doNothing().when(mockStreamBridge).stop();
        doThrow(new IOException("InputStream error")).when(mockInputStream).close();
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            compressorInputStream.close();
        });
        verify(mockStreamBridge, times(1)).stop();
        verify(mockInputStream, times(1)).close();
        assertEquals("InputStream error", exception.getMessage());
    }
}
