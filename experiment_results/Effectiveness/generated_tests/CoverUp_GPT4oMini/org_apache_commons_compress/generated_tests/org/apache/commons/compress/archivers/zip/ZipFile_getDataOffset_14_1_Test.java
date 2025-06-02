package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.EntryStreamOffsets;
import java.io.IOException;
import java.lang.reflect.Method;
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

public class ZipFile_getDataOffset_14_1_Test {

    private ZipFile zipFile;

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a mock for ZipArchiveEntry
        zipArchiveEntry = mock(ZipArchiveEntry.class);
        // Initialize ZipFile with a mock channel (or use a valid path if needed)
        zipFile = mock(ZipFile.class);
    }

    @Test
    public void testGetDataOffsetWhenOffsetIsUnknown() throws Exception {
        // Arrange
        when(zipArchiveEntry.getDataOffset()).thenReturn(EntryStreamOffsets.OFFSET_UNKNOWN);
        // Act
        long result = invokePrivateGetDataOffset(zipFile, zipArchiveEntry);
        // Assert
        assertEquals(EntryStreamOffsets.OFFSET_UNKNOWN, result);
        // Verify that setDataOffset was called
        verify(zipArchiveEntry).setDataOffset(anyLong());
    }

    @Test
    public void testGetDataOffsetWhenOffsetIsKnown() throws Exception {
        // Arrange
        long expectedOffset = 100L;
        when(zipArchiveEntry.getDataOffset()).thenReturn(expectedOffset);
        // Act
        long result = invokePrivateGetDataOffset(zipFile, zipArchiveEntry);
        // Assert
        assertEquals(expectedOffset, result);
        // Verify that setDataOffset was not called
        verify(zipArchiveEntry, never()).setDataOffset(anyLong());
    }

    private long invokePrivateGetDataOffset(ZipFile zipFile, ZipArchiveEntry zipArchiveEntry) throws Exception {
        Method method = ZipFile.class.getDeclaredMethod("getDataOffset", ZipArchiveEntry.class);
        method.setAccessible(true);
        return (long) method.invoke(zipFile, zipArchiveEntry);
    }
}
