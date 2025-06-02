package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.MergedStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

class DataFormatMatcher_getDataStream_5_0_Test {

    private DataFormatMatcher dataFormatMatcher;

    private JsonFactory mockJsonFactory;

    private MatchStrength mockMatchStrength;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        mockJsonFactory = Mockito.mock(JsonFactory.class);
        mockMatchStrength = Mockito.mock(MatchStrength.class);
    }

    @Test
    void testGetDataStream_withOriginalStream() throws Exception {
        // Arrange
        InputStream originalStream = new ByteArrayInputStream("original".getBytes());
        byte[] bufferedData = "buffered".getBytes();
        int bufferedStart = 0;
        int bufferedLength = bufferedData.length;
        dataFormatMatcher = new DataFormatMatcher(originalStream, bufferedData, bufferedStart, bufferedLength, mockJsonFactory, mockMatchStrength);
        // Act
        InputStream resultStream = dataFormatMatcher.getDataStream();
        // Assert
        assertNotNull(resultStream);
        assertTrue(resultStream instanceof MergedStream);
    }

    @Test
    void testGetDataStream_withoutOriginalStream() throws Exception {
        // Arrange
        byte[] bufferedData = "buffered".getBytes();
        int bufferedStart = 0;
        int bufferedLength = bufferedData.length;
        dataFormatMatcher = new DataFormatMatcher(null, bufferedData, bufferedStart, bufferedLength, mockJsonFactory, mockMatchStrength);
        // Act
        InputStream resultStream = dataFormatMatcher.getDataStream();
        // Assert
        assertNotNull(resultStream);
        assertTrue(resultStream instanceof ByteArrayInputStream);
        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) resultStream;
        assertEquals(bufferedLength, byteArrayInputStream.available());
    }

    @Test
    void testGetDataStream_withNullBufferedData() throws Exception {
        // Arrange
        InputStream originalStream = new ByteArrayInputStream("original".getBytes());
        byte[] bufferedData = null;
        int bufferedStart = 0;
        int bufferedLength = 0;
        dataFormatMatcher = new DataFormatMatcher(originalStream, bufferedData, bufferedStart, bufferedLength, mockJsonFactory, mockMatchStrength);
        // Act
        InputStream resultStream = dataFormatMatcher.getDataStream();
        // Assert
        assertNotNull(resultStream);
        assertTrue(resultStream instanceof MergedStream);
    }
}
