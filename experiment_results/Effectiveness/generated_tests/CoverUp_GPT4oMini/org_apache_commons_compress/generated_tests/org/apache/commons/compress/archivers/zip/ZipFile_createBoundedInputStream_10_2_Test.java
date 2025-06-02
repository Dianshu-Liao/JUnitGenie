package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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

public class ZipFile_createBoundedInputStream_10_2_Test {

    private ZipFile zipFile;

    private FileChannel fileChannel;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary zip file for testing
        Path tempFilePath = Paths.get("temp.zip");
        // Ensure the file exists
        try (RandomAccessFile raf = new RandomAccessFile(tempFilePath.toFile(), "rw")) {
            // Set file size for testing
            raf.setLength(1024);
        }
        fileChannel = FileChannel.open(tempFilePath);
        zipFile = new ZipFile(fileChannel);
    }

    @Test
    public void testCreateBoundedInputStream_ValidParameters() throws Exception {
        // Invoke the private method using reflection
        BoundedArchiveInputStream inputStream = (BoundedArchiveInputStream) invokePrivateMethod("createBoundedInputStream", 0, 500);
        assertNotNull(inputStream);
    }

    @Test
    public void testCreateBoundedInputStream_NegativeStart() {
        assertThrows(IllegalArgumentException.class, () -> {
            invokePrivateMethod("createBoundedInputStream", -1, 500);
        });
    }

    @Test
    public void testCreateBoundedInputStream_NegativeRemaining() {
        assertThrows(IllegalArgumentException.class, () -> {
            invokePrivateMethod("createBoundedInputStream", 0, -1);
        });
    }

    @Test
    public void testCreateBoundedInputStream_Overflow() {
        assertThrows(IllegalArgumentException.class, () -> {
            invokePrivateMethod("createBoundedInputStream", Long.MAX_VALUE, 1);
        });
    }

    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = ZipFile.class.getDeclaredMethod(methodName, long.class, long.class);
        method.setAccessible(true);
        return method.invoke(zipFile, args);
    }
}
