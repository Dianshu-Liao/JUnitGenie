package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
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
import org.apache.commons.io.output.CountingOutputStream;

public class SevenZOutputFile_write_16_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private File tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        tempFile = File.createTempFile("test", ".7z");
        tempFile.deleteOnExit();
        sevenZOutputFile = new SevenZOutputFile(FileChannel.open(tempFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE));
    }

    @AfterEach
    public void tearDown() throws IOException {
        if (sevenZOutputFile != null) {
            sevenZOutputFile.close();
        }
    }

    @Test
    public void testWriteSingleStream() throws Exception {
        String data = "Hello, SevenZ!";
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        invokeWriteMethod(inputStream);
        assertTrue(tempFile.length() > 0);
    }

    @Test
    public void testWriteEmptyStream() throws Exception {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        invokeWriteMethod(inputStream);
        assertEquals(0, tempFile.length());
    }

    @Test
    public void testWriteNullStream() {
        assertThrows(NullPointerException.class, () -> {
            invokeWriteMethod(null);
        });
    }

    @Test
    public void testWriteLargeData() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("This is a test line.\n");
        }
        InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes());
        invokeWriteMethod(inputStream);
        assertTrue(tempFile.length() > 0);
    }

    private void invokeWriteMethod(InputStream inputStream) throws Exception {
        Method writeMethod = SevenZOutputFile.class.getDeclaredMethod("write", InputStream.class);
        writeMethod.setAccessible(true);
        writeMethod.invoke(sevenZOutputFile, inputStream);
    }
}
