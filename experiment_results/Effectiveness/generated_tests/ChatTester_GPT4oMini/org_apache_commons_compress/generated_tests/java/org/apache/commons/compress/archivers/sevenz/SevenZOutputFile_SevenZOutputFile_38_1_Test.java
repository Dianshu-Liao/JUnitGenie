package org.apache.commons.compress.archivers.sevenz;

import java.io.File;
import java.io.IOException;
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

public class SevenZOutputFile_SevenZOutputFile_38_1_Test {

    private static final String TEST_FILE_PATH = "test.7z";

    private File testFile;

    private char[] password;

    @BeforeEach
    public void setUp() {
        testFile = new File(TEST_FILE_PATH);
        password = "testPassword".toCharArray();
    }

    @Test
    public void testConstructorWithFileAndPassword() {
        try {
            SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(testFile, password);
            assertNotNull(sevenZOutputFile);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    public void testConstructorWithNonExistentFile() {
        File nonExistentFile = new File("non_existent_file.7z");
        assertThrows(IOException.class, () -> {
            new SevenZOutputFile(nonExistentFile, password);
        });
    }

    @Test
    public void testConstructorWithNullPassword() {
        assertThrows(NullPointerException.class, () -> {
            new SevenZOutputFile(testFile, null);
        });
    }

    @Test
    public void testConstructorWithEmptyPassword() {
        char[] emptyPassword = new char[0];
        try {
            SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(testFile, emptyPassword);
            assertNotNull(sevenZOutputFile);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @AfterEach
    public void tearDown() {
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}
