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

class Failable_getAsBoolean_19_2_Test {

    @Test
    void testGetAsBooleanReturnsTrue() {
        FailableBooleanSupplier<Exception> supplier = () -> true;
        assertTrue(Failable.getAsBoolean(supplier));
    }

    @Test
    void testGetAsBooleanReturnsFalse() {
        FailableBooleanSupplier<Exception> supplier = () -> false;
        assertFalse(Failable.getAsBoolean(supplier));
    }

    @Test
    void testGetAsBooleanThrowsRuntimeException() {
        FailableBooleanSupplier<Exception> supplier = () -> {
            throw new Exception("Test exception");
        };
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            Failable.getAsBoolean(supplier);
        });
        assertEquals("java.lang.Exception: Test exception", thrown.getCause().getMessage());
    }
}
