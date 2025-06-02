package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.nio.channels.SeekableByteChannel;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;

class SevenZOutputFile_writeFileAntiItems_20_3_Test {

    private SevenZOutputFile sevenZOutputFile;

    private ByteArrayOutputStream byteArrayOutputStream;

    private DataOutput dataOutput;

    @BeforeEach
    void setUp() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        SeekableByteChannel channel = Mockito.mock(SeekableByteChannel.class);
        sevenZOutputFile = new SevenZOutputFile(channel);
        dataOutput = new DataOutputStream(byteArrayOutputStream);
    }

    private void addEntry(SevenZArchiveEntry entry) throws Exception {
        // Use reflection to add the entry to the internal files list
        Field filesField = SevenZOutputFile.class.getDeclaredField("files");
        filesField.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<SevenZArchiveEntry> files = (List<SevenZArchiveEntry>) filesField.get(sevenZOutputFile);
        files.add(entry);
    }

    private void invokeWriteFileAntiItems() throws Exception {
        // Use reflection to invoke the private method writeFileAntiItems
        Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileAntiItems", DataOutput.class);
        method.setAccessible(true);
        method.invoke(sevenZOutputFile, dataOutput);
    }

    @Test
    void testWriteFileAntiItems_NoAntiItems() throws IOException, Exception {
        SevenZArchiveEntry entry1 = new SevenZArchiveEntry();
        entry1.setHasStream(true);
        addEntry(entry1);
        invokeWriteFileAntiItems();
        assertEquals(0, byteArrayOutputStream.size());
    }
}
