package org.apache.commons.lang3.function;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.util.Collection;
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

class Failable_rethrow_24_0_Test {

    @Test
    void testRethrow_NonNullThrowable() {
        Throwable throwable = new Exception("Test Exception");
        assertThrows(UndeclaredThrowableException.class, () -> {
            invokeRethrow(throwable);
        });
    }

    @Test
    void testRethrow_NullThrowable() {
        assertThrows(NullPointerException.class, () -> {
            invokeRethrow(null);
        });
    }

    @Test
    void testRethrow_IOException() {
        Throwable throwable = new IOException("Test IOException");
        assertThrows(UncheckedIOException.class, () -> {
            invokeRethrow(throwable);
        });
    }

    @Test
    void testRethrow_ExecutionException() {
        Throwable throwable = new ExecutionException("Test Execution Exception", new Exception("Cause"));
        assertThrows(UndeclaredThrowableException.class, () -> {
            invokeRethrow(throwable);
        });
    }

    private void invokeRethrow(Throwable throwable) {
        try {
            Method method = Failable.class.getDeclaredMethod("rethrow", Throwable.class);
            method.setAccessible(true);
            method.invoke(null, throwable);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
