package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.io.output.CountingOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
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
import java.util.ArrayList;
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

@ExtendWith(MockitoExtension.class)
class SevenZOutputFile_closeArchiveEntry_2_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private SeekableByteChannel mockChannel;

    private CountingOutputStream mockCountingOutputStream;

    private SevenZArchiveEntry mockEntry;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        mockChannel = mock(SeekableByteChannel.class);
        mockCountingOutputStream = mock(CountingOutputStream.class);
        mockEntry = mock(SevenZArchiveEntry.class);
        // Create an instance of SevenZOutputFile
        sevenZOutputFile = new SevenZOutputFile(mockChannel);
        Field filesField = SevenZOutputFile.class.getDeclaredField("files");
        filesField.setAccessible(true);
        ((List<SevenZArchiveEntry>) filesField.get(sevenZOutputFile)).add(mockEntry);
        Field currentOutputStreamField = SevenZOutputFile.class.getDeclaredField("currentOutputStream");
        currentOutputStreamField.setAccessible(true);
        currentOutputStreamField.set(sevenZOutputFile, mockCountingOutputStream);
        when(mockCountingOutputStream.getByteCount()).thenReturn(200L);
        Field fileBytesWrittenField = SevenZOutputFile.class.getDeclaredField("fileBytesWritten");
        fileBytesWrittenField.setAccessible(true);
        fileBytesWrittenField.setLong(sevenZOutputFile, 200L);
    }

    @Test
    void testCloseArchiveEntryWithNonEmptyStream() throws IOException, NoSuchFieldException, IllegalAccessException {
        when(mockCountingOutputStream.getByteCount()).thenReturn(150L);
        sevenZOutputFile.closeArchiveEntry();
        verify(mockCountingOutputStream).flush();
        verify(mockCountingOutputStream).close();
        verify(mockEntry).setHasStream(true);
        verify(mockEntry).setSize(150L);
        verify(mockEntry).setCompressedSize(200L);
        verify(mockEntry).setCrcValue(anyLong());
        verify(mockEntry).setCompressedCrcValue(anyLong());
        // Use reflection to access private fields
        Field additionalCountingStreamsField = SevenZOutputFile.class.getDeclaredField("additionalCountingStreams");
        additionalCountingStreamsField.setAccessible(true);
        Field currentOutputStreamField = SevenZOutputFile.class.getDeclaredField("currentOutputStream");
        currentOutputStreamField.setAccessible(true);
        assertNull(currentOutputStreamField.get(sevenZOutputFile));
        assertNull(additionalCountingStreamsField.get(sevenZOutputFile));
        Field fileBytesWrittenField = SevenZOutputFile.class.getDeclaredField("fileBytesWritten");
        fileBytesWrittenField.setAccessible(true);
        assertEquals(0, fileBytesWrittenField.getLong(sevenZOutputFile));
    }

    @Test
    void testCloseArchiveEntryWithEmptyStream() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Simulate no bytes written
        Field fileBytesWrittenField = SevenZOutputFile.class.getDeclaredField("fileBytesWritten");
        fileBytesWrittenField.setAccessible(true);
        fileBytesWrittenField.setLong(sevenZOutputFile, 0);
        sevenZOutputFile.closeArchiveEntry();
        verify(mockCountingOutputStream, never()).flush();
        verify(mockCountingOutputStream, never()).close();
        verify(mockEntry).setHasStream(false);
        verify(mockEntry).setSize(0);
        verify(mockEntry).setCompressedSize(0);
        verify(mockEntry).setHasCrc(false);
        Field currentOutputStreamField = SevenZOutputFile.class.getDeclaredField("currentOutputStream");
        currentOutputStreamField.setAccessible(true);
        assertNull(currentOutputStreamField.get(sevenZOutputFile));
    }
}
