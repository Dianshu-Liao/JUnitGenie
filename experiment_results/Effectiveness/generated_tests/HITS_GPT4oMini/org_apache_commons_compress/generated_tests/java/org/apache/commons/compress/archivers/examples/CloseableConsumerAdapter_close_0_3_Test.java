package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

interface CloseableConsumerAdapter_close_0_3_Test {

    void accept(Closeable closeable) throws IOException;
}

class CloseableConsumerAdapter {

    private final CloseableConsumer consumer;

    private Closeable closeable;

    public CloseableConsumerAdapter(CloseableConsumer consumer) {
        this.consumer = consumer;
    }

    public void setCloseable(Closeable closeable) {
        this.closeable = closeable;
    }

    public void close() throws IOException {
        if (closeable != null) {
            consumer.accept(closeable);
        }
    }
}

class CloseableConsumerAdapter_close_Test {

    private CloseableConsumerAdapter adapter;

    private Closeable closeable;

    private CloseableConsumer consumer;

    @BeforeEach
    void setUp() {
        consumer = mock(CloseableConsumer.class);
        adapter = new CloseableConsumerAdapter(consumer);
    }

    @Test
    void testClose_withNonNullCloseable() throws IOException {
        // Arrange
        closeable = mock(Closeable.class);
        adapter.setCloseable(closeable);
        // Act
        adapter.close();
        // Assert
        verify(consumer).accept(closeable);
    }

    @Test
    void testClose_withNullCloseable() throws IOException {
        // Arrange
        adapter.setCloseable(null);
        // Act
        adapter.close();
        // Assert
        verify(consumer, never()).accept(any());
    }
}
