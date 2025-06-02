package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF32Reader;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

public class io_UTF32Reader_close__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCloseWhenInputStreamIsNull() {
        UTF32Reader reader = new UTF32Reader(null, null, null, 0, 0, false);
        try {
            reader.close();
            // If no exception is thrown, the test passes
        } catch (IOException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}