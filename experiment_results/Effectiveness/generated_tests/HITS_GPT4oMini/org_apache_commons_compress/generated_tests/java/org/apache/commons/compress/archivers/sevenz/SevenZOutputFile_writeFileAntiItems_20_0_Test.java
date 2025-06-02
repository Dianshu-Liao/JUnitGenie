package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.BitSet;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.channels.SeekableByteChannel;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.Closeable;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.zip.CRC32;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SevenZOutputFile_writeFileAntiItems_20_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private DataOutput mockDataOutput;

    private SevenZArchiveEntry entry1;

    private SevenZArchiveEntry entry2;

    @BeforeEach
    public void setUp() throws IOException {
        mockDataOutput = mock(DataOutput.class);
        sevenZOutputFile = new SevenZOutputFile(mock(SeekableByteChannel.class));
        entry1 = new SevenZArchiveEntry();
        entry1.setAntiItem(true);
        entry1.setHasStream(false);
        entry2 = new SevenZArchiveEntry();
        entry2.setAntiItem(false);
        entry2.setHasStream(false);
        addEntryToFileList(sevenZOutputFile, entry1);
        addEntryToFileList(sevenZOutputFile, entry2);
    }

    private void addEntryToFileList(SevenZOutputFile sevenZOutputFile, SevenZArchiveEntry entry) {
        try {
            java.lang.reflect.Field field = SevenZOutputFile.class.getDeclaredField("files");
            field.setAccessible(true);
            @SuppressWarnings("unchecked")
            List<SevenZArchiveEntry> files = (List<SevenZArchiveEntry>) field.get(sevenZOutputFile);
            files.add(entry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeWriteFileAntiItems() throws Exception {
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileAntiItems", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, mockDataOutput);
    }

    @Test
    public void testWriteFileAntiItems_withAntiItems() throws Exception {
        invokeWriteFileAntiItems();
        verify(mockDataOutput).write(NID.kAnti);
        verify(mockDataOutput, times(1)).write(any(byte[].class));
        verify(mockDataOutput, times(1)).writeLong(anyLong());
    }

    @Test
    public void testWriteFileAntiItems_withoutAntiItems() throws Exception {
        entry1.setHasStream(true);
        sevenZOutputFile = new SevenZOutputFile(mock(SeekableByteChannel.class));
        addEntryToFileList(sevenZOutputFile, entry1);
        addEntryToFileList(sevenZOutputFile, entry2);
        invokeWriteFileAntiItems();
    }
}
