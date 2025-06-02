package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.MergedStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class io_MergedStream_skip_long_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSkipWithNonNullBuffer() {
        // Arrange
        byte[] buffer = new byte[10];
        InputStream inputStream = new ByteArrayInputStream(new byte[100]);
        MergedStream mergedStream = new MergedStream(null, inputStream, buffer, 0, buffer.length);
        
        // Act
        long result = 0;
        try {
            result = mergedStream.skip(5);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testSkipWithNullBuffer() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[100]);
        MergedStream mergedStream = new MergedStream(null, inputStream, null, 0, 0);
        
        // Act
        long result = 0;
        try {
            result = mergedStream.skip(10);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        assertEquals(10, result);
    }

}