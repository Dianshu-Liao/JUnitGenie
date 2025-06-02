package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.MergedStream;

public class DataFormatMatcher_getDataStream_5_0_Test {

    @Test
    public void testGetDataStreamWithNullOriginalStream() throws IOException {
        // Arrange
        byte[] bufferedData = { 1, 2, 3, 4, 5 };
        int bufferedStart = 0;
        int bufferedLength = bufferedData.length;
        JsonFactory jsonFactory = new JsonFactory();
        MatchStrength matchStrength = MatchStrength.SOLID_MATCH;
        DataFormatMatcher matcher = new DataFormatMatcher(null, bufferedData, bufferedStart, bufferedLength, jsonFactory, matchStrength);
        // Act
        InputStream result = matcher.getDataStream();
        // Assert
        assertNotNull(result);
        byte[] resultData = new byte[bufferedLength];
        int bytesRead = result.read(resultData);
        assertEquals(bufferedLength, bytesRead);
        assertArrayEquals(bufferedData, resultData);
    }

    @Test
    public void testGetDataStreamWithNonNullOriginalStream() throws IOException {
        // Arrange
        byte[] bufferedData = { 1, 2, 3, 4, 5 };
        int bufferedStart = 0;
        int bufferedLength = bufferedData.length;
        JsonFactory jsonFactory = new JsonFactory();
        MatchStrength matchStrength = MatchStrength.SOLID_MATCH;
        InputStream originalStream = new ByteArrayInputStream(new byte[] { 6, 7, 8 });
        DataFormatMatcher matcher = new DataFormatMatcher(originalStream, bufferedData, bufferedStart, bufferedLength, jsonFactory, matchStrength);
        // Act
        InputStream result = matcher.getDataStream();
        // Assert
        assertNotNull(result);
        byte[] resultData = new byte[bufferedLength + 3];
        int bytesRead = result.read(resultData);
        assertEquals(bufferedLength + 3, bytesRead);
        // Verify that the first three bytes are from the original stream
        assertEquals(6, resultData[0]);
        assertEquals(7, resultData[1]);
        assertEquals(8, resultData[2]);
        // Verify that the remaining bytes are from the buffered data
        for (int i = 0; i < bufferedLength; i++) {
            assertEquals(bufferedData[i], resultData[i + 3]);
        }
    }
}
