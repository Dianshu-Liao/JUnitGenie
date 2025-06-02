package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF32Reader;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class io_UTF32Reader_loadMore_int_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testLoadMore() {
        // Setup
        byte[] buffer = new byte[10];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{0, 0, 0, 0});
        UTF32Reader reader = new UTF32Reader(null, inputStream, buffer, 0, 0, false);

        // Accessing the private method using reflection
        try {
            Method loadMoreMethod = UTF32Reader.class.getDeclaredMethod("loadMore", int.class);
            loadMoreMethod.setAccessible(true);

            // Test case where available is greater than 0
            boolean result = (boolean) loadMoreMethod.invoke(reader, 5);
            assertFalse(result); // Expecting false since _length will not be set to 4

            // Test case where available is less than or equal to 0
            result = (boolean) loadMoreMethod.invoke(reader, 0);
            assertFalse(result); // Expecting false since _length will not be set to 4

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testLoadMoreEOF() {
        // Setup
        byte[] buffer = new byte[10];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{});
        UTF32Reader reader = new UTF32Reader(null, inputStream, buffer, 0, 0, false);

        // Accessing the private method using reflection
        try {
            Method loadMoreMethod = UTF32Reader.class.getDeclaredMethod("loadMore", int.class);
            loadMoreMethod.setAccessible(true);

            // Test case where available is 0 and input stream is empty
            boolean result = (boolean) loadMoreMethod.invoke(reader, 0);
            assertFalse(result); // Expecting false due to EOF

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}