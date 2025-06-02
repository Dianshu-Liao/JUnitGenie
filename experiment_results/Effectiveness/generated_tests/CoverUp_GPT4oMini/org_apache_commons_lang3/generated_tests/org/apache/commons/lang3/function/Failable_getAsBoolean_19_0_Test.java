package org.apache.commons.lang3.function;

import org.apache.commons.lang3.function.Failable;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class Failable_getAsBoolean_19_0_Test {

    @Test
    void testGetAsBooleanSuccess() throws Exception {
        // Arrange
        FailableBooleanSupplier<Exception> supplier = () -> true;
        // Act
        boolean result = Failable.getAsBoolean(supplier);
        // Assert
        assertTrue(result);
    }

    @Test
    void testGetAsBooleanThrowsUncheckedIOException() {
        // Arrange
        FailableBooleanSupplier<IOException> supplier = () -> {
            throw new IOException("IO Exception occurred");
        };
        // Act & Assert
        Exception exception = assertThrows(UncheckedIOException.class, () -> {
            Failable.getAsBoolean(supplier);
        });
        assertEquals("IO Exception occurred", exception.getMessage());
    }

    @Test
    void testGetAsBooleanThrowsUndeclaredThrowableException() {
        // Arrange
        FailableBooleanSupplier<Exception> supplier = () -> {
            throw new Exception("General Exception occurred");
        };
        // Act & Assert
        Exception exception = assertThrows(UndeclaredThrowableException.class, () -> {
            Failable.getAsBoolean(supplier);
        });
        assertEquals("General Exception occurred", exception.getCause().getMessage());
    }

    @Test
    void testGetAsBooleanHandlesNullSupplier() {
        // Arrange
        FailableBooleanSupplier<Exception> supplier = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            Failable.getAsBoolean(supplier);
        });
    }

    // Reflection test to invoke private constructor
    @Test
    void testPrivateConstructor() throws Exception {
        // Arrange
        Class<Failable> clazz = Failable.class;
        Constructor<Failable> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // Act
        constructor.newInstance();
        // Assert
        // No exception thrown means the private constructor was invoked successfully
    }
}
