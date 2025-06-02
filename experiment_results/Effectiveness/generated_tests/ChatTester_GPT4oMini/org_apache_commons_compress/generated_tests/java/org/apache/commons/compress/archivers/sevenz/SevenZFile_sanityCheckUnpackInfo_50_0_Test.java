package org.apache.commons.compress.archivers.sevenz;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.build.AbstractOrigin.ByteArrayOrigin;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.input.ChecksumInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SevenZFile_sanityCheckUnpackInfo_50_0_Test {

    private SevenZFile sevenZFile;

    private ByteBuffer header;

    private ArchiveStatistics stats;

    private static final class ArchiveStatistics {

        int numberOfFolders;

        int numberOfOutStreams;

        int numberOfInStreams;

        int numberOfPackedStreams;
    }

    @BeforeEach
    void setUp() throws IOException {
        sevenZFile = new SevenZFile(new File("dummy.7z"));
        stats = new ArchiveStatistics();
        header = ByteBuffer.allocate(1024);
    }

    @Test
    void testSanityCheckUnpackInfo_ValidInput() throws Exception {
        header.put((byte) NID.kFolder);
        header.putLong(1);
        header.put((byte) 0);
        header.put((byte) NID.kCodersUnpackSize);
        header.putLong(100);
        header.put((byte) NID.kEnd);
        header.flip();
        invokeSanityCheckUnpackInfo(header, stats);
        assertEquals(1, stats.numberOfFolders);
    }

    @Test
    void testSanityCheckUnpackInfo_InvalidNIDForFolder() throws Exception {
        header.put((byte) 0);
        header.flip();
        IOException thrown = assertThrows(IOException.class, () -> {
            invokeSanityCheckUnpackInfo(header, stats);
        });
        assertEquals("Expected kFolder, got 0", thrown.getMessage());
    }

    @Test
    void testSanityCheckUnpackInfo_ExternalUnsupported() throws Exception {
        header.put((byte) NID.kFolder);
        header.putLong(1);
        header.put((byte) 1);
        header.flip();
        IOException thrown = assertThrows(IOException.class, () -> {
            invokeSanityCheckUnpackInfo(header, stats);
        });
        assertEquals("External unsupported", thrown.getMessage());
    }

    @Test
    void testSanityCheckUnpackInfo_NotEnoughPackedStreams() throws Exception {
        header.put((byte) NID.kFolder);
        header.putLong(1);
        header.put((byte) 0);
        header.put((byte) NID.kCodersUnpackSize);
        header.putLong(50);
        header.put((byte) NID.kEnd);
        header.flip();
        stats.numberOfOutStreams = 1;
        stats.numberOfInStreams = 0;
        stats.numberOfPackedStreams = 1;
        IOException thrown = assertThrows(IOException.class, () -> {
            invokeSanityCheckUnpackInfo(header, stats);
        });
        assertEquals("archive doesn't contain enough packed streams", thrown.getMessage());
    }

    private void invokeSanityCheckUnpackInfo(ByteBuffer header, ArchiveStatistics stats) throws Exception {
        Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, ArchiveStatistics.class);
        method.setAccessible(true);
        method.invoke(sevenZFile, header, stats);
    }
}
