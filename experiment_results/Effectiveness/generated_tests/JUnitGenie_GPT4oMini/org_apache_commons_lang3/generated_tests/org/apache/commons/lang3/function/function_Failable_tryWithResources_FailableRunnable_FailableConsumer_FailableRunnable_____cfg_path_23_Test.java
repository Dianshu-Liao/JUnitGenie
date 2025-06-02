package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate action logic
            System.out.println("Executing action");
        };

        FailableConsumer<Throwable, Throwable> errorHandler = (th) -> {
            // Handle errors
            System.out.println("Handling error: " + th.getMessage());
        };

        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource clean-up logic
                System.out.println("Cleaning up resource");
            }
        };

        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            System.err.println("Caught throwable: " + t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithError() {
        FailableRunnable<Throwable> action = () -> {
            // This will throw an exception
            throw new RuntimeException("Action error");
        };

        FailableConsumer<Throwable, Throwable> errorHandler = (th) -> {
            // Handle the simulated error
            System.out.println("Handling error: " + th.getMessage());
        };

        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource clean-up
                System.out.println("Cleaning up resource with error");
            }
        };

        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            System.err.println("Caught throwable: " + t.getMessage());
        }
    }


}