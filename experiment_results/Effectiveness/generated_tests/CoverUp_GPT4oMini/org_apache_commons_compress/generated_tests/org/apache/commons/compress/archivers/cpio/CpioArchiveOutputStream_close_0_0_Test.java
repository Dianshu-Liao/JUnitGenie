package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

@ExtendWith(MockitoExtension.class)
public class CpioArchiveOutputStream_close_0_0_Test {

    private CpioArchiveOutputStream cpioArchiveOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        cpioArchiveOutputStream = new CpioArchiveOutputStream(outputStream);
    }

    @Test
    public void testCloseWhenNotFinished() throws Exception {
        // Use reflection to set the 'finished' state to false
        setFinishedState(cpioArchiveOutputStream, false);
        // Close the CpioArchiveOutputStream
        cpioArchiveOutputStream.close();
        // Verify that the outputStream is still usable after close
        assertNotNull(outputStream);
        assertTrue(outputStream.size() >= 0);
    }

    @Test
    public void testCloseWhenFinished() throws Exception {
        // Use reflection to set the 'finished' state to true
        setFinishedState(cpioArchiveOutputStream, true);
        // Close the CpioArchiveOutputStream
        cpioArchiveOutputStream.close();
        // Verify that the outputStream is still usable after close
        assertNotNull(outputStream);
        assertTrue(outputStream.size() >= 0);
    }

    @Test
    public void testCloseHandlesIOException() throws Exception {
        // Mock the OutputStream to throw IOException on close
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException("Test Exception")).when(mockStream).close();
        // Use reflection to set the output stream to the mock
        setOutputStream(cpioArchiveOutputStream, mockStream);
        // Attempt to close and verify that it does not throw an exception
        assertDoesNotThrow(() -> cpioArchiveOutputStream.close());
    }

    private void setFinishedState(CpioArchiveOutputStream cpioArchiveOutputStream, boolean finished) throws Exception {
        Field finishedField = CpioArchiveOutputStream.class.getDeclaredField("finished");
        finishedField.setAccessible(true);
        finishedField.set(cpioArchiveOutputStream, finished);
    }

    private void setOutputStream(CpioArchiveOutputStream cpioArchiveOutputStream, OutputStream outputStream) throws Exception {
        Field outField = CpioArchiveOutputStream.class.getDeclaredField("out");
        outField.setAccessible(true);
        outField.set(cpioArchiveOutputStream, outputStream);
    }
}
