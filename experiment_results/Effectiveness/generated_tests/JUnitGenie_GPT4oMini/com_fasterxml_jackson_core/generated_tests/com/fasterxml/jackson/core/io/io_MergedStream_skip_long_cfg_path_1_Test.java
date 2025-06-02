package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class io_MergedStream_skip_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSkipWithSufficientBytesInBuffer() {
        // Arrange
        byte[] buffer = new byte[]{1, 2, 3, 4, 5};
        IOContext context = new IOContext(null, null, false);
        MergedStream mergedStream = new MergedStream(context, new ByteArrayInputStream(buffer), buffer, 0, buffer.length);
        long n = 3; // Number of bytes to skip

        // Act
        long result = 0;
        try {
            result = mergedStream.skip(n);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testSkipWithInsufficientBytesInBuffer() {
        // Arrange
        byte[] buffer = new byte[]{1, 2, 3};
        IOContext context = new IOContext(null, null, false);
        MergedStream mergedStream = new MergedStream(context, new ByteArrayInputStream(buffer), buffer, 0, buffer.length);
        long n = 5; // Number of bytes to skip

        // Act
        long result = 0;
        try {
            result = mergedStream.skip(n);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        assertEquals(3, result); // Should skip all available bytes
    }

    @Test(timeout = 4000)
    public void testSkipWithNullBuffer() {
        // Arrange
        IOContext context = new IOContext(null, null, false);
        MergedStream mergedStream = new MergedStream(context, new ByteArrayInputStream(new byte[0]), new byte[0], 0, 0);
        long n = 5; // Number of bytes to skip

        // Act
        long result = 0;
        try {
            result = mergedStream.skip(n);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        assertEquals(0, result); // No bytes to skip
    }


}