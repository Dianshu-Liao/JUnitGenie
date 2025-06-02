package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
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
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.OpenOption;
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

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary file to initialize ZipFile
        Path tempFile = Files.createTempFile("test", ".zip");
        // Ensure the file is deleted after tests
        tempFile.toFile().deleteOnExit();
        zipFile = new ZipFile(tempFile);
        zipArchiveEntry = new ZipArchiveEntry("test.txt");
    }

    @Test
    public void testGetDataOffset_WhenDataOffsetIsKnown() {
        // Arrange
        long expectedOffset = 100L;
        zipArchiveEntry.setDataOffset(expectedOffset);
        // Act
        long actualOffset = invokeGetDataOffset(zipFile, zipArchiveEntry);
        // Assert
        assertEquals(expectedOffset, actualOffset, "The data offset should be returned correctly when known.");
    }

    @Test
    public void testGetDataOffset_WhenDataOffsetIsUnknown() {
        // Arrange
        zipArchiveEntry.setDataOffset(EntryStreamOffsets.OFFSET_UNKNOWN);
        // Act
        long actualOffset = invokeGetDataOffset(zipFile, zipArchiveEntry);
        // Assert
        // Here we expect the setDataOffset method to be called, which we can't directly verify without a mocking framework.
        // Therefore, we just check that no exceptions are thrown.
        assertNotEquals(EntryStreamOffsets.OFFSET_UNKNOWN, actualOffset, "The data offset should not be unknown after processing.");
    }

    @Test
    public void testGetDataOffset_ThrowsIOException_WhenDataOverlapsWithCentralDirectory() {
        // Arrange
        zipArchiveEntry.setDataOffset(EntryStreamOffsets.OFFSET_UNKNOWN);
        zipArchiveEntry.setLocalHeaderOffset(200L);
        zipArchiveEntry.setCompressedSize(50L);
        // Set central directory start offset to overlap using reflection
        setCentralDirectoryStartOffset(zipFile, 200L);
        // Act & Assert
        assertThrows(IOException.class, () -> {
            invokeGetDataOffset(zipFile, zipArchiveEntry);
        }, "Expected IOException when data overlaps with central directory.");
    }

    private long invokeGetDataOffset(ZipFile zipFile, ZipArchiveEntry entry) {
        try {
            Method method = ZipFile.class.getDeclaredMethod("getDataOffset", ZipArchiveEntry.class);
            method.setAccessible(true);
            return (long) method.invoke(zipFile, entry);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke getDataOffset method", e);
        }
    }

    private void setCentralDirectoryStartOffset(ZipFile zipFile, long offset) {
        try {
            java.lang.reflect.Field field = ZipFile.class.getDeclaredField("centralDirectoryStartOffset");
            field.setAccessible(true);
            field.set(zipFile, offset);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set centralDirectoryStartOffset field", e);
        }
    }
}
