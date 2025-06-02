package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

class CpioArchiveInputStream_skipRemainderOfLastBlock_18_4_Test {

    private CpioArchiveInputStream cpioArchiveInputStream;

    // Example block size
    private static final int BLOCK_SIZE = 512;

    @BeforeEach
    void setUp() {
        // Initialize with an empty InputStream
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        cpioArchiveInputStream = new CpioArchiveInputStream(inputStream, BLOCK_SIZE);
    }

    @Test
    void testSkipRemainderOfLastBlockWithExactBlockSize() throws Exception {
        // Setup input stream with exact block size
        byte[] data = new byte[BLOCK_SIZE];
        InputStream inputStream = new ByteArrayInputStream(data);
        cpioArchiveInputStream = new CpioArchiveInputStream(inputStream, BLOCK_SIZE);
        // Simulate reading an entry
        CpioArchiveEntry entry = cpioArchiveInputStream.getNextCPIOEntry();
        assertNotNull(entry);
        // Call the method to test
        invokeSkipRemainderOfLastBlock();
        // Verify that it does not throw an exception
        assertDoesNotThrow(this::invokeSkipRemainderOfLastBlock);
    }

    @Test
    void testSkipRemainderOfLastBlockWithPartialBlockSize() throws Exception {
        // Setup input stream with partial block size
        // 100 bytes more than a full block
        byte[] data = new byte[BLOCK_SIZE + 100];
        InputStream inputStream = new ByteArrayInputStream(data);
        cpioArchiveInputStream = new CpioArchiveInputStream(inputStream, BLOCK_SIZE);
        // Simulate reading an entry
        CpioArchiveEntry entry = cpioArchiveInputStream.getNextCPIOEntry();
        assertNotNull(entry);
        // Call the method to test
        invokeSkipRemainderOfLastBlock();
        // Verify that it does not throw an exception
        assertDoesNotThrow(this::invokeSkipRemainderOfLastBlock);
    }

    @Test
    void testSkipRemainderOfLastBlockWithNoRemainingBytes() throws Exception {
        // Setup input stream with no remaining bytes
        // Two full blocks
        byte[] data = new byte[BLOCK_SIZE * 2];
        InputStream inputStream = new ByteArrayInputStream(data);
        cpioArchiveInputStream = new CpioArchiveInputStream(inputStream, BLOCK_SIZE);
        // Simulate reading an entry
        CpioArchiveEntry entry = cpioArchiveInputStream.getNextCPIOEntry();
        assertNotNull(entry);
        // Manually set bytes read to be a multiple of blockSize
        setEntryBytesRead(BLOCK_SIZE);
        // Call the method to test
        invokeSkipRemainderOfLastBlock();
        // Verify that it does not throw an exception
        assertDoesNotThrow(this::invokeSkipRemainderOfLastBlock);
    }

    @Test
    void testSkipRemainderOfLastBlockWithEOF() throws Exception {
        // Setup input stream with some data, but not enough for a full block
        // Less than a full block
        byte[] data = new byte[BLOCK_SIZE - 100];
        InputStream inputStream = new ByteArrayInputStream(data);
        cpioArchiveInputStream = new CpioArchiveInputStream(inputStream, BLOCK_SIZE);
        // Simulate reading an entry
        CpioArchiveEntry entry = cpioArchiveInputStream.getNextCPIOEntry();
        assertNotNull(entry);
        // Call the method to test
        invokeSkipRemainderOfLastBlock();
        // Verify that it does not throw an exception
        assertDoesNotThrow(this::invokeSkipRemainderOfLastBlock);
    }

    private void invokeSkipRemainderOfLastBlock() throws Exception {
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("skipRemainderOfLastBlock");
        method.setAccessible(true);
        method.invoke(cpioArchiveInputStream);
    }

    private void setEntryBytesRead(long bytesRead) throws Exception {
        java.lang.reflect.Field field = CpioArchiveInputStream.class.getDeclaredField("entryBytesRead");
        field.setAccessible(true);
        field.setLong(cpioArchiveInputStream, bytesRead);
    }
}
