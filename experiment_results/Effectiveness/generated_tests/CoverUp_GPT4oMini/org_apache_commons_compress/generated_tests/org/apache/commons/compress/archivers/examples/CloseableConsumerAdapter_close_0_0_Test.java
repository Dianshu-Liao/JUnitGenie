package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
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
    void testClose_WithNonNullCloseable() throws IOException, Exception {
        // Arrange
        setCloseable(mockCloseable);
        // Act
        adapter.close();
        // Assert
        verify(mockConsumer, times(1)).accept(mockCloseable);
    }

    @Test
    void testClose_WithNullCloseable() throws IOException {
        // Act
        adapter.close();
        // Assert
        verify(mockConsumer, never()).accept(any(Closeable.class));
    }

    // Reflection method to set the private field 'closeable'
    private void setCloseable(Closeable closeable) throws Exception {
        Field field = CloseableConsumerAdapter.class.getDeclaredField("closeable");
        field.setAccessible(true);
        field.set(adapter, closeable);
    }
}
