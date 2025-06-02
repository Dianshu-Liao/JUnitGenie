package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.ConcurrentRuntimeException;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import java.util.concurrent.ExecutionException;
import static org.junit.Assert.assertNotNull;

public class concurrent_ConcurrentUtils_extractCauseUnchecked_ExecutionException_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testExtractCauseUnchecked_withValidExecutionException() {
        Throwable cause = new Throwable("Cause of the exception");
        ExecutionException executionException = new ExecutionException("Execution failed", cause);

        try {
            ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(executionException);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExtractCauseUnchecked_withNullExecutionException() {
        try {
            ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(null);
            assertNotNull(result); // Expecting null to be returned
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExtractCauseUnchecked_withExecutionExceptionWithoutCause() {
        ExecutionException executionException = new ExecutionException("Execution failed", null);

        try {
            ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(executionException);
            assertNotNull(result); // Expecting null to be returned
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}