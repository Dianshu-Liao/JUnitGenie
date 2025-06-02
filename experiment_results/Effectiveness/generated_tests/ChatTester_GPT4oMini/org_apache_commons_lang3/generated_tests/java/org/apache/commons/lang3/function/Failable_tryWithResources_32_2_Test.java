package org.apache.commons.lang3.function;

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

class Failable_tryWithResources_32_2_Test {

    @Test
    void testTryWithResourcesSuccessfulExecution() {
        FailableRunnable<Throwable> action = () -> {
            // Action logic that executes successfully
        };
        FailableRunnable<Throwable> resource = () -> {
            // Resource logic that executes successfully
        };
        assertDoesNotThrow(() -> Failable.tryWithResources(action, resource));
    }

    @Test
    void testTryWithResourcesActionThrowsException() {
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Action failed");
        };
        FailableRunnable<Throwable> resource = () -> {
            // Resource logic that executes successfully
        };
        Exception exception = assertThrows(RuntimeException.class, () -> Failable.tryWithResources(action, resource));
        assertEquals("Action failed", exception.getMessage());
    }

    @Test
    void testTryWithResourcesResourceThrowsException() {
        FailableRunnable<Throwable> action = () -> {
            // Action logic that executes successfully
        };
        FailableRunnable<Throwable> resource = () -> {
            throw new RuntimeException("Resource failed");
        };
        Exception exception = assertThrows(RuntimeException.class, () -> Failable.tryWithResources(action, resource));
        assertEquals("Resource failed", exception.getMessage());
    }

    @Test
    void testTryWithResourcesMultipleResources() {
        FailableRunnable<Throwable> action = () -> {
            // Action logic that executes successfully
        };
        FailableRunnable<Throwable> resource1 = () -> {
            // Resource 1 logic that executes successfully
        };
        FailableRunnable<Throwable> resource2 = () -> {
            throw new RuntimeException("Resource 2 failed");
        };
        Exception exception = assertThrows(RuntimeException.class, () -> Failable.tryWithResources(action, resource1, resource2));
        assertEquals("Resource 2 failed", exception.getMessage());
    }

    @Test
    void testTryWithResourcesNoResources() {
        FailableRunnable<Throwable> action = () -> {
            // Action logic that executes successfully
        };
        assertDoesNotThrow(() -> Failable.tryWithResources(action));
    }
}
