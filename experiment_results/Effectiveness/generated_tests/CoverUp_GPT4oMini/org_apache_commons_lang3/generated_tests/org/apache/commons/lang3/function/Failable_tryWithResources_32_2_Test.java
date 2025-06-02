package org.apache.commons.lang3.function;

import org.apache.commons.lang3.function.Failable;
import org.junit.jupiter.api.function.Executable;
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
    void testTryWithResourcesSuccess() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate successful action
            System.out.println("Action executed successfully");
        };
        FailableRunnable<Throwable> resource = () -> {
            // Simulate resource cleanup
            System.out.println("Resource cleaned up");
        };
        Failable.tryWithResources(action, resource);
    }

    @Test
    void testTryWithResourcesActionThrowsException() {
        FailableRunnable<Throwable> action = () -> {
            throw new IOException("Action failed");
        };
        FailableRunnable<Throwable> resource = () -> {
            // Simulate resource cleanup
            System.out.println("Resource cleaned up");
        };
        assertThrows(IOException.class, () -> Failable.tryWithResources(action, resource));
    }

    @Test
    void testTryWithResourcesResourceThrowsException() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate successful action
            System.out.println("Action executed successfully");
        };
        FailableRunnable<Throwable> resource = () -> {
            throw new UncheckedIOException(new IOException("Resource failed"));
        };
        assertThrows(UncheckedIOException.class, () -> Failable.tryWithResources(action, resource));
    }

    @Test
    void testTryWithResourcesMultipleResources() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate successful action
            System.out.println("Action executed successfully");
        };
        FailableRunnable<Throwable> resource1 = () -> {
            // Simulate resource cleanup
            System.out.println("Resource 1 cleaned up");
        };
        FailableRunnable<Throwable> resource2 = () -> {
            // Simulate resource cleanup
            System.out.println("Resource 2 cleaned up");
        };
        Failable.tryWithResources(action, resource1, resource2);
    }

    @Test
    void testTryWithResourcesMultipleResourcesWithException() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate successful action
            System.out.println("Action executed successfully");
        };
        FailableRunnable<Throwable> resource1 = () -> {
            // Simulate resource cleanup
            System.out.println("Resource 1 cleaned up");
        };
        FailableRunnable<Throwable> resource2 = () -> {
            throw new UncheckedIOException(new IOException("Resource 2 failed"));
        };
        assertThrows(UncheckedIOException.class, () -> Failable.tryWithResources(action, resource1, resource2));
    }
}
