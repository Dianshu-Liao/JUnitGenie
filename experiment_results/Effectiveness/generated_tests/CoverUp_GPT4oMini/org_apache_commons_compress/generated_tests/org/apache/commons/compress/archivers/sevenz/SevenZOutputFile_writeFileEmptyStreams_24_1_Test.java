package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.lang.reflect.Field;
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
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
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
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;

class SevenZOutputFile_writeFileEmptyStreams_24_1_Test {

    private SevenZOutputFile sevenZOutputFile;

    private ByteArrayOutputStream byteArrayOutputStream;

    private DataOutput dataOutput;

    @BeforeEach
    void setUp() throws IOException {
        Path tempFile = Files.createTempFile("test", ".7z");
        SeekableByteChannel channel = Files.newByteChannel(tempFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        sevenZOutputFile = new SevenZOutputFile(channel);
        byteArrayOutputStream = new ByteArrayOutputStream();
        dataOutput = new DataOutputStream(byteArrayOutputStream);
    }

    @Test
    void testWriteFileEmptyStreams_NoEmptyStreams() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Given: A SevenZOutputFile with no empty streams
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        entry.setHasStream(true);
        addEntryToFiles(sevenZOutputFile, entry);
        // When: writeFileEmptyStreams is called
        invokeWriteFileEmptyStreams(sevenZOutputFile, dataOutput);
        // Then: No data should be written to the output
        assertEquals(0, byteArrayOutputStream.size());
    }

    @Test
    void testWriteFileEmptyStreams_WithEmptyStreams() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Given: A SevenZOutputFile with empty streams
        SevenZArchiveEntry entry1 = new SevenZArchiveEntry();
        entry1.setHasStream(false);
        SevenZArchiveEntry entry2 = new SevenZArchiveEntry();
        entry2.setHasStream(false);
        addEntryToFiles(sevenZOutputFile, entry1);
        addEntryToFiles(sevenZOutputFile, entry2);
        // When: writeFileEmptyStreams is called
        invokeWriteFileEmptyStreams(sevenZOutputFile, dataOutput);
        // Then: Data should be written to the output
        assertTrue(byteArrayOutputStream.size() > 0);
    }

    private void invokeWriteFileEmptyStreams(SevenZOutputFile sevenZOutputFile, DataOutput header) throws IOException {
        try {
            java.lang.reflect.Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileEmptyStreams", DataOutput.class);
            method.setAccessible(true);
            method.invoke(sevenZOutputFile, header);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void addEntryToFiles(SevenZOutputFile sevenZOutputFile, SevenZArchiveEntry entry) throws NoSuchFieldException, IllegalAccessException {
        Field field = SevenZOutputFile.class.getDeclaredField("files");
        field.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<SevenZArchiveEntry> files = (List<SevenZArchiveEntry>) field.get(sevenZOutputFile);
        files.add(entry);
    }
}
