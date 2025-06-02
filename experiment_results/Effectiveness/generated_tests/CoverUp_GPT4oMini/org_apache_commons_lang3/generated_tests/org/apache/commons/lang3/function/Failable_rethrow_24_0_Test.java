package org.apache.commons.lang3.function;

import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import org.apache.commons.lang3.stream.Streams;
import org.apache.commons.lang3.stream.Streams.FailableStream;

class Failable_rethrow_24_0_Test {

    @Test
    void testRethrow_NullThrowable() {
        Throwable throwable = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeRethrow(throwable);
        });
        assertEquals("throwable", exception.getMessage());
    }

    @Test
    void testRethrow_IOException() {
        Throwable throwable = new IOException("IO error");
        UncheckedIOException exception = assertThrows(UncheckedIOException.class, () -> {
            invokeRethrow(throwable);
        });
        assertEquals("IO error", exception.getMessage());
        assertTrue(exception.getCause() instanceof IOException);
    }

    @Test
    void testRethrow_UndeclaredThrowableException() {
        Throwable throwable = new Exception("General error");
        UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> {
            invokeRethrow(throwable);
        });
        assertEquals("General error", exception.getMessage());
        assertTrue(exception.getCause() instanceof Exception);
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
