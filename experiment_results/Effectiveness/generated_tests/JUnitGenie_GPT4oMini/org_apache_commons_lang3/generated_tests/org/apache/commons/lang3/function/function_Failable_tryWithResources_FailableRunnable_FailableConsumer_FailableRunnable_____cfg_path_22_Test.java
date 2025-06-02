package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Create a FailableRunnable that will execute successfully
        FailableRunnable<Throwable> action = () -> {
            // Simulate some action
            System.out.println("Action executed successfully.");
        };

        // Create a FailableConsumer that handles the Throwable
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            // Handle the error
            System.err.println("Error handled: " + throwable.getMessage());
        };

        // Create a FailableRunnable that simulates a resource cleanup
        FailableRunnable<Throwable> resourceCleanup = () -> {
            // Simulate resource cleanup
            System.out.println("Resource cleaned up.");
        };

        // Create an array of FailableRunnable for resources
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            resourceCleanup
        };

        // Execute the tryWithResources method
        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            System.err.println("Unexpected exception: " + t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithException() {
        // Create a FailableRunnable that will throw an exception
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Simulated exception in action.");
        };

        // Create a FailableConsumer that handles the Throwable
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            // Handle the error
            System.err.println("Error handled: " + throwable.getMessage());
        };

        // Create a FailableRunnable that simulates a resource cleanup
        FailableRunnable<Throwable> resourceCleanup = () -> {
            // Simulate resource cleanup
            System.out.println("Resource cleaned up.");
        };

        // Create an array of FailableRunnable for resources
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            resourceCleanup
        };

        // Execute the tryWithResources method and handle exceptions
        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            System.err.println("Unexpected exception: " + t.getMessage());
        }
    }


}