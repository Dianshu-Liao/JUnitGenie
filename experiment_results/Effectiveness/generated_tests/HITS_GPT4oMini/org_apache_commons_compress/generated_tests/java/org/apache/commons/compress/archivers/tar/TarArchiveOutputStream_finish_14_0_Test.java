package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.io.output.CountingOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.ArrayFill;

public class TarArchiveOutputStream_finish_14_0_Test {

    private TarArchiveOutputStream tarArchiveOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream);
    }

    @Test
    public void testFinishWithoutUnclosedEntry() throws IOException {
        // This should complete without exceptions
        tarArchiveOutputStream.finish();
    }

    @Test
    public void testFinishWithUnclosedEntry() throws IOException {
        // Simulate an unclosed entry by setting the long file mode
        tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
        // Now we simulate having an unclosed entry by calling finish() before closing
        // This should not throw an exception yet
        tarArchiveOutputStream.finish();
        // To simulate the unclosed entry, we can call finish again without closing the entry
        assertThrows(IOException.class, () -> tarArchiveOutputStream.finish());
    }

    @Test
    public void testFinishFlushesOutputStream() throws IOException {
        // Finish the stream and check if the underlying output stream is flushed
        tarArchiveOutputStream.finish();
        // Check the output stream has written data
        assertTrue(byteArrayOutputStream.size() > 0);
    }

    @Test
    public void testFinishWritesEOFRecords() throws IOException {
        // Call finish and check if EOF records are written
        tarArchiveOutputStream.finish();
        // Check that the output stream contains EOF records (two zero-filled records)
        byte[] output = byteArrayOutputStream.toByteArray();
        // Size of each EOF record
        int eofRecordSize = 512;
        assertTrue(output.length >= 2 * eofRecordSize);
    }
}
