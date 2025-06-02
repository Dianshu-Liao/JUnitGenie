package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class ZipArchiveOutputStream_getEntryEncoding_22_0_Test {

    private ZipArchiveOutputStream zipOutputStream;

    @BeforeEach
    public void setUp() {
        zipOutputStream = new ZipArchiveOutputStream(new ByteArrayOutputStream());
    }

    private ZipEncoding invokeGetEntryEncoding(ZipArchiveOutputStream zipOutputStream, ZipArchiveEntry zipEntry) throws Exception {
        Field field = ZipArchiveOutputStream.class.getDeclaredField("fallbackToUtf8");
        field.setAccessible(true);
        return (ZipEncoding) ZipArchiveOutputStream.class.getDeclaredMethod("getEntryEncoding", ZipArchiveEntry.class).invoke(zipOutputStream, zipEntry);
    }

    @Test
    public void testGetEntryEncoding_EncodableName_ReturnsDefaultEncoding() throws Exception {
        ZipArchiveEntry zipEntry = new ZipArchiveEntry("test.txt");
        ZipEncoding encoding = invokeGetEntryEncoding(zipOutputStream, zipEntry);
        assertEquals(ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8), encoding);
    }

    @Test
    public void testGetEntryEncoding_NonEncodableNameWithFallback_ReturnsUtf8Encoding() throws Exception {
        ZipArchiveEntry zipEntry = new ZipArchiveEntry("non-encodable-€-name.txt");
        Field field = ZipArchiveOutputStream.class.getDeclaredField("fallbackToUtf8");
        field.setAccessible(true);
        field.set(zipOutputStream, true);
        ZipEncoding encoding = invokeGetEntryEncoding(zipOutputStream, zipEntry);
        assertEquals(ZipEncodingHelper.ZIP_ENCODING_UTF_8, encoding);
    }

    @Test
    public void testGetEntryEncoding_NonEncodableNameWithoutFallback_ReturnsCurrentEncoding() throws Exception {
        ZipArchiveEntry zipEntry = new ZipArchiveEntry("non-encodable-€-name.txt");
        Field field = ZipArchiveOutputStream.class.getDeclaredField("fallbackToUtf8");
        field.setAccessible(true);
        field.set(zipOutputStream, false);
        ZipEncoding encoding = invokeGetEntryEncoding(zipOutputStream, zipEntry);
        assertEquals(ZipEncodingHelper.getZipEncoding(StandardCharsets.ISO_8859_1), encoding);
    }

    @Test
    public void testGetEntryEncoding_EmptyName_ReturnsDefaultEncoding() throws Exception {
        ZipArchiveEntry zipEntry = new ZipArchiveEntry("");
        ZipEncoding encoding = invokeGetEntryEncoding(zipOutputStream, zipEntry);
        assertEquals(ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8), encoding);
    }
}
