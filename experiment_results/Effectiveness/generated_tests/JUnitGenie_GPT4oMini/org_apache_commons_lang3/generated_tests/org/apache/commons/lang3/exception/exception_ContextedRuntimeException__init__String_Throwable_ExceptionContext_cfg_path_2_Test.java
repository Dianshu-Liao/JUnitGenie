package org.apache.commons.lang3.exception;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.apache.commons.lang3.exception.ExceptionContext;
import org.apache.commons.lang3.exception.DefaultExceptionContext;
import org.junit.Test;
import static org.junit.Assert.*;

public class exception_ContextedRuntimeException__init__String_Throwable_ExceptionContext_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        String message = "Test message";
        Throwable cause = new Throwable("Test cause");
        ExceptionContext context = new DefaultExceptionContext();

        try {
            ContextedRuntimeException exception = new ContextedRuntimeException(message, cause, context);
            assertNotNull(exception);
            assertEquals(message, exception.getMessage());
            assertEquals(cause, exception.getCause());
        } catch (Exception e) {
            fail("Exception should not be thrown for valid parameters");
        }
    }



}
