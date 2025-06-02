package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CompletionException;
import static org.junit.Assert.fail;

public class function_Failable_rethrow_Throwable_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRethrowWithUncheckedIOException() {
        Throwable throwable = new Throwable("Some error");
        try {
            Failable.rethrow(throwable);
            fail("Expected UndeclaredThrowableException to be thrown");
        } catch (UndeclaredThrowableException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testRethrowWithIOException() {
        Throwable throwable = new IOException("IO error");
        try {
            Failable.rethrow(throwable);
            fail("Expected UncheckedIOException to be thrown");
        } catch (CompletionException e) { // Changed to CompletionException
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testRethrowWithNull() {
        try {
            Failable.rethrow(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }


}