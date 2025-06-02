package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import static org.junit.Assert.fail;

public class function_Failable_rethrow_Throwable_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRethrowWithError() {
        Throwable throwable = new Error("Test Error");
        try {
            Failable.rethrow(throwable);
            fail("Expected UndeclaredThrowableException to be thrown");
        } catch (UndeclaredThrowableException e) {
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

    @Test(timeout = 4000)
    public void testRethrowWithIOException() {
        Throwable throwable = new IOException("Test IOException");
        try {
            Failable.rethrow(throwable);
            fail("Expected UndeclaredThrowableException to be thrown");
        } catch (UndeclaredThrowableException e) {
            // Expected exception
        }
    }


}