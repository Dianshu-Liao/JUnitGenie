package org.apache.commons.compress.archivers.tar;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.IOException;
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
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ArrayFill;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TarArchiveOutputStream_TarArchiveOutputStream_31_0_Test {

    private TarArchiveOutputStream tarArchiveOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream);
    }

    @Test
    public void testConstructorWithOutputStream() {
        assertNotNull(tarArchiveOutputStream, "TarArchiveOutputStream should be instantiated successfully.");
    }

    @Test
    public void testConstructorWithOutputStream_ValidState() {
        assertEquals(-511, invokePrivateField("longFileMode"), "longFileMode should be initialized to BLOCK_SIZE_UNSPECIFIED (-511).");
        assertEquals(0, invokePrivateField("currSize"), "currSize should be initialized to 0.");
        assertNotNull(invokePrivateField("recordBuf"), "recordBuf should be initialized.");
        assertEquals(0, invokePrivateField("recordsWritten"), "recordsWritten should be initialized to 0.");
    }

    @Test
    public void testConstructorWithOutputStream_OutputStreamNotNull() {
        assertNotNull(tarArchiveOutputStream, "Output stream should not be null after construction.");
    }

    // Reflection method to access private fields
    private Object invokePrivateField(String fieldName) {
        try {
            // Fixed line: replaced 'var' with 'Field' type
            java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(tarArchiveOutputStream);
        } catch (Exception e) {
            fail("Failed to access private field: " + fieldName);
            return null;
        }
    }
}
