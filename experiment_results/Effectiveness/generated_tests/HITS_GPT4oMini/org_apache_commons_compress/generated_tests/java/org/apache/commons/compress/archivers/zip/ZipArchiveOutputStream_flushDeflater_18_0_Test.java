package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.Charsets;

@ExtendWith(MockitoExtension.class)
public class ZipArchiveOutputStream_flushDeflater_18_0_Test {

    private ZipArchiveOutputStream zipArchiveOutputStream;

    private ZipArchiveEntry mockEntry;

    @BeforeEach
    public void setUp() throws IOException {
        mockEntry = mock(ZipArchiveEntry.class);
        zipArchiveOutputStream = new ZipArchiveOutputStream(new ByteArrayOutputStream());
        setField(zipArchiveOutputStream, "entry", mockEntry);
        StreamCompressor mockStreamCompressor = mock(StreamCompressor.class);
        setField(zipArchiveOutputStream, "streamCompressor", mockStreamCompressor);
    }

    private void setField(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFlushDeflater_WhenMethodIsDeflated_ShouldCallFlushDeflater() throws Exception {
        when(mockEntry.getMethod()).thenReturn(ZipArchiveOutputStream.DEFLATED);
        invokeFlushDeflater();
        StreamCompressor streamCompressor = (StreamCompressor) getField(zipArchiveOutputStream, "streamCompressor");
        verify(streamCompressor, times(1)).flushDeflater();
    }

    @Test
    public void testFlushDeflater_WhenMethodIsNotDeflated_ShouldNotCallFlushDeflater() throws Exception {
        when(mockEntry.getMethod()).thenReturn(ZipArchiveOutputStream.STORED);
        invokeFlushDeflater();
        StreamCompressor streamCompressor = (StreamCompressor) getField(zipArchiveOutputStream, "streamCompressor");
        verify(streamCompressor, never()).flushDeflater();
    }

    private void invokeFlushDeflater() throws Exception {
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("flushDeflater");
        method.setAccessible(true);
        method.invoke(zipArchiveOutputStream);
    }

    private Object getField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
