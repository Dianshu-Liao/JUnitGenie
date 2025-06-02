package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class ZipSplitReadOnlySeekableByteChannel_assertSplitSignature_9_0_Test {

    private ZipSplitReadOnlySeekableByteChannel zipSplitReadOnlySeekableByteChannel;

    private SeekableByteChannel mockChannel;

    @BeforeEach
    void setUp() throws IOException {
        mockChannel = mock(SeekableByteChannel.class);
    }

    @Test
    void testAssertSplitSignature_ValidSignature() throws IOException {
        byte[] validSignature = ZipLong.DD_SIG.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(validSignature);
        when(mockChannel.position(0L)).thenReturn(mockChannel);
        when(mockChannel.read(any(ByteBuffer.class))).thenAnswer(invocation -> {
            ByteBuffer argBuffer = invocation.getArgument(0);
            argBuffer.put(buffer);
            return validSignature.length;
        });
        List<SeekableByteChannel> channels = Collections.singletonList(mockChannel);
        zipSplitReadOnlySeekableByteChannel = new ZipSplitReadOnlySeekableByteChannel(channels);
        // Verify that the position was set correctly
        verify(mockChannel, times(2)).position(0L);
    }

    @Test
    void testAssertSplitSignature_InvalidSignature() throws IOException {
        // Invalid signature
        byte[] invalidSignature = new byte[] { 0x00, 0x00, 0x00, 0x00 };
        ByteBuffer buffer = ByteBuffer.wrap(invalidSignature);
        when(mockChannel.position(0L)).thenReturn(mockChannel);
        when(mockChannel.read(any(ByteBuffer.class))).thenAnswer(invocation -> {
            ByteBuffer argBuffer = invocation.getArgument(0);
            argBuffer.put(buffer);
            return invalidSignature.length;
        });
        List<SeekableByteChannel> channels = Collections.singletonList(mockChannel);
        // Expect IOException when the signature is invalid
        assertThrows(IOException.class, () -> {
            zipSplitReadOnlySeekableByteChannel = new ZipSplitReadOnlySeekableByteChannel(channels);
        });
        // Verify that the position was reset
        verify(mockChannel, times(2)).position(0L);
    }
}
