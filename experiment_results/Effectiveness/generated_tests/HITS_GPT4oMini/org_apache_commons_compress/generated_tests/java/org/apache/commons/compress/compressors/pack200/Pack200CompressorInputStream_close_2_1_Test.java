package org.apache.commons.compress.compressors.pack200;

import org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream;
import org.apache.commons.io.IOUtils;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Pack200CompressorInputStream_close_2_1_Test {

    private TestPack200CompressorInputStream pack200CompressorInputStream;

    private InputStream mockInputStream;

    private AbstractStreamBridge mockAbstractStreamBridge;

    @BeforeEach
    public void setUp() throws IOException {
        mockInputStream = Mockito.mock(InputStream.class);
        mockAbstractStreamBridge = Mockito.mock(AbstractStreamBridge.class);
        File tempFile = new File("temp.pack");
        Map<String, String> options = new HashMap<>();
        pack200CompressorInputStream = new TestPack200CompressorInputStream(tempFile, options);
        pack200CompressorInputStream.setOriginalInputStream(mockInputStream);
        pack200CompressorInputStream.setAbstractStreamBridge(mockAbstractStreamBridge);
    }

    @Test
    public void testClose_ShouldCallStopOnAbstractStreamBridge() throws IOException {
        // Act
        pack200CompressorInputStream.close();
        // Assert
        verify(mockAbstractStreamBridge).stop();
    }

    @Test
    public void testClose_ShouldCloseOriginalInputStream() throws IOException {
        // Act
        pack200CompressorInputStream.close();
        // Assert
        verify(mockInputStream).close();
    }

    @Test
    public void testClose_ShouldHandleIOExceptionFromStop() throws IOException {
        // Arrange
        doThrow(new IOException("Stop failed")).when(mockAbstractStreamBridge).stop();
        // Act & Assert
        try {
            pack200CompressorInputStream.close();
        } catch (IOException e) {
            // Expected exception
        }
        // Verify that the original InputStream is still closed
        verify(mockInputStream).close();
    }

    // Subclass to expose private fields for testing
    private static class TestPack200CompressorInputStream extends Pack200CompressorInputStream {

        public TestPack200CompressorInputStream(File file, Map<String, String> options) throws IOException {
            super(file, options);
        }

        protected void setOriginalInputStream(InputStream inputStream) {
            // Use reflection or another method to set the private field
            try {
                java.lang.reflect.Field field = Pack200CompressorInputStream.class.getDeclaredField("originalInputStream");
                field.setAccessible(true);
                field.set(this, inputStream);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        protected void setAbstractStreamBridge(AbstractStreamBridge abstractStreamBridge) {
            // Use reflection or another method to set the private field
            try {
                java.lang.reflect.Field field = Pack200CompressorInputStream.class.getDeclaredField("abstractStreamBridge");
                field.setAccessible(true);
                field.set(this, abstractStreamBridge);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
