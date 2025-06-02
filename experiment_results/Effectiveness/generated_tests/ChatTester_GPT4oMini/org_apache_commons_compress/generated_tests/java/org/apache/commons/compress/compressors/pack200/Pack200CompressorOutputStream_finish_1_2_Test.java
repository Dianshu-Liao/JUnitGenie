package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarInputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.java.util.jar.Pack200;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Pack200CompressorOutputStream_finish_1_2_Test {

    private Pack200CompressorOutputStream pack200CompressorOutputStream;

    private AbstractStreamBridge abstractStreamBridge;

    private OutputStream outputStream;

    private Map<String, String> properties;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        outputStream = mock(OutputStream.class);
        abstractStreamBridge = mock(AbstractStreamBridge.class);
        properties = new HashMap<>();
        properties.put("key", "value");
        pack200CompressorOutputStream = new Pack200CompressorOutputStream(outputStream);
        // Use reflection to set the private field abstractStreamBridge
        java.lang.reflect.Field field = Pack200CompressorOutputStream.class.getDeclaredField("abstractStreamBridge");
        field.setAccessible(true);
        field.set(pack200CompressorOutputStream, abstractStreamBridge);
        field = Pack200CompressorOutputStream.class.getDeclaredField("properties");
        field.setAccessible(true);
        field.set(pack200CompressorOutputStream, properties);
    }

    @Test
    void testFinish_WhenNotFinished_ShouldInvokeSuperFinishAndPack() throws IOException, ReflectiveOperationException {
        when(abstractStreamBridge.getInputStream()).thenReturn(mock(JarInputStream.class));
        // Use reflection to access the protected isFinished() method
        java.lang.reflect.Method isFinishedMethod = Pack200CompressorOutputStream.class.getDeclaredMethod("isFinished");
        isFinishedMethod.setAccessible(true);
        when(isFinishedMethod.invoke(pack200CompressorOutputStream)).thenReturn(false);
        pack200CompressorOutputStream.finish();
        // Verify
        java.lang.reflect.Method superFinishMethod = CompressorOutputStream.class.getDeclaredMethod("finish");
        superFinishMethod.setAccessible(true);
        verify(superFinishMethod.invoke(pack200CompressorOutputStream), times(1));
        verify(abstractStreamBridge, times(1)).getInputStream();
        Pack200.Packer packer = Pack200.newPacker();
        verify(packer.properties(), times(1)).putAll(properties);
        verify(packer, times(1)).pack(any(JarInputStream.class), eq(outputStream));
    }

    @Test
    void testFinish_WhenAlreadyFinished_ShouldNotInvokeSuperFinishOrPack() throws IOException, ReflectiveOperationException {
        // Use reflection to access the protected isFinished() method
        java.lang.reflect.Method isFinishedMethod = Pack200CompressorOutputStream.class.getDeclaredMethod("isFinished");
        isFinishedMethod.setAccessible(true);
        when(isFinishedMethod.invoke(pack200CompressorOutputStream)).thenReturn(true);
        pack200CompressorOutputStream.finish();
        // Verify
        java.lang.reflect.Method superFinishMethod = CompressorOutputStream.class.getDeclaredMethod("finish");
        superFinishMethod.setAccessible(true);
        verify(superFinishMethod.invoke(pack200CompressorOutputStream), never());
        verify(abstractStreamBridge, never()).getInputStream();
    }
}
