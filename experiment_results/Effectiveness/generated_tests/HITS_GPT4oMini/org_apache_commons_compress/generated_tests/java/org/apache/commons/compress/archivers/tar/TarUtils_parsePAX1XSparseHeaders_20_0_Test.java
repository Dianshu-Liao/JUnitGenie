package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class TarUtils_parsePAX1XSparseHeaders_20_0_Test {

    @Test
    void testParsePAX1XSparseHeaders() throws IOException {
        // Example input for testing
        // 2 sparse headers, with offsets and sizes
        String input = "2\n1234\n5678\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // Call the method under test
        List<TarArchiveStructSparse> sparseHeaders = TarUtils.parsePAX1XSparseHeaders(inputStream, 1024);
        // Verify the results
        assertNotNull(sparseHeaders);
        assertEquals(2, sparseHeaders.size());
        // Assuming TarArchiveStructSparse has getter methods to retrieve offset and size
        // Use getter method
        assertEquals(1234, sparseHeaders.get(0).getOffset());
        // Use getter method
        assertEquals(5678, sparseHeaders.get(1).getNumbytes());
    }

    @Test
    void testParsePAX1XSparseHeadersWithNegativeCount() {
        // Invalid input to trigger exception
        String input = "-1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // Expect an IOException
        assertThrows(IOException.class, () -> {
            TarUtils.parsePAX1XSparseHeaders(inputStream, 1024);
        });
    }

    @Test
    void testParsePAX1XSparseHeadersWithCorruptedData() {
        // Invalid size to trigger exception
        String input = "1\n1234\n-1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // Expect an IOException
        assertThrows(IOException.class, () -> {
            TarUtils.parsePAX1XSparseHeaders(inputStream, 1024);
        });
    }
}
