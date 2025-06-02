package org.apache.commons.lang3;

import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableSupplier;
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
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Functions_get_14_2_Test {

    @Test
    public void testGetSuccessful() throws Exception {
        FailableSupplier<String, Exception> supplier = () -> "Hello, World!";
        String result = Functions.get((Functions.FailableSupplier<String, Exception>) supplier);
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testGetThrowsUncheckedIOException() {
        FailableSupplier<String, IOException> supplier = () -> {
            throw new IOException("IO Exception occurred");
        };
        UncheckedIOException exception = assertThrows(UncheckedIOException.class, () -> Functions.get((Functions.FailableSupplier<String, IOException>) supplier));
        assertEquals("IO Exception occurred", exception.getCause().getMessage());
    }

    @Test
    public void testGetThrowsUndeclaredThrowableException() {
        FailableSupplier<String, Exception> supplier = () -> {
            throw new Exception("Generic Exception occurred");
        };
        UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> Functions.get((Functions.FailableSupplier<String, Exception>) supplier));
        assertEquals("Generic Exception occurred", exception.getCause().getMessage());
    }

    // Test for null supplier
    @Test
    public void testGetNullSupplier() {
        assertThrows(NullPointerException.class, () -> Functions.get(null));
    }
}
