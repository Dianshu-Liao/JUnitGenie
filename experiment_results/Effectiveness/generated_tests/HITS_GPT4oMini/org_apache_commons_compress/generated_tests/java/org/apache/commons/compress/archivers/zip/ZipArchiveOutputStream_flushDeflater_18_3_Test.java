package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.zip.Deflater;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.Charsets;

@ExtendWith(MockitoExtension.class)
public class ZipArchiveOutputStream_flushDeflater_18_3_Test {

    private ZipArchiveOutputStream zipArchiveOutputStream;

    private ZipArchiveEntry entry;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
        entry = mock(ZipArchiveEntry.class);
    }

    @Test
    public void testFlushDeflaterWhenEntryMethodIsDeflated() throws Exception {
        // Arrange
        when(entry.getMethod()).thenReturn(ZipArchiveOutputStream.DEFLATED);
        setCurrentEntry(zipArchiveOutputStream, entry);
        // Act & Assert
        assertDoesNotThrow(() -> invokeFlushDeflater(zipArchiveOutputStream));
    }

    @Test
    public void testFlushDeflaterWhenEntryMethodIsNotDeflated() throws Exception {
        // Arrange
        when(entry.getMethod()).thenReturn(ZipArchiveOutputStream.STORED);
        setCurrentEntry(zipArchiveOutputStream, entry);
        // Act & Assert
        assertDoesNotThrow(() -> invokeFlushDeflater(zipArchiveOutputStream));
    }

    private void setCurrentEntry(ZipArchiveOutputStream zipOutputStream, ZipArchiveEntry entry) throws Exception {
        Field entryField = ZipArchiveOutputStream.class.getDeclaredField("entry");
        entryField.setAccessible(true);
        entryField.set(zipOutputStream, entry);
    }

    private void invokeFlushDeflater(ZipArchiveOutputStream zipOutputStream) throws Exception {
        // Use reflection to access the private flushDeflater method
        java.lang.reflect.Method method = ZipArchiveOutputStream.class.getDeclaredMethod("flushDeflater");
        method.setAccessible(true);
        method.invoke(zipOutputStream);
    }
}
