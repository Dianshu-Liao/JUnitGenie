package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.apache.commons.io.input.BoundedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Closeable;
import java.nio.file.Files;
import java.util.LinkedList;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;

class TarFile_buildSparseInputStreams_1_3_Test {

    private TarFile tarFile;

    private TarArchiveEntry mockEntry;

    @BeforeEach
    void setUp() throws Exception {
        // Mocking the TarArchiveEntry
        mockEntry = new TarArchiveEntry("mockEntry");
        List<TarArchiveStructSparse> sparseHeaders = new ArrayList<>();
        sparseHeaders.add(new TarArchiveStructSparse(0, 10));
        sparseHeaders.add(new TarArchiveStructSparse(20, 30));
        mockEntry.setSparseHeaders(sparseHeaders);
        // Mocking SeekableByteChannel
        SeekableByteChannel mockChannel = new SeekableByteChannel() {

            private long position = 0;

            @Override
            public boolean isOpen() {
                return true;
            }

            @Override
            public void close() throws IOException {
            }

            @Override
            public int read(ByteBuffer dst) {
                return 0;
            }

            @Override
            public long position() {
                return position;
            }

            @Override
            public SeekableByteChannel position(long newPosition) {
                this.position = newPosition;
                return this;
            }

            @Override
            public long size() {
                return 100;
            }

            @Override
            public SeekableByteChannel truncate(long size) {
                return this;
            }

            @Override
            public int write(ByteBuffer src) {
                return 0;
            }
        };
        // Initialize TarFile with mocked channel
        tarFile = new TarFile(mockChannel);
        // Accessing the private field currEntry using reflection
        java.lang.reflect.Field currEntryField = TarFile.class.getDeclaredField("currEntry");
        currEntryField.setAccessible(true);
        currEntryField.set(tarFile, mockEntry);
    }

    @Test
    void testBuildSparseInputStreams() throws Exception {
        // Accessing the private method using reflection
        Method method = TarFile.class.getDeclaredMethod("buildSparseInputStreams");
        method.setAccessible(true);
        // Execute the method
        method.invoke(tarFile);
        // Validate the output
        Map<String, List<InputStream>> sparseInputStreams = (Map<String, List<InputStream>>) TarFile.class.getDeclaredField("sparseInputStreams").get(tarFile);
        assertNotNull(sparseInputStreams);
        assertTrue(sparseInputStreams.containsKey(mockEntry.getName()));
        assertEquals(2, sparseInputStreams.get(mockEntry.getName()).size());
    }

    @Test
    void testBuildSparseInputStreams_CorruptedStructSparse() throws Exception {
        // Set up a corrupted sparse header
        List<TarArchiveStructSparse> sparseHeaders = new ArrayList<>();
        sparseHeaders.add(new TarArchiveStructSparse(10, 10));
        // Overlapping header
        sparseHeaders.add(new TarArchiveStructSparse(5, 10));
        mockEntry.setSparseHeaders(sparseHeaders);
        // Accessing the private method using reflection
        Method method = TarFile.class.getDeclaredMethod("buildSparseInputStreams");
        method.setAccessible(true);
        // Expecting an IOException
        assertThrows(IOException.class, () -> method.invoke(tarFile));
    }

    @Test
    void testBuildSparseInputStreams_EmptySparseHeaders() throws Exception {
        // Set up empty sparse headers
        mockEntry.setSparseHeaders(new ArrayList<>());
        // Accessing the private method using reflection
        Method method = TarFile.class.getDeclaredMethod("buildSparseInputStreams");
        method.setAccessible(true);
        // Execute the method
        method.invoke(tarFile);
        // Validate the output
        Map<String, List<InputStream>> sparseInputStreams = (Map<String, List<InputStream>>) TarFile.class.getDeclaredField("sparseInputStreams").get(tarFile);
        assertNotNull(sparseInputStreams);
        assertTrue(sparseInputStreams.containsKey(mockEntry.getName()));
        assertTrue(sparseInputStreams.get(mockEntry.getName()).isEmpty());
    }
}
