package org.apache.commons.lang3;

import org.apache.commons.lang3.function.FailableSupplier;
import java.io.IOException;
import java.io.UncheckedIOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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


public class Functions_get_14_2_Test {

    @Test
    public void testGet_WithValidSupplier_ShouldReturnValue() {
        Functions.FailableSupplier<String, Exception> supplier = () -> "Hello, World!";
        String result = Functions.get(supplier);
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testGet_WithUncheckedException_ShouldRethrowAsRuntimeException() {
        Functions.FailableSupplier<String, RuntimeException> supplier = () -> {
            throw new RuntimeException("Unchecked Exception");
        };
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Functions.get(supplier);
        });
        assertEquals("Unchecked Exception", exception.getMessage());
    }

    @Test
    public void testGet_WithCheckedException_ShouldRethrowAsUncheckedIOException() {
        Functions.FailableSupplier<String, IOException> supplier = () -> {
            throw new IOException("Checked Exception");
        };
        UncheckedIOException exception = assertThrows(UncheckedIOException.class, () -> {
            Functions.get(supplier);
        });
        assertEquals("Checked Exception", exception.getCause().getMessage());
    }

    @Test
    public void testGet_WithNullSupplier_ShouldThrowNullPointerException() {
        Functions.FailableSupplier<String, Exception> supplier = null;
        assertThrows(NullPointerException.class, () -> {
            Functions.get(supplier);
        });
    }

    @Test
    public void testGet_WithMultipleExceptions_ShouldRethrowFirstException() {
        Functions.FailableSupplier<String, RuntimeException> supplier = () -> {
            throw new IllegalArgumentException("First Exception");
        };
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Functions.get(supplier);
        });
        assertEquals("First Exception", exception.getMessage());
    }
}
