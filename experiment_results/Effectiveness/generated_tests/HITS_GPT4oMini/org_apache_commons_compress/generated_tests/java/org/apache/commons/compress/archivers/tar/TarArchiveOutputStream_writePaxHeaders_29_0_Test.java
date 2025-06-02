package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.io.output.CountingOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.ArrayFill;

public class TarArchiveOutputStream_writePaxHeaders_29_0_Test {

    private ByteArrayOutputStream outputStream;

    private TarArchiveOutputStream tarArchiveOutputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream);
    }

    @Test
    public void testWritePaxHeaders_WithValidHeaders() throws IOException {
        TarArchiveEntry entry = new TarArchiveEntry("test.txt");
        Map<String, String> headers = new HashMap<>();
        headers.put("path", "test.txt");
        headers.put("user", "user1");
        tarArchiveOutputStream.writePaxHeaders(entry, entry.getName(), headers);
        byte[] expectedOutput = createExpectedPaxHeaderOutput(headers);
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWritePaxHeaders_WithLongEntryName() throws IOException {
        TarArchiveEntry entry = new TarArchiveEntry("a_very_long_entry_name_that_exceeds_the_normal_length_limit.txt");
        Map<String, String> headers = new HashMap<>();
        headers.put("path", "a_very_long_entry_name_that_exceeds_the_normal_length_limit.txt");
        tarArchiveOutputStream.writePaxHeaders(entry, entry.getName(), headers);
        byte[] expectedOutput = createExpectedPaxHeaderOutput(headers);
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWritePaxHeaders_WithEmptyHeaders() throws IOException {
        TarArchiveEntry entry = new TarArchiveEntry("empty.txt");
        Map<String, String> headers = new HashMap<>();
        tarArchiveOutputStream.writePaxHeaders(entry, entry.getName(), headers);
        // Expect no output as headers are empty
        assertEquals(0, outputStream.size());
    }

    private byte[] createExpectedPaxHeaderOutput(Map<String, String> headers) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> header : headers.entrySet()) {
            sb.append(header.getKey()).append("=").append(header.getValue()).append("\n");
        }
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }
}
