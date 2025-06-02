package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SevenZOutputFile_writeFileMTimes_25_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private DataOutput mockDataOutput;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        Path tempFile = Files.createTempFile("test", ".7z");
        SeekableByteChannel channel = Files.newByteChannel(tempFile);
        sevenZOutputFile = new SevenZOutputFile(channel);
        mockDataOutput = mock(DataOutput.class);
    }

    @Test
    void testWriteFileMTimesWithNoEntries() throws Exception {
        // Invoke the method using reflection
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
        method.setAccessible(true);
        // Call the method
        method.invoke(sevenZOutputFile, mockDataOutput);
        // Verify that nothing was written to the DataOutput
        verify(mockDataOutput, never()).write(any());
    }

    @Test
    void testWriteFileMTimesWithOneEntry() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        entry.setName("file1.txt");
        entry.setLastModifiedDate(new Date());
        entry.setHasLastModifiedDate(true);
        sevenZOutputFile.getClass().getDeclaredField("files").set(sevenZOutputFile, Collections.singletonList(entry));
        // Invoke the method using reflection
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
        method.setAccessible(true);
        // Call the method
        method.invoke(sevenZOutputFile, mockDataOutput);
        // Verify that the correct data was written
        verify(mockDataOutput, times(1)).write(any());
    }

    @Test
    void testWriteFileMTimesWithMultipleEntries() throws Exception {
        SevenZArchiveEntry entry1 = new SevenZArchiveEntry();
        entry1.setName("file1.txt");
        entry1.setLastModifiedDate(new Date());
        entry1.setHasLastModifiedDate(true);
        SevenZArchiveEntry entry2 = new SevenZArchiveEntry();
        entry2.setName("file2.txt");
        entry2.setLastModifiedDate(new Date());
        entry2.setHasLastModifiedDate(false);
        List<SevenZArchiveEntry> entries = new ArrayList<>();
        entries.add(entry1);
        entries.add(entry2);
        sevenZOutputFile.getClass().getDeclaredField("files").set(sevenZOutputFile, entries);
        // Invoke the method using reflection
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
        method.setAccessible(true);
        // Call the method
        method.invoke(sevenZOutputFile, mockDataOutput);
        // Verify that the correct data was written
        verify(mockDataOutput, times(1)).write(any());
    }

    @Test
    void testWriteFileMTimesAllEntriesDefined() throws Exception {
        SevenZArchiveEntry entry1 = new SevenZArchiveEntry();
        entry1.setName("file1.txt");
        entry1.setLastModifiedDate(new Date());
        entry1.setHasLastModifiedDate(true);
        SevenZArchiveEntry entry2 = new SevenZArchiveEntry();
    }
}
