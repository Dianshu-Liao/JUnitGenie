// Test method
package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.Collections;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ZipSplitReadOnlySeekableByteChannel_assertSplitSignature_9_0_Test {

    private ZipSplitReadOnlySeekableByteChannel zipSplitReadOnlySeekableByteChannel;

    private SeekableByteChannel mockChannel;

    @BeforeEach
    public void setUp() throws IOException {
        mockChannel = mock(SeekableByteChannel.class);
        zipSplitReadOnlySeekableByteChannel = new ZipSplitReadOnlySeekableByteChannel(Collections.singletonList(mockChannel));
    }

    @Test
    public void testAssertSplitSignature_ValidSignature() throws Exception {
        // Arrange
        ByteBuffer buffer = ByteBuffer.allocate(4);
        // DD_SIG equivalent
        buffer.put(new byte[] { (byte) 0x50, (byte) 0x4B, (byte) 0x03, (byte) 0x04 });
        buffer.flip();
        when(mockChannel.position(0L)).thenReturn(mockChannel);
        when(mockChannel.read(any(ByteBuffer.class))).thenAnswer(invocation -> {
            ByteBuffer byteBuffer = invocation.getArgument(0);
            byteBuffer.put(buffer);
            return buffer.remaining();
        });
        // Act
        invokePrivateMethod("assertSplitSignature", Collections.singletonList(mockChannel));
        // Assert
        verify(mockChannel, times(1)).position(0L);
        verify(mockChannel, times(1)).read(any(ByteBuffer.class));
    }

    @Test
    public void testAssertSplitSignature_InvalidSignature() throws Exception {
        // Arrange
        ByteBuffer buffer = ByteBuffer.allocate(4);
        // Invalid signature
        buffer.put(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 });
        buffer.flip();
        when(mockChannel.position(0L)).thenReturn(mockChannel);
        when(mockChannel.read(any(ByteBuffer.class))).thenAnswer(invocation -> {
            ByteBuffer byteBuffer = invocation.getArgument(0);
            byteBuffer.put(buffer);
            return buffer.remaining();
        });
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            invokePrivateMethod("assertSplitSignature", Collections.singletonList(mockChannel));
        });
        assertEquals("The first ZIP split segment does not begin with split ZIP file signature", exception.getMessage());
        verify(mockChannel, times(2)).position(0L);
    }

    private void invokePrivateMethod(String methodName, List<SeekableByteChannel> channels) throws Exception {
        java.lang.reflect.Method method = ZipSplitReadOnlySeekableByteChannel.class.getDeclaredMethod(methodName, List.class);
        method.setAccessible(true);
        method.invoke(zipSplitReadOnlySeekableByteChannel, channels);
    }
}
