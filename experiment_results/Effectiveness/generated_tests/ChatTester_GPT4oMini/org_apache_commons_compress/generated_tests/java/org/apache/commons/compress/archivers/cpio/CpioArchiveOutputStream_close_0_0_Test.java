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

    private CpioArchiveOutputStream cpioArchiveOutputStream;

    private OutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        cpioArchiveOutputStream = new CpioArchiveOutputStream(outputStream);
    }

    @Test
    public void testCloseWhenNotFinished() throws Exception {
        // Using reflection to invoke the private method isFinished
        java.lang.reflect.Method isFinishedMethod = CpioArchiveOutputStream.class.getDeclaredMethod("isFinished");
        isFinishedMethod.setAccessible(true);
        // Mocking the method to return false
        when(isFinishedMethod.invoke(cpioArchiveOutputStream)).thenReturn(false);
        // Invoking close and asserting no exceptions are thrown
        assertDoesNotThrow(() -> cpioArchiveOutputStream.close());
        // Verify that finish() was called
        java.lang.reflect.Method finishMethod = CpioArchiveOutputStream.class.getDeclaredMethod("finish");
        finishMethod.setAccessible(true);
        verify(finishMethod, times(1)).invoke(cpioArchiveOutputStream);
    }

    @Test
    public void testCloseWhenAlreadyFinished() throws Exception {
        // Using reflection to invoke the private method isFinished
        java.lang.reflect.Method isFinishedMethod = CpioArchiveOutputStream.class.getDeclaredMethod("isFinished");
        isFinishedMethod.setAccessible(true);
        // Mocking the method to return true
        when(isFinishedMethod.invoke(cpioArchiveOutputStream)).thenReturn(true);
        // Invoking close and asserting no exceptions are thrown
        assertDoesNotThrow(() -> cpioArchiveOutputStream.close());
    }

    @Test
    public void testCloseHandlesIOException() throws Exception {
        // Mocking the OutputStream to throw IOException on close
        OutputStream mockOutputStream = mock(OutputStream.class);
        cpioArchiveOutputStream = new CpioArchiveOutputStream(mockOutputStream);
        // Assuming super.close() can throw IOException
        doThrow(new IOException("Test Exception")).when(mockOutputStream).close();
        // Invoking close and asserting no exceptions are thrown
        assertDoesNotThrow(() -> cpioArchiveOutputStream.close());
    }
}
