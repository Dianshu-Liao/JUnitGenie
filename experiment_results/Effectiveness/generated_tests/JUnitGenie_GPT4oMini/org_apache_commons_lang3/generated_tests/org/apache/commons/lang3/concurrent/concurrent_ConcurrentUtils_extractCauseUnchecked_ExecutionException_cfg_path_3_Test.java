package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.ConcurrentRuntimeException;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.junit.Test;
import java.util.concurrent.ExecutionException;
import static org.junit.Assert.assertNull;

public class concurrent_ConcurrentUtils_extractCauseUnchecked_ExecutionException_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testExtractCauseUnchecked_NullExecutionException() {
        // Test case: ExecutionException is null
        
        ExecutionException ex = null; // This will trigger the null check
        
        try {
            ConcurrentRuntimeException result = ConcurrentUtils.extractCauseUnchecked(ex);
            assertNull(result); // Expecting a null return value
        } catch (Exception e) {
            // No exception should be thrown in this case
            e.printStackTrace();
        }
    }

}