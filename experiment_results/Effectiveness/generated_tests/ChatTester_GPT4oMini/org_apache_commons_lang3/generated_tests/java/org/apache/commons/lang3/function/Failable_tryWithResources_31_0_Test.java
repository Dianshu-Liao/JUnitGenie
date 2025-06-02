// Test method
package org.apache.commons.lang3.function;

import org.junit.jupiter.api.function.Executable;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Failable_tryWithResources_31_0_Test {

    @Test
    void testTryWithResourcesSuccessfulExecution() {
        FailableRunnable<Throwable> action = () -> System.out.println("Action executed");
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> fail("Should not reach here");
        assertDoesNotThrow(() -> Failable.tryWithResources(action, errorHandler));
    }

    @Test
    void testTryWithResourcesActionThrowsException() {
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Action failed");
        };
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> assertEquals("Action failed", throwable.getMessage());
        assertDoesNotThrow(() -> Failable.tryWithResources(action, errorHandler));
    }

    @Test
    void testTryWithResourcesWithResourcesExecution() {
        FailableRunnable<Throwable> action = () -> System.out.println("Action executed");
        FailableRunnable<Throwable> resource = () -> System.out.println("Resource executed");
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> fail("Should not reach here");
        assertDoesNotThrow(() -> Failable.tryWithResources(action, errorHandler, resource));
    }

    @Test
    void testTryWithResourcesResourceThrowsException() {
        FailableRunnable<Throwable> action = () -> System.out.println("Action executed");
        FailableRunnable<Throwable> resource = () -> {
            throw new RuntimeException("Resource failed");
        };
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> assertEquals("Resource failed", throwable.getMessage());
        assertDoesNotThrow(() -> Failable.tryWithResources(action, errorHandler, resource));
    }

    @Test
    void testTryWithResourcesMultipleResources() {
        FailableRunnable<Throwable> action = () -> System.out.println("Action executed");
        FailableRunnable<Throwable> resource1 = () -> System.out.println("Resource 1 executed");
        FailableRunnable<Throwable> resource2 = () -> {
            throw new RuntimeException("Resource 2 failed");
        };
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> assertEquals("Resource 2 failed", throwable.getMessage());
        assertDoesNotThrow(() -> Failable.tryWithResources(action, errorHandler, resource1, resource2));
    }

    @Test
    void testTryWithResourcesNullErrorHandler() {
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Action failed");
        };
        FailableRunnable<Throwable> resource = () -> System.out.println("Resource executed");
        assertThrows(RuntimeException.class, () -> Failable.tryWithResources(action, throwable -> fail("Should not reach here"), resource));
    }

    @Test
    void testTryWithResourcesNullRunnable() {
        FailableRunnable<Throwable> action = () -> System.out.println("Action executed");
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> fail("Should not reach here");
        assertThrows(NullPointerException.class, () -> Failable.tryWithResources(action, errorHandler, (FailableRunnable<Throwable>) null));
    }
}
