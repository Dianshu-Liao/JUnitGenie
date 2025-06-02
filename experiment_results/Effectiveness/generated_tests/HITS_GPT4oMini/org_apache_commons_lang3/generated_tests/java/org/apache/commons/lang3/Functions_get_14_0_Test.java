package org.apache.commons.lang3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.apache.commons.lang3.Functions.FailableSupplier;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class Functions_get_14_0_Test {

    @Test
    public void testGetSuccessfulExecution() {
        // Arrange
        FailableSupplier<String, Exception> supplier = () -> "Success";
        // Act
        String result = Functions.get(supplier);
        // Assert
        assertEquals("Success", result);
    }

    @Test
    public void testGetThrowsUncheckedIOException() {
        // Arrange
        FailableSupplier<String, IOException> supplier = () -> {
            throw new IOException("IO Exception occurred");
        };
        // Act & Assert
        assertThrows(UncheckedIOException.class, () -> Functions.get(supplier));
    }

    @Test
    public void testGetThrowsUndeclaredThrowableException() {
        // Arrange
        FailableSupplier<String, Exception> supplier = () -> {
            throw new Exception("General Exception occurred");
        };
        // Act & Assert
        assertThrows(UndeclaredThrowableException.class, () -> Functions.get(supplier));
    }

    @Test
    public void testGetHandlesMultipleExceptions() {
        // Arrange
        FailableSupplier<String, Exception> supplier = () -> {
            throw new RuntimeException("Runtime Exception occurred");
        };
        // Act & Assert
        assertThrows(UndeclaredThrowableException.class, () -> Functions.get(supplier));
    }
}
