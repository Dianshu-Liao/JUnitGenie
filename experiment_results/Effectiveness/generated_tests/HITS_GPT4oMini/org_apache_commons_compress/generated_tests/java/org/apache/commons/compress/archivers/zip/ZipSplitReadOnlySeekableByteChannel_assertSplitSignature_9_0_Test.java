package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
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

public class ZipSplitReadOnlySeekableByteChannel_assertSplitSignature_9_0_Test {

    private ZipSplitReadOnlySeekableByteChannel zipSplitReadOnlySeekableByteChannel;

    @BeforeEach
    public void setUp() {
        // Setup can be done here if needed
    }

    @Test
    public void testAssertSplitSignature_ValidSignature() throws IOException {
        // Arrange
        byte[] validSignature = ZipLong.DD_SIG.getBytes();
        SeekableByteChannel mockChannel = mock(SeekableByteChannel.class);
        ByteBuffer buffer = ByteBuffer.wrap(validSignature);
        when(mockChannel.read(any(ByteBuffer.class))).thenAnswer(invocation -> {
            ByteBuffer arg = invocation.getArgument(0);
            arg.put(buffer);
            return validSignature.length;
        });
        List<SeekableByteChannel> channels = Collections.singletonList(mockChannel);
        // Act
        zipSplitReadOnlySeekableByteChannel = new ZipSplitReadOnlySeekableByteChannel(channels);
        // Assert
        assertNotNull(zipSplitReadOnlySeekableByteChannel);
        verify(mockChannel, times(1)).position(0L);
        verify(mockChannel, times(1)).read(any(ByteBuffer.class));
    }
}
