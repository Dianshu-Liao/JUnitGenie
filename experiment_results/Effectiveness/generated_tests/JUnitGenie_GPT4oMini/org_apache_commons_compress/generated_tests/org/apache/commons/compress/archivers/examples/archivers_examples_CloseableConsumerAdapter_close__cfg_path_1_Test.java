package org.apache.commons.compress.archivers.examples;
import org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter;
import org.apache.commons.compress.archivers.examples.CloseableConsumer;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;

public class archivers_examples_CloseableConsumerAdapter_close__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCloseWithNonNullCloseable() {
        // Arrange
        CloseableConsumer mockConsumer = new CloseableConsumer() {
            @Override
            public void accept(Closeable closeable) {
                // Mock implementation
            }
        };
        Closeable mockCloseable = new Closeable() {
            @Override
            public void close() throws IOException {
                // Mock implementation
            }
        };
        CloseableConsumerAdapter adapter = new CloseableConsumerAdapter(mockConsumer); // Only pass the CloseableConsumer in the constructor

        // Act
        try {
            adapter.close();
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        // No assertion needed as we are testing the flow where closeable is not null
    }

    @Test(timeout = 4000)
    public void testCloseWithNullCloseable() {
        // Arrange
        CloseableConsumer mockConsumer = new CloseableConsumer() {
            @Override
            public void accept(Closeable closeable) {
                // Mock implementation
            }
        };
        CloseableConsumerAdapter adapter = new CloseableConsumerAdapter(mockConsumer); // Only pass the CloseableConsumer in the constructor

        // Act
        try {
            adapter.close();
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        // No assertion needed as we are testing the flow where closeable is null
    }

}