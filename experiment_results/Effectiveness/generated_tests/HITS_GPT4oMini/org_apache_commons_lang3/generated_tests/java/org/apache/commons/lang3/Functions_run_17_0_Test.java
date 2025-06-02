package org.apache.commons.lang3;

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


public class Functions_run_17_0_Test {

    @Test
    public void testRun_WithSuccessfulRunnable() {
        Functions.run(() -> {
            // Successful execution
        });
        // No exception should be thrown
    }

    @Test
    public void testRun_WithUncheckedException() {
        assertThrows(RuntimeException.class, () -> {
            Functions.run(() -> {
                throw new RuntimeException("Unchecked exception");
            });
        });
    }

    @Test
    public void testRun_WithIOException() {
        assertThrows(UncheckedIOException.class, () -> {
            Functions.run(() -> {
                throw new IOException("IO exception");
            });
        });
    }

    @Test
    public void testRun_WithOtherThrowable() {
        assertThrows(UndeclaredThrowableException.class, () -> {
            Functions.run(() -> {
                throw new Exception("Checked exception");
            });
        });
    }
}
