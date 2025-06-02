package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.ConcurrentRuntimeException;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.junit.Test;
import java.util.concurrent.ExecutionException;
import static org.junit.Assert.assertNull;

public class concurrent_ConcurrentUtils_extractCauseUnchecked_ExecutionException_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testExtractCauseUnchecked_NullExecutionException() {
        ExecutionException ex = null;

        // Testing the focal method with a null ExecutionException
        ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(ex);

        // Asserting that the result is null
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testExtractCauseUnchecked_ExecutionExceptionWithNullCause() {
        ExecutionException ex = new ExecutionException("Test Exception", null);

        // Testing the focal method with an ExecutionException that has a null cause
        ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(ex);

        // Asserting that the result is null
        assertNull(result);
    }

}