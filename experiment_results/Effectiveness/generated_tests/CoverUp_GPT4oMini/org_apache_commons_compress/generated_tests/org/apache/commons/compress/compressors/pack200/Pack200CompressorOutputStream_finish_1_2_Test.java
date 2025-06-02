package org.apache.commons.compress.compressors.pack200;

import org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream;
import org.apache.commons.compress.java.util.jar.Pack200;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarInputStream;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class Pack200CompressorOutputStream_finish_1_2_Test {

    private Pack200CompressorOutputStream compressorOutputStream;

    private OutputStream mockOutputStream;

    private AbstractStreamBridge mockStreamBridge;

    private Map<String, String> properties;

    @BeforeEach
    void setUp() throws IOException {
        mockOutputStream = new ByteArrayOutputStream();
        mockStreamBridge = Mockito.mock(AbstractStreamBridge.class);
        properties = new HashMap<>();
        properties.put("key1", "value1");
        properties.put("key2", "value2");
        compressorOutputStream = new Pack200CompressorOutputStream(mockOutputStream, properties);
    }

    @Test
    void testFinish_WhenNotFinished_ShouldInvokeFinish() throws Exception {
        // Arrange
        when(mockStreamBridge.getInputStream()).thenReturn(mock(JarInputStream.class));
        Pack200.Packer mockPacker = Mockito.mock(Pack200.Packer.class);
        when(Pack200.newPacker()).thenReturn(mockPacker);
        // Act
        invokeFinishMethod();
        // Assert
        verify(mockPacker).pack(any(JarInputStream.class), eq(mockOutputStream));
        verify(mockOutputStream, times(1)).flush();
    }

    @Test
    void testFinish_WhenAlreadyFinished_ShouldNotInvokeFinish() throws Exception {
        // Arrange
        // Call finish once to set finished state
        invokeFinishMethod();
        // Act
        invokeFinishMethod();
        // Assert
        // Ensure flush was called only once
        verify(mockOutputStream, times(1)).flush();
    }

    private void invokeFinishMethod() throws Exception {
        java.lang.reflect.Method finishMethod = Pack200CompressorOutputStream.class.getDeclaredMethod("finish");
        finishMethod.setAccessible(true);
        finishMethod.invoke(compressorOutputStream);
    }
}
