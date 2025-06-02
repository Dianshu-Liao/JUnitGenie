package org.apache.commons.lang3;
import org.junit.Test;
import org.apache.commons.lang3.Functions;
import static org.junit.Assert.fail;

public class Functions_run_FailableRunnable_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRunThrowsUndeclaredThrowableException() {
        // Arrange
        Functions.FailableRunnable runnable = new Functions.FailableRunnable() {
            @Override
            public void run() throws Throwable {
                throw new RuntimeException("Test Exception");
            }
        };

        // Act
        try {
            Functions.run(runnable);
            fail("Expected RuntimeException to be thrown.");
        } catch (RuntimeException e) {
            // Assert
            // Expected exception has been thrown, so we can pass that test
            // The test will pass if we reach here
        } catch (Throwable t) {
            fail("Expected RuntimeException but caught a different Throwable: " + t.getClass().getName());
        }
    }

}