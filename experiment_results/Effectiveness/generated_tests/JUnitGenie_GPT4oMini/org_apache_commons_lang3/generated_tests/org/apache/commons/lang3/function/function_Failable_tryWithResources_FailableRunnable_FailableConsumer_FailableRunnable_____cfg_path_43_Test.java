package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_43_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Mock action that throws an exception
        FailableRunnable<Throwable> action = () -> {
            throw new IllegalArgumentException("Action Exception");
        };

        // Mock error handler
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            // Handle the error (for our test, we will just print it)
            System.err.println("Error handled: " + throwable.getMessage());
        };

        // Mock resources (no exceptions)
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Resource cleanup that does not throw
                System.out.println("Resource cleaned up");
            }
        };

        Throwable thrown = null;
        try {
            // Call the focal method which should throw an IllegalArgumentException
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable e) {
            thrown = e;
        }
        // Check that the exception thrown is as expected
        assert thrown instanceof IllegalArgumentException;
    }

}