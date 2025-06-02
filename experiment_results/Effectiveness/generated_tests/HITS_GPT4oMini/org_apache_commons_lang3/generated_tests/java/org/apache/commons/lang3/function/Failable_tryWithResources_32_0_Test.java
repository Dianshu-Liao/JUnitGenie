package org.apache.commons.lang3.function;

import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableRunnable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.stream.Streams;
import org.apache.commons.lang3.stream.Streams.FailableStream;

public class Failable_tryWithResources_32_0_Test {

    @Test
    void testTryWithResources_WithSingleAction() {
        // Arrange
        boolean[] actionExecuted = { false };
        FailableRunnable<Throwable> action = () -> actionExecuted[0] = true;
        // Act
        Failable.tryWithResources(action);
        // Assert
        assertTrue(actionExecuted[0], "The action should have been executed.");
    }

    @Test
    void testTryWithResources_WithMultipleResources() {
        // Arrange
        boolean[] actionExecuted = { false };
        FailableRunnable<Throwable> action = () -> actionExecuted[0] = true;
        FailableRunnable<Throwable> resource1 = () -> {
        };
        FailableRunnable<Throwable> resource2 = () -> {
        };
        // Act
        Failable.tryWithResources(action, resource1, resource2);
        // Assert
        assertTrue(actionExecuted[0], "The action should have been executed.");
    }

    @Test
    void testTryWithResources_ActionThrowsException() {
        // Arrange
        FailableRunnable<Throwable> action = () -> {
            throw new IOException("Test exception");
        };
        // Act & Assert
        Exception exception = assertThrows(IOException.class, () -> {
            Failable.tryWithResources(action);
        });
        assertEquals("Test exception", exception.getMessage());
    }

    @Test
    void testTryWithResources_ResourcesThrowException() {
        // Arrange
        FailableRunnable<Throwable> action = () -> {
        };
        FailableRunnable<Throwable> resource1 = () -> {
            throw new IOException("Resource exception");
        };
        // Act & Assert
        Exception exception = assertThrows(IOException.class, () -> {
            Failable.tryWithResources(action, resource1);
        });
        assertEquals("Resource exception", exception.getMessage());
    }

    @Test
    void testTryWithResources_MultipleResourcesWithException() {
        // Arrange
        FailableRunnable<Throwable> action = () -> {
        };
        FailableRunnable<Throwable> resource1 = () -> {
            throw new IOException("Resource 1 exception");
        };
        FailableRunnable<Throwable> resource2 = () -> {
            throw new IOException("Resource 2 exception");
        };
        // Act & Assert
        Exception exception = assertThrows(IOException.class, () -> {
            Failable.tryWithResources(action, resource1, resource2);
        });
        assertEquals("Resource 1 exception", exception.getMessage());
    }
}
