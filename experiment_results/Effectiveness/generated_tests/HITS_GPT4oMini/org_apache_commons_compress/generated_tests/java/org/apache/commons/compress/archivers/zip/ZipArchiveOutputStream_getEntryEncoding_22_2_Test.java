package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.Charsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ZipArchiveOutputStream_getEntryEncoding_22_2_Test {

    private ZipArchiveOutputStream zipOutputStream;

    @BeforeEach
    public void setUp() {
        zipOutputStream = new ZipArchiveOutputStream(new ByteArrayOutputStream());
    }

    @Test
    public void testGetEntryEncoding_withEncodableName() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        zipOutputStream.setEncoding(StandardCharsets.UTF_8.name());
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("getEntryEncoding", ZipArchiveEntry.class);
        method.setAccessible(true);
        ZipEncoding result = (ZipEncoding) method.invoke(zipOutputStream, entry);
        assertNotNull(result);
        assertEquals(StandardCharsets.UTF_8.name(), zipOutputStream.getEncoding());
    }

    @Test
    public void testGetEntryEncoding_withNonEncodableNameAndFallbackToUtf8() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("non-encodable-name-€");
        zipOutputStream.setEncoding(StandardCharsets.ISO_8859_1.name());
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("getEntryEncoding", ZipArchiveEntry.class);
        method.setAccessible(true);
        ZipEncoding result = (ZipEncoding) method.invoke(zipOutputStream, entry);
        assertNotNull(result);
        assertEquals(StandardCharsets.UTF_8.name(), zipOutputStream.getEncoding());
    }

    @Test
    public void testGetEntryEncoding_withNonEncodableNameWithoutFallback() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("non-encodable-name-€");
        zipOutputStream.setEncoding(StandardCharsets.ISO_8859_1.name());
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("getEntryEncoding", ZipArchiveEntry.class);
        method.setAccessible(true);
        ZipEncoding result = (ZipEncoding) method.invoke(zipOutputStream, entry);
        assertNotNull(result);
        assertEquals(StandardCharsets.ISO_8859_1.name(), zipOutputStream.getEncoding());
    }

    @Test
    public void testGetEntryEncoding_withEmptyName() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("");
        zipOutputStream.setEncoding(StandardCharsets.UTF_8.name());
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("getEntryEncoding", ZipArchiveEntry.class);
        method.setAccessible(true);
        ZipEncoding result = (ZipEncoding) method.invoke(zipOutputStream, entry);
        assertNotNull(result);
        assertEquals(StandardCharsets.UTF_8.name(), zipOutputStream.getEncoding());
    }

    @Test
    public void testGetEntryEncoding_withNullEntry() throws Exception {
        ZipArchiveEntry entry = null;
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("getEntryEncoding", ZipArchiveEntry.class);
    }
}
