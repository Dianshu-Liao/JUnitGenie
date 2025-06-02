package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.Channels;
import java.util.List;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.input.BoundedInputStream;

class TarFile_tryToConsumeSecondEOFRecord_21_1_Test {

    private TarFile tarFile;

    private SeekableByteChannel channel;

    @BeforeEach
    void setUp() throws IOException {
        // Prepare a mock tar file with EOF records
        // Simulated tar file content
        byte[] content = new byte[512];
        // Fill with two EOF records (12 bytes of zeros)
        // Simulate the first EOF record
        content[500] = 0;
        // Simulate the second EOF record
        content[501] = 0;
        channel = new SeekableInMemoryByteChannel(content);
        tarFile = new TarFile(channel);
    }

    @Test
    void testTryToConsumeSecondEOFRecord() throws Exception {
        // Access the private method using reflection
        Method method = TarFile.class.getDeclaredMethod("tryToConsumeSecondEOFRecord");
        method.setAccessible(true);
        // Invoke the method
        method.invoke(tarFile);
        // Verify the state after consuming EOF records
        List<TarArchiveEntry> entries = tarFile.getEntries();
        assertTrue(entries.isEmpty(), "Should not have any entries after consuming EOF records");
    }

    @Test
    void testTryToConsumeSecondEOFRecordWithNonEOF() throws Exception {
        // Prepare a mock tar file with non-EOF records
        byte[] content = new byte[512];
        // Simulate a non-EOF record
        content[0] = 1;
        // Simulate the first EOF record
        content[500] = 0;
        // Simulate the second EOF record
        content[501] = 0;
        channel = new SeekableInMemoryByteChannel(content);
        tarFile = new TarFile(channel);
        // Access the private method using reflection
        Method method = TarFile.class.getDeclaredMethod("tryToConsumeSecondEOFRecord");
        method.setAccessible(true);
        // Invoke the method
        method.invoke(tarFile);
        // Verify that the position is reset correctly
        assertEquals(0, channel.position(), "Position should be reset after consuming non-EOF record");
    }
}
