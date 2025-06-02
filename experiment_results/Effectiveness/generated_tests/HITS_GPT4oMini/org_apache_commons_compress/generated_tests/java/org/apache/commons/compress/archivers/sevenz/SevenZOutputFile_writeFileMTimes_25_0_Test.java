package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class SevenZOutputFile_writeFileMTimes_25_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private DataOutput dataOutput;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        Path tempFile = Files.createTempFile("test", ".7z");
        SeekableByteChannel channel = Files.newByteChannel(tempFile);
        sevenZOutputFile = new SevenZOutputFile(channel);
        byteArrayOutputStream = new ByteArrayOutputStream();
        dataOutput = new DataOutputStream(byteArrayOutputStream);
    }

    @AfterEach
    public void tearDown() throws IOException {
        sevenZOutputFile.close();
        byteArrayOutputStream.close();
    }

    @Test
    public void testWriteFileMTimes_WithNoEntries() throws Exception {
        invokeWriteFileMTimes();
        assertEquals(0, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteFileMTimes_WithEntriesWithoutLastModifiedDate() throws Exception {
        SevenZArchiveEntry entry1 = new SevenZArchiveEntry();
        entry1.setName("file1.txt");
        entry1.setHasLastModifiedDate(false);
        SevenZArchiveEntry entry2 = new SevenZArchiveEntry();
        entry2.setName("file2.txt");
        entry2.setHasLastModifiedDate(false);
        addFileEntry(entry1);
        addFileEntry(entry2);
        invokeWriteFileMTimes();
        assertEquals(0, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteFileMTimes_WithEntriesWithLastModifiedDate() throws Exception {
        SevenZArchiveEntry entry1 = new SevenZArchiveEntry();
        entry1.setName("file1.txt");
        entry1.setLastModifiedDate(new Date());
        entry1.setHasLastModifiedDate(true);
        SevenZArchiveEntry entry2 = new SevenZArchiveEntry();
        entry2.setName("file2.txt");
        entry2.setLastModifiedDate(new Date());
        entry2.setHasLastModifiedDate(true);
        addFileEntry(entry1);
        addFileEntry(entry2);
        invokeWriteFileMTimes();
        assertTrue(byteArrayOutputStream.size() > 0);
    }

    private void invokeWriteFileMTimes() throws Exception {
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, dataOutput);
    }

    private void addFileEntry(SevenZArchiveEntry entry) throws Exception {
        // Use reflection to access the private 'files' list
        java.lang.reflect.Field field = SevenZOutputFile.class.getDeclaredField("files");
        field.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<SevenZArchiveEntry> files = (List<SevenZArchiveEntry>) field.get(sevenZOutputFile);
        files.add(entry);
    }
}
