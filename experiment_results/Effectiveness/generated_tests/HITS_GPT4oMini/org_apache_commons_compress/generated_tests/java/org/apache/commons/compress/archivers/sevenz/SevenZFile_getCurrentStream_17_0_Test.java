package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.Channels;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.build.AbstractOrigin.ByteArrayOrigin;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.input.ChecksumInputStream;

class SevenZFile_getCurrentStream_17_0_Test {

    private SevenZFile sevenZFile;

    private SevenZArchiveEntry entry;

    @BeforeEach
    void setUp() throws IOException {
        Path tempFile = Files.createTempFile("testArchive", ".7z");
        SeekableByteChannel channel = Files.newByteChannel(tempFile);
        SevenZFileOptions options = SevenZFileOptions.DEFAULT;
        sevenZFile = new SevenZFile(channel, options);
        entry = new SevenZArchiveEntry();
        entry.setSize(100);
        sevenZFile.getNextEntry();
    }

    @Test
    void testGetCurrentStreamReturnsEmptyStreamForZeroSizeEntry() throws Exception {
        entry.setSize(0);
        sevenZFile.getNextEntry();
        Method getCurrentStreamMethod = SevenZFile.class.getDeclaredMethod("getCurrentStream");
        getCurrentStreamMethod.setAccessible(true);
        InputStream stream = (InputStream) getCurrentStreamMethod.invoke(sevenZFile);
        assertNotNull(stream);
        assertEquals(0, stream.available());
    }

    @Test
    void testGetCurrentStreamThrowsExceptionWhenNoCurrentEntry() throws Exception {
        Field currentEntryIndexField = SevenZFile.class.getDeclaredField("currentEntryIndex");
        currentEntryIndexField.setAccessible(true);
        currentEntryIndexField.setInt(sevenZFile, -1);
        Method getCurrentStreamMethod = SevenZFile.class.getDeclaredMethod("getCurrentStream");
        getCurrentStreamMethod.setAccessible(true);
        assertThrows(IllegalStateException.class, () -> {
            getCurrentStreamMethod.invoke(sevenZFile);
        });
    }
}
