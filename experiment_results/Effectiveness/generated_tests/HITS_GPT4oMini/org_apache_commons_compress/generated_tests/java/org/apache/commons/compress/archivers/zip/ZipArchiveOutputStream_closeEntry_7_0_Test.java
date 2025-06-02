package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ZipArchiveOutputStream_closeEntry_7_0_Test extends ZipArchiveOutputStream {

    private ByteArrayOutputStream outputStream;

    public ZipArchiveOutputStream_closeEntry_7_0_Test() {
        super(new ByteArrayOutputStream());
        this.outputStream = (ByteArrayOutputStream) this.out;
    }

    @BeforeEach
    public void setUp() {
        this.outputStream.reset();
    }

    @Test
    public void testCloseEntry_WhenPhasedIsFalseAndActuallyNeedsZip64() throws IOException {
        setMethod(ZipArchiveOutputStream.DEFLATED);
        setEncoding("UTF-8");
        ZipArchiveEntry mockEntry = mock(ZipArchiveEntry.class);
        when(mockEntry.getMethod()).thenReturn(ZipArchiveOutputStream.DEFLATED);
        when(mockEntry.getCrc()).thenReturn(123456789L);
        when(mockEntry.getCompressedSize()).thenReturn(100L);
        when(mockEntry.getSize()).thenReturn(200L);
        setEntry(mockEntry);
        assertDoesNotThrow(() -> invokeCloseEntry(false, false));
    }

    @Test
    public void testCloseEntry_WhenPhasedIsTrue() throws IOException {
        setMethod(ZipArchiveOutputStream.DEFLATED);
        setEncoding("UTF-8");
        ZipArchiveEntry mockEntry = mock(ZipArchiveEntry.class);
        setEntry(mockEntry);
        assertDoesNotThrow(() -> invokeCloseEntry(false, true));
    }

    @Test
    public void testCloseEntry_WhenOutputIsRandomAccess() throws IOException {
        setMethod(ZipArchiveOutputStream.DEFLATED);
        setEncoding("UTF-8");
        ZipArchiveEntry mockEntry = mock(ZipArchiveEntry.class);
        setEntry(mockEntry);
        this.out = mock(RandomAccessOutputStream.class);
        assertDoesNotThrow(() -> invokeCloseEntry(true, false));
    }

    @Test
    public void testCloseEntry_WhenEntryIsNull() throws IOException {
        setEntry(null);
        assertDoesNotThrow(() -> invokeCloseEntry(false, false));
    }

    private void setEntry(ZipArchiveEntry entry) {
        try {
            Field field = ZipArchiveOutputStream.class.getDeclaredField("entry");
            field.setAccessible(true);
            field.set(this, entry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeCloseEntry(boolean actuallyNeedsZip64, boolean phased) throws Exception {
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("closeEntry", boolean.class, boolean.class);
        method.setAccessible(true);
        method.invoke(this, actuallyNeedsZip64, phased);
    }
}
