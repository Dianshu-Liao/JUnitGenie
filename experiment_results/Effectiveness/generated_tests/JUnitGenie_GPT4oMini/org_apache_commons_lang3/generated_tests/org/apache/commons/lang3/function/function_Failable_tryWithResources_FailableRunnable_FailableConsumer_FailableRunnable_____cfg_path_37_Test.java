package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_37_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Create a FailableRunnable that simulates an action
        FailableRunnable<Throwable> action = () -> {
            // Simulate some action that does not throw an exception
            System.out.println("Action executed successfully.");
        };

        // Create a FailableConsumer that handles exceptions
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            // Handle the exception
            System.err.println("Error occurred: " + throwable.getMessage());
        };

        // Create an array of FailableRunnable resources
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup that does not throw an exception
                System.out.println("Resource cleaned up successfully.");
            }
        };

        // Call the focal method
        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            System.err.println("Unexpected error: " + t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithException() {
        // Create a FailableRunnable that simulates an action that throws an exception
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Simulated action exception.");
        };

        // Create a FailableConsumer that handles exceptions
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            // Handle the exception
            System.err.println("Error occurred: " + throwable.getMessage());
        };

        // Create an array of FailableRunnable resources
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup that does not throw an exception
                System.out.println("Resource cleaned up successfully.");
            }
        };

        // Call the focal method
        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            System.err.println("Unexpected error: " + t.getMessage());
        }
    }


}