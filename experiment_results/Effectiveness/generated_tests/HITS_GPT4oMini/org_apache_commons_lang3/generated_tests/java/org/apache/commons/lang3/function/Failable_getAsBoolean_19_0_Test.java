package org.apache.commons.lang3.function;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.apache.commons.lang3.function.Failable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class Failable_getAsBoolean_19_0_Test {

    @Test
    public void testGetAsBooleanReturnsTrue() {
        FailableBooleanSupplier<Exception> supplier = () -> true;
        boolean result = Failable.getAsBoolean(supplier);
        assertTrue(result, "Expected true but got false");
    }

    @Test
    public void testGetAsBooleanReturnsFalse() {
        FailableBooleanSupplier<Exception> supplier = () -> false;
        boolean result = Failable.getAsBoolean(supplier);
        assertFalse(result, "Expected false but got true");
    }

    @Test
    public void testGetAsBooleanThrowsUncheckedIOException() {
        FailableBooleanSupplier<IOException> supplier = () -> {
            throw new IOException("IO Exception occurred");
        };
        assertThrows(UncheckedIOException.class, () -> Failable.getAsBoolean(supplier));
    }

    @Test
    public void testGetAsBooleanThrowsUndeclaredThrowableException() {
        FailableBooleanSupplier<Exception> supplier = () -> {
            throw new Exception("Checked Exception occurred");
        };
        assertThrows(UndeclaredThrowableException.class, () -> Failable.getAsBoolean(supplier));
    }

    @Test
    public void testGetAsBooleanHandlesNullSupplier() {
        FailableBooleanSupplier<Exception> supplier = () -> {
            throw new NullPointerException("Null Supplier");
        };
        assertThrows(UndeclaredThrowableException.class, () -> Failable.getAsBoolean(supplier));
    }
}
