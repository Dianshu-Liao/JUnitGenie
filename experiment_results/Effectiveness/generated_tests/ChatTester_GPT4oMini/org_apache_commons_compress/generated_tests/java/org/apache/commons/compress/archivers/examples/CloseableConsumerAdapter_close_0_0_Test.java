package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class CloseableConsumerAdapter_close_0_0_Test {

    private CloseableConsumerAdapter adapter;

    private CloseableConsumer mockConsumer;

    private Closeable mockCloseable;

    @BeforeEach
    void setUp() {
        mockConsumer = Mockito.mock(CloseableConsumer.class);
        adapter = new CloseableConsumerAdapter(mockConsumer);
        mockCloseable = Mockito.mock(Closeable.class);
    }

    @Test
    void testClose_WithNonNullCloseable() throws IOException {
        // Arrange
        // Use reflection to set the private field
        setCloseable(adapter, mockCloseable);
        // Act
        adapter.close();
        // Assert
        verify(mockConsumer).accept(mockCloseable);
    }

    @Test
    void testClose_WithNullCloseable() throws IOException {
        // Arrange
        // Use reflection to set the private field
        setCloseable(adapter, null);
        // Act
        adapter.close();
        // Assert
        verify(mockConsumer, never()).accept(any());
    }

    private void setCloseable(CloseableConsumerAdapter adapter, Closeable closeable) {
        try {
            java.lang.reflect.Field field = CloseableConsumerAdapter.class.getDeclaredField("closeable");
            field.setAccessible(true);
            field.set(adapter, closeable);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
