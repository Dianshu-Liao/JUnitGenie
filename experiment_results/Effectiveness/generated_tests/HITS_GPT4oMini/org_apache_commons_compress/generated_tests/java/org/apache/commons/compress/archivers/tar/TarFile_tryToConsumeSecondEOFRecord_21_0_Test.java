package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.input.BoundedInputStream;

@ExtendWith(MockitoExtension.class)
public class TarFile_tryToConsumeSecondEOFRecord_21_0_Test {

    private SeekableByteChannel mockChannel;

    private TarFile tarFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a mock SeekableByteChannel
        mockChannel = mock(SeekableByteChannel.class);
        // Initialize TarFile with the mock channel
        tarFile = new TarFile(mockChannel, TarConstants.DEFAULT_BLKSIZE, TarConstants.DEFAULT_RCDSIZE, StandardCharsets.UTF_8.name(), false);
    }

    @Test
    public void testTryToConsumeSecondEOFRecord_NoEOFRecord() throws IOException {
        // Arrange: Set up a non-EOF record
        ByteBuffer buffer = ByteBuffer.allocate(TarConstants.DEFAULT_RCDSIZE);
        // Fill with non-zero data
        buffer.put(new byte[TarConstants.DEFAULT_RCDSIZE]);
        buffer.flip();
        when(mockChannel.read(any(ByteBuffer.class))).thenReturn(TarConstants.DEFAULT_RCDSIZE);
        when(mockChannel.position()).thenReturn(0L);
        // Act: Call the method under test indirectly
        tarFile.getEntries();
        // Assert: Verify that the channel position is unchanged
        verify(mockChannel, times(1)).read(any(ByteBuffer.class));
        verify(mockChannel, times(0)).position(anyLong());
    }

    @Test
    public void testTryToConsumeSecondEOFRecord_FirstEOFRecord() throws IOException {
        // Arrange: Set up an EOF record
        ByteBuffer buffer = ByteBuffer.allocate(TarConstants.DEFAULT_RCDSIZE);
        // Fill with zero data
        buffer.put(new byte[TarConstants.DEFAULT_RCDSIZE]);
        buffer.flip();
        when(mockChannel.read(any(ByteBuffer.class))).thenReturn(TarConstants.DEFAULT_RCDSIZE);
        when(mockChannel.position()).thenReturn(0L).thenReturn((long) TarConstants.DEFAULT_RCDSIZE);
        // Act: Call the method under test indirectly
        tarFile.getEntries();
        // Assert: Verify that the channel position is reset
        verify(mockChannel, times(1)).read(any(ByteBuffer.class));
        verify(mockChannel, times(1)).position((long) TarConstants.DEFAULT_RCDSIZE);
    }

    @Test
    public void testTryToConsumeSecondEOFRecord_SecondEOFRecord() throws IOException {
        // Arrange: Set up the first EOF record followed by another EOF record
        ByteBuffer buffer = ByteBuffer.allocate(TarConstants.DEFAULT_RCDSIZE);
        // Fill with zero data for EOF
        buffer.put(new byte[TarConstants.DEFAULT_RCDSIZE]);
        buffer.flip();
        when(mockChannel.read(any(ByteBuffer.class))).thenReturn(TarConstants.DEFAULT_RCDSIZE).thenReturn(TarConstants.DEFAULT_RCDSIZE);
        // Act: Call the method under test indirectly
        tarFile.getEntries();
        // Assert: Verify that the channel position is reset back to the previous position
        verify(mockChannel, times(2)).read(any(ByteBuffer.class));
        verify(mockChannel, times(1)).position((long) TarConstants.DEFAULT_RCDSIZE);
    }
}
