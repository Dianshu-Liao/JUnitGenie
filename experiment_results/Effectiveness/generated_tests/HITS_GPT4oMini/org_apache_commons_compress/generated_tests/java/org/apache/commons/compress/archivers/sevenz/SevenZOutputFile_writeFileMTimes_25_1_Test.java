package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.lang.reflect.Method;
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

public class SevenZOutputFile_writeFileMTimes_25_1_Test {

    private SevenZOutputFile sevenZOutputFile;

    private ByteArrayOutputStream byteArrayOutputStream;

    private DataOutput dataOutput;

    @BeforeEach
    public void setUp() throws IOException {
        Path tempFile = Files.createTempFile("test", ".7z");
        SeekableByteChannel channel = Files.newByteChannel(tempFile);
        sevenZOutputFile = new SevenZOutputFile(channel);
        byteArrayOutputStream = new ByteArrayOutputStream();
        dataOutput = new DataOutputStream(byteArrayOutputStream);
    }

    @Test
    public void testWriteFileMTimes_NoEntries() throws Exception {
        invokeWriteFileMTimes();
        byte[] expectedOutput = new byte[] {};
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testWriteFileMTimes_OneEntryWithoutLastModifiedDate() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        entry.setName("file1.txt");
        entry.setHasLastModifiedDate(false);
        setEntry(entry);
        invokeWriteFileMTimes();
        byte[] expectedOutput = new byte[] { 0 };
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testWriteFileMTimes_OneEntryWithLastModifiedDate() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        entry.setName("file1.txt");
        entry.setHasLastModifiedDate(true);
        entry.setLastModifiedDate(new Date(1625097600000L));
        setEntry(entry);
        invokeWriteFileMTimes();
        byte[] expectedOutput = new byte[] { NID.kMTime, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }

    private void setEntry(SevenZArchiveEntry entry) throws Exception {
        // Use reflection to access the private files list and add the entry
        Method method = SevenZOutputFile.class.getDeclaredMethod("addFile", SevenZArchiveEntry.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, entry);
    }

    private void invokeWriteFileMTimes() throws Exception {
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, dataOutput);
    }
}
