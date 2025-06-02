package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TarUtils_parsePAX1XSparseHeaders_20_0_Test {

    @Test
    void testParsePAX1XSparseHeadersValidInput() throws Exception {
        // Prepare a valid input stream simulating the PAX 1.X sparse headers
        // 2 sparse headers: (offset 0, numbytes 100)
        String input = "2\n0\n100\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // Call the focal method
        List<TarArchiveStructSparse> result = invokeParsePAX1XSparseHeaders(inputStream, 512);
        // Validate the results
        assertEquals(2, result.size());
        assertEquals(0, result.get(0).getSparseOffset());
        assertEquals(100, result.get(0).getSparseNumbytes());
    }

    @Test
    void testParsePAX1XSparseHeadersNegativeCount() {
        // Invalid negative count
        String input = "-1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // Expect IOException
        assertThrows(IOException.class, () -> {
            invokeParsePAX1XSparseHeaders(inputStream, 512);
        });
    }

    @Test
    void testParsePAX1XSparseHeadersNegativeOffset() {
        // Invalid negative offset
        String input = "1\n-1\n100\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // Expect IOException
        assertThrows(IOException.class, () -> {
            invokeParsePAX1XSparseHeaders(inputStream, 512);
        });
    }

    @Test
    void testParsePAX1XSparseHeadersNegativeNumbytes() {
        // Invalid negative numbytes
        String input = "1\n0\n-1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // Expect IOException
        assertThrows(IOException.class, () -> {
            invokeParsePAX1XSparseHeaders(inputStream, 512);
        });
    }

    @Test
    void testParsePAX1XSparseHeadersNonNumericValue() {
        // Non-numeric value
        String input = "1\n0\nabc\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // Expect IOException
        assertThrows(IOException.class, () -> {
            invokeParsePAX1XSparseHeaders(inputStream, 512);
        });
    }

    private List<TarArchiveStructSparse> invokeParsePAX1XSparseHeaders(InputStream inputStream, int recordSize) throws Exception {
        // Use reflection to call the private method
        java.lang.reflect.Method method = TarUtils.class.getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class);
        method.setAccessible(true);
        return (List<TarArchiveStructSparse>) method.invoke(null, inputStream, recordSize);
    }

    // Mock class to replace TarArchiveStructSparse for testing
    private static class TarArchiveStructSparse {

        private final long sparseOffset;

        private final long sparseNumbytes;

        public TarArchiveStructSparse(long sparseOffset, long sparseNumbytes) {
            this.sparseOffset = sparseOffset;
            this.sparseNumbytes = sparseNumbytes;
        }

        public long getSparseOffset() {
            return sparseOffset;
        }

        public long getSparseNumbytes() {
            return sparseNumbytes;
        }
    }
}
