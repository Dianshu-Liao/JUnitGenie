package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import org.apache.commons.io.output.CountingOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
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

public class SevenZOutputFile_write_17_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private ByteArrayOutputStream byteArrayOutputStream;

    private CountingOutputStream countingOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        countingOutputStream = new CountingOutputStream(byteArrayOutputStream);
        SeekableByteChannel channel = Files.newByteChannel(new File("test.7z").toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        sevenZOutputFile = new SevenZOutputFile(channel);
    }

    @AfterEach
    public void tearDown() throws IOException {
        sevenZOutputFile.close();
        byteArrayOutputStream.close();
    }

    @Test
    public void testWriteSingleByte() throws IOException {
        // ASCII for 'A'
        int byteToWrite = 65;
        sevenZOutputFile.write(byteToWrite);
        assertEquals(1, countingOutputStream.getCount());
        assertEquals('A', byteArrayOutputStream.toByteArray()[0]);
    }

    @Test
    public void testWriteMultipleBytes() throws IOException {
        // ASCII for 'A', 'B', 'C'
        int[] bytesToWrite = { 65, 66, 67 };
        for (int b : bytesToWrite) {
            sevenZOutputFile.write(b);
        }
        assertEquals(3, countingOutputStream.getCount());
        byte[] writtenBytes = byteArrayOutputStream.toByteArray();
        assertEquals('A', writtenBytes[0]);
        assertEquals('B', writtenBytes[1]);
        assertEquals('C', writtenBytes[2]);
    }

    @Test
    public void testWriteThrowsIOExceptionWhenClosed() throws IOException {
        sevenZOutputFile.close();
        assertThrows(IOException.class, () -> {
            // Attempt to write after closing
            sevenZOutputFile.write(65);
        });
    }

    @Test
    public void testWriteHandlesZeroByte() throws IOException {
        // Write a zero byte
        sevenZOutputFile.write(0);
        assertEquals(1, countingOutputStream.getCount());
        assertEquals(0, byteArrayOutputStream.toByteArray()[0]);
    }
}
