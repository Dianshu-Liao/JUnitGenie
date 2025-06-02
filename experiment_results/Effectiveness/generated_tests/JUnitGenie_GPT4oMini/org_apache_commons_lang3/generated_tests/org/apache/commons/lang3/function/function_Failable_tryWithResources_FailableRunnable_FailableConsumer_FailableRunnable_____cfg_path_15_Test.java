package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate some action that may throw an exception
            System.out.println("Executing action");
            throw new RuntimeException("Action failed");
        };

        FailableConsumer<Throwable, Throwable> errorHandler = (Throwable t) -> {
            // Handle the error
            System.out.println("Error handled: " + t.getMessage());
        };

        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup
                System.out.println("Cleaning up resource");
            }
        };

        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle the rethrown exception
            System.out.println("Exception rethrown: " + t.getMessage());
        }
    }


}