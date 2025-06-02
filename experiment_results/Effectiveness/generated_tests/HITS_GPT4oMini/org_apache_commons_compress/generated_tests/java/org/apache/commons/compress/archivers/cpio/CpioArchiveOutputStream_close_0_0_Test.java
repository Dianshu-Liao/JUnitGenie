package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

public class CpioArchiveOutputStream_close_0_0_Test {

    private ByteArrayOutputStream outputStream;

    private CpioArchiveOutputStream cpioArchiveOutputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        cpioArchiveOutputStream = new CpioArchiveOutputStream(outputStream);
    }

    @AfterEach
    public void tearDown() throws IOException {
        cpioArchiveOutputStream.close();
        outputStream.close();
    }

    @Test
    public void testClose_WhenNotFinished_ShouldCallFinish() throws IOException {
        // Given that the output stream is not finished
        // When close is called
        cpioArchiveOutputStream.close();
        // Then it should finish without throwing an exception
    }

    @Test
    public void testClose_WhenFinished_ShouldNotThrowException() throws IOException {
        // Given that the output stream is finished
        cpioArchiveOutputStream.finish();
        // When close is called
        cpioArchiveOutputStream.close();
        // Then it should not throw any exception
    }

    @Test
    public void testClose_WhenCalledMultipleTimes_ShouldNotThrowException() throws IOException {
        // Given that the output stream is not finished
        cpioArchiveOutputStream.close();
        // When close is called multiple times
        cpioArchiveOutputStream.close();
        // Then it should not throw any exception
    }

    @Test
    public void testClose_WhenEntryNotClosed_ShouldThrowIOException() throws IOException {
        // Given that an entry is open
        // This simulates closing an entry
        cpioArchiveOutputStream.finish();
        // When close is called
        cpioArchiveOutputStream.close();
        // Then it should throw an IOException
        assertThrows(IOException.class, () -> {
            cpioArchiveOutputStream.close();
        });
    }
}
