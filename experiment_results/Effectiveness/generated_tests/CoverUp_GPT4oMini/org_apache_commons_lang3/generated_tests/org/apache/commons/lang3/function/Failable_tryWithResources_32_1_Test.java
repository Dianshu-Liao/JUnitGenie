package org.apache.commons.lang3.function;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class Failable_tryWithResources_32_1_Test {

    @Test
    void testTryWithResources_ActionThrowsException() {
        FailableRunnable<Throwable> action = () -> {
            throw new IOException("Test exception");
        };
        assertThrows(IOException.class, () -> {
            invokeTryWithResources(action);
        });
    }

    @Test
    void testTryWithResources_ActionDoesNotThrowException() throws Throwable {
        FailableRunnable<Throwable> action = () -> {
            // No exception thrown
        };
        // Should complete without throwing
        invokeTryWithResources(action);
    }

    @Test
    void testTryWithResources_ResourceThrowsException() {
        FailableRunnable<Throwable> action = () -> {
            // No exception thrown
        };
        FailableRunnable<Throwable> resource = () -> {
            throw new IOException("Resource exception");
        };
        assertThrows(IOException.class, () -> {
            invokeTryWithResources(action, resource);
        });
    }

    @Test
    void testTryWithResources_MultipleResources() {
        FailableRunnable<Throwable> action = () -> {
            // No exception thrown
        };
        FailableRunnable<Throwable> resource1 = () -> {
            // Resource 1 cleanup
        };
        FailableRunnable<Throwable> resource2 = () -> {
            throw new IOException("Resource 2 exception");
        };
        assertThrows(IOException.class, () -> {
            invokeTryWithResources(action, resource1, resource2);
        });
    }

    @Test
    void testTryWithResources_NoResources() throws Throwable {
        FailableRunnable<Throwable> action = () -> {
            // No exception thrown
        };
        // Should complete without throwing
        invokeTryWithResources(action);
    }

    @Test
    void testTryWithResources_ActionAndResourceBothThrow() {
        FailableRunnable<Throwable> action = () -> {
            throw new IOException("Action exception");
        };
        FailableRunnable<Throwable> resource = () -> {
            throw new IOException("Resource exception");
        };
        IOException exception = assertThrows(IOException.class, () -> {
            invokeTryWithResources(action, resource);
        });
        // Ensure the exception message is from the action
        assertEquals("Action exception", exception.getMessage());
    }

    private void invokeTryWithResources(FailableRunnable<Throwable> action, FailableRunnable<Throwable>... resources) throws Throwable {
        try {
            Method method = Failable.class.getDeclaredMethod("tryWithResources", FailableRunnable.class, FailableRunnable[].class);
            method.setAccessible(true);
            method.invoke(null, action, (Object) resources);
        } catch (InvocationTargetException e) {
            throw e.getCause() != null ? e.getCause() : e;
        } catch (Exception e) {
            throw e;
        }
    }

    @FunctionalInterface
    interface FailableRunnable<X extends Throwable> {

        void run() throws X;
    }
}
