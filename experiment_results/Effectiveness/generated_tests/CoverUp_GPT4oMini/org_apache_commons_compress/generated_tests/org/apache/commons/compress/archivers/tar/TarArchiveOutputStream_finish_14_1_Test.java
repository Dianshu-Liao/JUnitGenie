package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.io.output.CountingOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.ArrayFill;

public class TarArchiveOutputStream_finish_14_1_Test {

    private TarArchiveOutputStream tarArchiveOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream);
    }

    @Test
    public void testFinishWithoutUnclosedEntry() throws Exception {
        tarArchiveOutputStream.finish();
        // Verify that the output stream has data written
        assertTrue(byteArrayOutputStream.size() > 0);
    }

    @Test
    public void testFinishWithUnclosedEntry() {
        // Use reflection to set the private field 'haveUnclosedEntry' to true
        setPrivateField(tarArchiveOutputStream, "haveUnclosedEntry", true);
        IOException exception = assertThrows(IOException.class, () -> {
            tarArchiveOutputStream.finish();
        });
        assertEquals("This archive contains unclosed entries.", exception.getMessage());
    }

    @Test
    public void testFinishCallsSuperFinish() throws Exception {
        // Mock the output stream to verify flush is called
        OutputStream mockOutputStream = mock(OutputStream.class);
        tarArchiveOutputStream = new TarArchiveOutputStream(mockOutputStream);
        // Call finish method
        tarArchiveOutputStream.finish();
        // Verify flush is called on the output stream
        verify(mockOutputStream, times(1)).flush();
    }

    private void setPrivateField(Object obj, String fieldName, boolean value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setBoolean(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
