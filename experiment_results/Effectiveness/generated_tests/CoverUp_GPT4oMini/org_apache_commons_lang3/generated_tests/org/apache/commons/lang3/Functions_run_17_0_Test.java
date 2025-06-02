package org.apache.commons.lang3;

import org.apache.commons.lang3.Functions;
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
import java.util.Arrays;
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
import org.apache.commons.lang3.Streams.FailableStream;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

class Functions_run_17_0_Test {

    @Test
    void testRunSuccessfulExecution() {
        Functions.run(() -> {
            // Successful execution, nothing to assert
        });
    }

    @Test
    void testRunThrowsUncheckedIOException() {
        UncheckedIOException exception = assertThrows(UncheckedIOException.class, () -> {
            Functions.run(() -> {
                throw new IOException("Test IOException");
            });
        });
        assertEquals("Test IOException", exception.getCause().getMessage());
    }

    @Test
    void testRunThrowsUndeclaredThrowableException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Functions.run(() -> {
                throw new RuntimeException("Test RuntimeException");
            });
        });
        assertEquals("Test RuntimeException", exception.getMessage());
    }

    @Test
    void testRunThrowsNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            Functions.run(() -> {
                throw new NullPointerException("Test NullPointerException");
            });
        });
        assertEquals("Test NullPointerException", exception.getMessage());
    }
}
