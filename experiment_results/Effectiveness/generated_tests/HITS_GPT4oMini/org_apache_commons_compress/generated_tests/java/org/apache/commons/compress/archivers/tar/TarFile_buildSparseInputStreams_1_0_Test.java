package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.nio.channels.SeekableByteChannel;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.io.input.BoundedInputStream;

class TarFile_buildSparseInputStreams_1_0_Test {

    private TarFile tarFile;

    @BeforeEach
    void setUp() throws IOException {
        // Initialize TarFile with a mock or real SeekableByteChannel
        byte[] content = new byte[1024];
        tarFile = new TarFile(content);
    }

    @Test
    void testBuildSparseInputStreams() throws Exception {
        // Create a TarArchiveEntry and set it in the TarFile
        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        entry.setSparseHeaders(Arrays.asList(new TarArchiveStructSparse(0, 10), new TarArchiveStructSparse(20, 5)));
        // Use reflection to set the currEntry field
        Field currEntryField = TarFile.class.getDeclaredField("currEntry");
        currEntryField.setAccessible(true);
        currEntryField.set(tarFile, entry);
        // Invoke the private buildSparseInputStreams method using reflection
        tarFile.getClass().getDeclaredMethod("buildSparseInputStreams").invoke(tarFile);
        // Access the private sparseInputStreams field using reflection
        Field sparseInputStreamsField = TarFile.class.getDeclaredField("sparseInputStreams");
        sparseInputStreamsField.setAccessible(true);
        Map<String, List<InputStream>> streamsMap = (Map<String, List<InputStream>>) sparseInputStreamsField.get(tarFile);
        List<InputStream> streams = streamsMap.get(entry.getName());
        assertNotNull(streams);
        // 2 sparse headers + 1 zero stream
        assertEquals(3, streams.size());
        // Further assertions can be added based on expected behavior
    }
}
