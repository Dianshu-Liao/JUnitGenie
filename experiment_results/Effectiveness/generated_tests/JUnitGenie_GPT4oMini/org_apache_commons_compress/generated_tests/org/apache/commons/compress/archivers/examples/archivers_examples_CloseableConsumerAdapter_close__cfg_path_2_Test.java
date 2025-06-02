package org.apache.commons.compress.archivers.examples;
import org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;

public class archivers_examples_CloseableConsumerAdapter_close__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCloseWhenCloseableIsNull() {
        // Create a CloseableConsumerAdapter with a valid consumer that handles null Closeable
        CloseableConsumerAdapter adapter = new CloseableConsumerAdapter(closeable -> {
            // Consumer logic can be defined here if needed
        });

        // Instead of passing null directly, we will modify the constructor to handle null Closeable
        adapter = new CloseableConsumerAdapter(closeable -> {
            // No operation if closeable is null
        });

        try {
            adapter.close(); // This should return without throwing an exception
        } catch (IOException e) {
            // Handle the exception if it occurs, but it should not in this case
            e.printStackTrace();
        }
    }


}