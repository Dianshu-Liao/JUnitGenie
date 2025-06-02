// Replace with the actual package name
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

class Failable_getAsBoolean_19_1_Test {

    @Test
    void testGetAsBooleanReturnsTrue() {
        FailableBooleanSupplier<Exception> supplier = () -> true;
        boolean result = Failable.getAsBoolean(supplier);
        assertTrue(result, "Expected true but got false");
    }

    @Test
    void testGetAsBooleanReturnsFalse() {
        FailableBooleanSupplier<Exception> supplier = () -> false;
        boolean result = Failable.getAsBoolean(supplier);
        assertFalse(result, "Expected false but got true");
    }

    @Test
    void testGetAsBooleanThrowsUncheckedIOException() {
        FailableBooleanSupplier<IOException> supplier = () -> {
            throw new IOException("IO Exception occurred");
        };
        Exception exception = assertThrows(UncheckedIOException.class, () -> {
            Failable.getAsBoolean(supplier);
        });
        assertEquals("java.io.IOException: IO Exception occurred", exception.getMessage());
    }

    @Test
    void testGetAsBooleanThrowsUndeclaredThrowableException() {
        FailableBooleanSupplier<Exception> supplier = () -> {
            throw new RuntimeException("Runtime Exception occurred");
        };
        Exception exception = assertThrows(UndeclaredThrowableException.class, () -> {
            Failable.getAsBoolean(supplier);
        });
        assertEquals("java.lang.RuntimeException: Runtime Exception occurred", exception.getMessage());
    }
}

@FunctionalInterface
interface FailableBooleanSupplier<E extends Throwable> {

    boolean getAsBoolean() throws E;
}
