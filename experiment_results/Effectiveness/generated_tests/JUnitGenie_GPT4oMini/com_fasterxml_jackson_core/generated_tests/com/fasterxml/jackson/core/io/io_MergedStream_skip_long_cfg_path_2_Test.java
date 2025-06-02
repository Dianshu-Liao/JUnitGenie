package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.MergedStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class io_MergedStream_skip_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSkipWithValidInput() {
        // Setup
        byte[] byteArray = new byte[]{1, 2, 3, 4, 5};
        InputStream inputStream = new ByteArrayInputStream(byteArray);
        MergedStream mergedStream = new MergedStream(null, inputStream, byteArray, 5, 0);
        
        long n = 3L; // Number of bytes to skip
        long expectedCount = 3L; // Expected count after skipping

        try {
            // Execute
            long actualCount = mergedStream.skip(n);
            
            // Verify
            assertEquals(expectedCount, actualCount);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSkipWithInsufficientBytes() {
        // Setup
        byte[] byteArray = new byte[]{1, 2, 3};
        InputStream inputStream = new ByteArrayInputStream(byteArray);
        MergedStream mergedStream = new MergedStream(null, inputStream, byteArray, 3, 0);
        
        long n = 5L; // Number of bytes to skip
        long expectedCount = 3L; // Expected count after skipping all available bytes

        try {
            // Execute
            long actualCount = mergedStream.skip(n);
            
            // Verify
            assertEquals(expectedCount, actualCount);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSkipWithNullByteArray() {
        // Setup
        InputStream inputStream = new ByteArrayInputStream(new byte[]{1, 2, 3});
        MergedStream mergedStream = new MergedStream(null, inputStream, null, 3, 0);
        
        long n = 2L; // Number of bytes to skip

        try {
            // Execute
            long actualCount = mergedStream.skip(n);
            
            // Verify
            assertEquals(0L, actualCount); // Should return 0 since _b is null
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}