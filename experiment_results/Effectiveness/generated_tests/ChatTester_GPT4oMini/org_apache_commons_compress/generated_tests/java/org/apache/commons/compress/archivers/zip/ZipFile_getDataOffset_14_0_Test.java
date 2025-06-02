package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.build.AbstractOrigin.ByteArrayOrigin;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOStream;
import org.apache.commons.io.input.BoundedInputStream;

public class ZipFile_getDataOffset_14_0_Test {

    private ZipFile zipFile;

    private ZipArchiveEntry mockEntry;

    @BeforeEach
    public void setUp() throws Exception {
        // Mock ZipArchiveEntry
        mockEntry = mock(ZipArchiveEntry.class);
        // Initialize ZipFile with a dummy SeekableByteChannel
        zipFile = new ZipFile(Paths.get("dummy.zip"));
    }

    @Test
    public void testGetDataOffset_WhenDataOffsetIsUnknown_ShouldSetAndReturnDataOffset() throws Exception {
        // Arrange
        when(mockEntry.getDataOffset()).thenReturn(EntryStreamOffsets.OFFSET_UNKNOWN);
        // Use reflection to access the private method
        Method method = ZipFile.class.getDeclaredMethod("getDataOffset", ZipArchiveEntry.class);
        method.setAccessible(true);
        // Act
        long result = (long) method.invoke(zipFile, mockEntry);
        // Assert
        assertEquals(mockEntry.getDataOffset(), result);
        verify(mockEntry, times(1)).getDataOffset();
        // Additional verification can be done here if setDataOffset is mocked
    }

    @Test
    public void testGetDataOffset_WhenDataOffsetIsKnown_ShouldReturnDataOffset() throws Exception {
        // Arrange
        long expectedOffset = 100L;
        when(mockEntry.getDataOffset()).thenReturn(expectedOffset);
        // Use reflection to access the private method
        Method method = ZipFile.class.getDeclaredMethod("getDataOffset", ZipArchiveEntry.class);
        method.setAccessible(true);
        // Act
        long result = (long) method.invoke(zipFile, mockEntry);
        // Assert
        assertEquals(expectedOffset, result);
        verify(mockEntry, times(1)).getDataOffset();
    }
}
