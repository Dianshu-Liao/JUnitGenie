package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
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

class SevenZOutputFile_writeFileWindowsAttributes_28_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private DataOutput mockDataOutput;

    private SevenZArchiveEntry entryWithAttributes;

    private SevenZArchiveEntry entryWithoutAttributes;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        sevenZOutputFile = new SevenZOutputFile(mock(File.class));
        mockDataOutput = mock(DataOutput.class);
        entryWithAttributes = new SevenZArchiveEntry();
        entryWithAttributes.setHasWindowsAttributes(true);
        entryWithAttributes.setWindowsAttributes(0x20);
        entryWithoutAttributes = new SevenZArchiveEntry();
        entryWithoutAttributes.setHasWindowsAttributes(false);
        // Use reflection to access the private 'files' field
        Field filesField = SevenZOutputFile.class.getDeclaredField("files");
        filesField.setAccessible(true);
        List<SevenZArchiveEntry> entries = new ArrayList<>();
        entries.add(entryWithAttributes);
        entries.add(entryWithoutAttributes);
        filesField.set(sevenZOutputFile, entries);
    }

    @Test
    void testWriteFileWindowsAttributes_WithAttributes() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(baos);
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileWindowsAttributes", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, dataOutputStream);
        verify(mockDataOutput).write(NID.kWinAttributes);
        verify(mockDataOutput).write(1);
        verify(mockDataOutput).writeInt(Integer.reverseBytes(entryWithAttributes.getWindowsAttributes()));
        byte[] writtenBytes = baos.toByteArray();
        assertTrue(writtenBytes.length > 0);
    }

    @Test
    void testWriteFileWindowsAttributes_NoAttributes() throws Exception {
        Field filesField = SevenZOutputFile.class.getDeclaredField("files");
        filesField.setAccessible(true);
        List<SevenZArchiveEntry> entries = new ArrayList<>();
        entries.add(entryWithoutAttributes);
        filesField.set(sevenZOutputFile, entries);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(baos);
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileWindowsAttributes", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, dataOutputStream);
        verify(mockDataOutput).write(NID.kWinAttributes);
        verify(mockDataOutput).write(0);
        verify(mockDataOutput, never()).writeInt(anyInt());
        byte[] writtenBytes = baos.toByteArray();
        assertTrue(writtenBytes.length > 0);
    }
}
