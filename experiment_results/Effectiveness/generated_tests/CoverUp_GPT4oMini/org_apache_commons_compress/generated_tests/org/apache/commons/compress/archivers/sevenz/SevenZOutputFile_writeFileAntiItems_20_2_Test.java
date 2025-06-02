package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
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

public class SevenZOutputFile_writeFileAntiItems_20_2_Test {

    private SevenZOutputFile sevenZOutputFile;

    @BeforeEach
    public void setUp() throws IOException {
        Path tempFile = Files.createTempFile("test", ".7z");
        SeekableByteChannel channel = Files.newByteChannel(tempFile);
        sevenZOutputFile = new SevenZOutputFile(channel);
    }

    @Test
    public void testWriteFileAntiItems_WithNoAntiItems() throws Exception {
        // Arrange
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream header = new DataOutputStream(baos);
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        entry.setHasStream(true);
        addFileEntry(sevenZOutputFile, entry);
        // Act
        invokeWriteFileAntiItems(sevenZOutputFile, header);
        // Assert
        assertArrayEquals(new byte[0], baos.toByteArray());
    }

    @Test
    public void testWriteFileAntiItems_WithAntiItems() throws Exception {
        // Arrange
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream header = new DataOutputStream(baos);
        SevenZArchiveEntry entry1 = new SevenZArchiveEntry();
        entry1.setHasStream(false);
        entry1.setAntiItem(true);
        SevenZArchiveEntry entry2 = new SevenZArchiveEntry();
        entry2.setHasStream(false);
        entry2.setAntiItem(false);
        addFileEntry(sevenZOutputFile, entry1);
        addFileEntry(sevenZOutputFile, entry2);
        // Act
        invokeWriteFileAntiItems(sevenZOutputFile, header);
        // Assert
        byte[] expected = { NID.kAnti, 0x01, 0x00 };
        assertArrayEquals(expected, baos.toByteArray());
    }

    @Test
    public void testWriteFileAntiItems_WithEmptyFilesList() throws Exception {
        // Arrange
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream header = new DataOutputStream(baos);
        // Act & Assert
        assertThrows(IOException.class, () -> {
            invokeWriteFileAntiItems(sevenZOutputFile, header);
        });
    }

    private void addFileEntry(SevenZOutputFile sevenZOutputFile, SevenZArchiveEntry entry) throws Exception {
        Field filesField = SevenZOutputFile.class.getDeclaredField("files");
        filesField.setAccessible(true);
        ((List<SevenZArchiveEntry>) filesField.get(sevenZOutputFile)).add(entry);
    }

    private void invokeWriteFileAntiItems(SevenZOutputFile sevenZOutputFile, DataOutput header) throws Exception {
        Method writeFileAntiItemsMethod = SevenZOutputFile.class.getDeclaredMethod("writeFileAntiItems", DataOutput.class);
        writeFileAntiItemsMethod.setAccessible(true);
        writeFileAntiItemsMethod.invoke(sevenZOutputFile, header);
    }
}
