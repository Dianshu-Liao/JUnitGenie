package org.apache.commons.lang3.function;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

@ExtendWith(MockitoExtension.class)
class Failable_tryWithResources_31_1_Test {

    @Test
    void testTryWithResourcesSuccess() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate successful action
        };
        FailableRunnable<Throwable> resource1 = () -> {
            // Simulate successful resource cleanup
        };
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            fail("Error handler should not be called");
        };
        assertDoesNotThrow(() -> invokeTryWithResources(action, errorHandler, resource1));
    }

    @Test
    void testTryWithResourcesActionThrows() {
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Action failed");
        };
        FailableRunnable<Throwable> resource1 = () -> {
            // Simulate successful resource cleanup
        };
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            assertEquals("Action failed", throwable.getMessage());
        };
        assertDoesNotThrow(() -> invokeTryWithResources(action, errorHandler, resource1));
    }

    @Test
    void testTryWithResourcesResourceThrows() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate successful action
        };
        FailableRunnable<Throwable> resource1 = () -> {
            throw new RuntimeException("Resource cleanup failed");
        };
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            assertEquals("Resource cleanup failed", throwable.getMessage());
        };
        assertDoesNotThrow(() -> invokeTryWithResources(action, errorHandler, resource1));
    }

    @Test
    void testTryWithResourcesMultipleResources() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate successful action
        };
        FailableRunnable<Throwable> resource1 = () -> {
            throw new RuntimeException("Resource 1 cleanup failed");
        };
        FailableRunnable<Throwable> resource2 = () -> {
            // Simulate successful resource cleanup
        };
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            assertEquals("Resource 1 cleanup failed", throwable.getMessage());
        };
        assertDoesNotThrow(() -> invokeTryWithResources(action, errorHandler, resource1, resource2));
    }

    @Test
    void testTryWithResourcesNullErrorHandler() {
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Action failed");
        };
        FailableRunnable<Throwable> resource1 = () -> {
            // Simulate successful resource cleanup
        };
        assertThrows(RuntimeException.class, () -> invokeTryWithResources(action, null, resource1));
    }

    @Test
    void testTryWithResourcesNullResource() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate successful action
        };
        FailableRunnable<Throwable> resource1 = () -> {
            // Simulate successful resource cleanup
        };
        assertThrows(NullPointerException.class, () -> invokeTryWithResources(action, throwable -> {
        }, resource1, (FailableRunnable<Throwable>) null));
    }

    private void invokeTryWithResources(FailableRunnable<Throwable> action, FailableConsumer<Throwable, ? extends Throwable> errorHandler, FailableRunnable<Throwable>... resources) throws Exception {
        Method method = Failable.class.getDeclaredMethod("tryWithResources", FailableRunnable.class, FailableConsumer.class, FailableRunnable[].class);
        method.setAccessible(true);
        method.invoke(null, action, errorHandler, (Object) resources);
    }
}
