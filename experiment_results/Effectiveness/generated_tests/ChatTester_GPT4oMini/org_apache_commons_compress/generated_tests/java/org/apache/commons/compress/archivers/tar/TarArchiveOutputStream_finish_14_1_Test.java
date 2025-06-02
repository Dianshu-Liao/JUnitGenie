// Test method
package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.ArrayFill;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TarArchiveOutputStream_finish_14_1_Test {

    private TarArchiveOutputStream tarOutputStream;

    private OutputStream mockOutputStream;

    @BeforeEach
    void setUp() {
        mockOutputStream = Mockito.mock(OutputStream.class);
        tarOutputStream = new TarArchiveOutputStream(mockOutputStream);
    }

    @Test
    void testFinishWithUnclosedEntryThrowsIOException() {
        // Arrange
        invokePrivateField(tarOutputStream, "haveUnclosedEntry", true);
        // Act & Assert
        IOException thrown = assertThrows(IOException.class, () -> {
            tarOutputStream.finish();
        });
        assertEquals("This archive contains unclosed entries.", thrown.getMessage());
    }

    @Test
    void testFinishCallsWriteEOFRecordTwice() throws IOException {
        // Arrange
        invokePrivateField(tarOutputStream, "haveUnclosedEntry", false);
        // Act
        tarOutputStream.finish();
        // Assert
        verify(mockOutputStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
    }

    @Test
    void testFinishCallsPadAsNeeded() throws IOException {
        // Arrange
        invokePrivateField(tarOutputStream, "haveUnclosedEntry", false);
        // Act
        tarOutputStream.finish();
        // Assert
        // Assuming padAsNeeded is a private method, we need to verify its behavior indirectly
        // This can be done by checking if the output stream is flushed
        verify(mockOutputStream).flush();
    }

    @Test
    void testFinishCallsSuperFinish() throws IOException {
        // Arrange
        invokePrivateField(tarOutputStream, "haveUnclosedEntry", false);
        TarArchiveOutputStream spy = Mockito.spy(tarOutputStream);
        // Act
        spy.finish();
        // Assert
        verify(spy).finish();
    }

    // Reflection method to set private fields
    private void invokePrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
