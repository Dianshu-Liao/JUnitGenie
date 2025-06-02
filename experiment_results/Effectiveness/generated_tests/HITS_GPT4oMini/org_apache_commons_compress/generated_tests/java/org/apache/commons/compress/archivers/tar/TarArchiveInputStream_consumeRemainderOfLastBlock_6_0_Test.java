package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.io.input.BoundedInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TarArchiveInputStream_consumeRemainderOfLastBlock_6_0_Test {

    private TarArchiveInputStream tarArchiveInputStream;

    private InputStream inputStream;

    private static final int BLOCK_SIZE = 512;

    @BeforeEach
    public void setUp() {
        byte[] inputData = new byte[1024];
        inputStream = new ByteArrayInputStream(inputData);
        tarArchiveInputStream = new TarArchiveInputStream(inputStream, BLOCK_SIZE);
    }

    @Test
    public void testConsumeRemainderOfLastBlock_NoRemainder() throws Exception {
        invokeConsumeRemainderOfLastBlock();
        // No exception should be thrown, and nothing should happen
    }

    @Test
    public void testConsumeRemainderOfLastBlock_WithRemainder() throws Exception {
        when(inputStream.available()).thenReturn(BLOCK_SIZE + 100);
        invokeConsumeRemainderOfLastBlock();
        verify(inputStream, times(1)).skip(BLOCK_SIZE - 100);
    }

    @Test
    public void testConsumeRemainderOfLastBlock_EofException() throws Exception {
        // Use reflection to set the private field atEof to true
        setField(tarArchiveInputStream, "atEof", true);
        assertThrows(IOException.class, this::invokeConsumeRemainderOfLastBlock);
    }

    @Test
    public void testConsumeRemainderOfLastBlock_NegativeBytesRead() throws Exception {
        // Use reflection to set bytes read to a negative value
        setField(tarArchiveInputStream, "entryOffset", -1L);
        assertThrows(IOException.class, this::invokeConsumeRemainderOfLastBlock);
    }

    private void invokeConsumeRemainderOfLastBlock() throws Exception {
        java.lang.reflect.Method method = TarArchiveInputStream.class.getDeclaredMethod("consumeRemainderOfLastBlock");
        method.setAccessible(true);
        method.invoke(tarArchiveInputStream);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
