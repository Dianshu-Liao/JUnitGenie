package org.apache.commons.compress.archivers.sevenz;

import java.io.DataOutput;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
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

public class SevenZOutputFile_writeFileMTimes_25_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private DataOutput header;

    private List<SevenZArchiveEntry> entries;

    @BeforeEach
    public void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        SeekableByteChannel channel = mock(SeekableByteChannel.class);
        sevenZOutputFile = new SevenZOutputFile(channel);
        entries = new ArrayList<>();
        java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
        filesField.setAccessible(true);
        ((List<SevenZArchiveEntry>) filesField.get(sevenZOutputFile)).addAll(entries);
        header = mock(DataOutput.class);
    }

    @Test
    public void testWriteFileMTimes_NoEntries() throws Exception {
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, header);
        verify(header, never()).write(any());
    }

    @Test
    public void testWriteFileMTimes_EntriesWithoutLastModifiedDate() throws Exception {
        SevenZArchiveEntry entry1 = mock(SevenZArchiveEntry.class);
        when(entry1.getHasLastModifiedDate()).thenReturn(false);
        entries.add(entry1);
        SevenZArchiveEntry entry2 = mock(SevenZArchiveEntry.class);
        when(entry2.getHasLastModifiedDate()).thenReturn(false);
        entries.add(entry2);
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, header);
        verify(header, never()).write(any());
    }

    @Test
    public void testWriteFileMTimes_EntriesWithLastModifiedDate() throws Exception {
        SevenZArchiveEntry entry1 = mock(SevenZArchiveEntry.class);
        when(entry1.getHasLastModifiedDate()).thenReturn(true);
        when(entry1.getLastModifiedTime()).thenReturn(java.nio.file.attribute.FileTime.fromMillis(1620000000000L));
        entries.add(entry1);
        SevenZArchiveEntry entry2 = mock(SevenZArchiveEntry.class);
        when(entry2.getHasLastModifiedDate()).thenReturn(true);
        when(entry2.getLastModifiedTime()).thenReturn(java.nio.file.attribute.FileTime.fromMillis(1620000001000L));
        entries.add(entry2);
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, header);
        verify(header).write(NID.kMTime);
        verify(header).write(2);
        verify(header).writeLong(Long.reverseBytes(1620000000000L));
        verify(header).writeLong(Long.reverseBytes(1620000001000L));
    }

    @Test
    public void testWriteFileMTimes_PartialLastModifiedDates() throws Exception {
        SevenZArchiveEntry entry1 = mock(SevenZArchiveEntry.class);
        when(entry1.getHasLastModifiedDate()).thenReturn(true);
        when(entry1.getLastModifiedTime()).thenReturn(java.nio.file.attribute.FileTime.fromMillis(1620000000000L));
        entries.add(entry1);
        SevenZArchiveEntry entry2 = mock(SevenZArchiveEntry.class);
    }
}
