package org.apache.commons.lang3.function;

import org.apache.commons.lang3.function.FailableConsumer;
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

public class Failable_tryWithResources_31_0_Test {

    @Test
    public void testTryWithResources_ActionExecutesSuccessfully() {
        FailableRunnable<Throwable> action = () -> System.out.println("Action executed");
        FailableConsumer<Throwable, Throwable> errorHandler = t -> fail("Error handler should not be called");
        assertDoesNotThrow(() -> Failable.tryWithResources(action, (FailableConsumer<Throwable, Throwable>) errorHandler));
    }

    @Test
    public void testTryWithResources_ActionThrowsException() {
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Action failed");
        };
        FailableConsumer<Throwable, Throwable> errorHandler = t -> {
            assertEquals("Action failed", t.getMessage());
        };
        assertDoesNotThrow(() -> Failable.tryWithResources(action, (FailableConsumer<Throwable, Throwable>) errorHandler));
    }

    @Test
    public void testTryWithResources_ResourcesExecuteSuccessfully() {
        FailableRunnable<Throwable> action = () -> System.out.println("Action executed");
        FailableRunnable<Throwable> resource = () -> System.out.println("Resource executed");
        FailableConsumer<Throwable, Throwable> errorHandler = t -> fail("Error handler should not be called");
        assertDoesNotThrow(() -> Failable.tryWithResources(action, (FailableConsumer<Throwable, Throwable>) errorHandler, resource));
    }

    @Test
    public void testTryWithResources_ResourceThrowsException() {
        FailableRunnable<Throwable> action = () -> System.out.println("Action executed");
        FailableRunnable<Throwable> resource = () -> {
            throw new RuntimeException("Resource failed");
        };
        FailableConsumer<Throwable, Throwable> errorHandler = t -> {
            assertEquals("Resource failed", t.getMessage());
        };
        assertDoesNotThrow(() -> Failable.tryWithResources(action, (FailableConsumer<Throwable, Throwable>) errorHandler, resource));
    }

    @Test
    public void testTryWithResources_ActionAndResourceThrowException() {
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Action failed");
        };
        FailableRunnable<Throwable> resource = () -> {
            throw new RuntimeException("Resource failed");
        };
        FailableConsumer<Throwable, Throwable> errorHandler = t -> {
            assertEquals("Action failed", t.getMessage());
        };
        assertDoesNotThrow(() -> Failable.tryWithResources(action, (FailableConsumer<Throwable, Throwable>) errorHandler, resource));
    }
}
