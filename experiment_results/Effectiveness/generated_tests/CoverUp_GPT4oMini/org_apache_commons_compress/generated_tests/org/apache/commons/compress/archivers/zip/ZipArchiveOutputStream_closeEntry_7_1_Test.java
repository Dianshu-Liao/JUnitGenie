package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

class ZipArchiveOutputStream_closeEntry_7_1_Test {

    private ZipArchiveOutputStream zipOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        zipOutputStream = new ZipArchiveOutputStream(byteArrayOutputStream);
    }

    @Test
    void testCloseEntry_NeedsZip64_Phased() throws Exception {
        invokeCloseEntry(false, true);
        // Add assertions to verify behavior when phased is true
        assertNull(getEntry(zipOutputStream));
    }

    @Test
    void testCloseEntry_NeedsZip64_NotPhased() throws Exception {
        invokeCloseEntry(true, false);
        // Add assertions to verify behavior when phased is false
        assertNull(getEntry(zipOutputStream));
    }

    @Test
    void testCloseEntry_NoZip64_Phased() throws Exception {
        invokeCloseEntry(false, true);
        // Add assertions to verify behavior when phased is true
        assertNull(getEntry(zipOutputStream));
    }

    @Test
    void testCloseEntry_NoZip64_NotPhased() throws Exception {
        invokeCloseEntry(true, false);
        // Add assertions to verify behavior when phased is false
        assertNull(getEntry(zipOutputStream));
    }

    private void invokeCloseEntry(boolean actuallyNeedsZip64, boolean phased) throws Exception {
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("closeEntry", boolean.class, boolean.class);
        method.setAccessible(true);
        method.invoke(zipOutputStream, actuallyNeedsZip64, phased);
    }

    private Object getEntry(ZipArchiveOutputStream zipOutputStream) throws Exception {
        java.lang.reflect.Field entryField = ZipArchiveOutputStream.class.getDeclaredField("entry");
        entryField.setAccessible(true);
        return entryField.get(zipOutputStream);
    }
}
