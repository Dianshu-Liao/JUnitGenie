// Test method
package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ZipArchiveOutputStream_flushDeflater_18_0_Test {

    private ZipArchiveOutputStream zipArchiveOutputStream;

    private ZipArchiveEntry mockEntry;

    private StreamCompressor mockStreamCompressor;

    @BeforeEach
    void setUp() throws IOException {
        mockEntry = Mockito.mock(ZipArchiveEntry.class);
        mockStreamCompressor = Mockito.mock(StreamCompressor.class);
        zipArchiveOutputStream = Mockito.spy(new ZipArchiveOutputStream(Mockito.mock(OutputStream.class)));
        // Fixed line: Catching the exception
        try {
            setPrivateField(zipArchiveOutputStream, "streamCompressor", mockStreamCompressor);
            setPrivateField(zipArchiveOutputStream, "entry", mockEntry);
        } catch (Exception e) {
            throw new IOException("Failed to set private fields", e);
        }
    }

    @Test
    void testFlushDeflater_WhenEntryMethodIsDeflated_ShouldCallFlushDeflater() throws Exception {
        // Arrange
        when(mockEntry.getMethod()).thenReturn(ZipArchiveOutputStream.DEFLATED);
        // Act
        invokeFlushDeflater();
        // Assert
        verify(mockStreamCompressor).flushDeflater();
    }

    @Test
    void testFlushDeflater_WhenEntryMethodIsNotDeflated_ShouldNotCallFlushDeflater() throws Exception {
        // Arrange
        when(mockEntry.getMethod()).thenReturn(ZipArchiveOutputStream.STORED);
        // Act
        invokeFlushDeflater();
        // Assert
        verify(mockStreamCompressor, never()).flushDeflater();
    }

    private void invokeFlushDeflater() throws Exception {
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("flushDeflater");
        method.setAccessible(true);
        method.invoke(zipArchiveOutputStream);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
