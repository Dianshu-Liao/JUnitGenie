package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_58_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Create a FailableRunnable for action that will succeed
        FailableRunnable<Throwable> action = () -> {
            // Action logic here (no exception thrown)
        };

        // Create a FailableConsumer for error handling that simply rethrows the Throwable
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            // Error handling logic here
            throw new RuntimeException(throwable);
        };

        // Create an array of FailableRunnable for resources
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Resource logic here (no exception thrown)
            },
            () -> {
                // More resource logic (throwing no exception)
            }
        };

        try {
            // Execute the tryWithResources method
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handling the thrown exception if it occurs
            System.err.println("Exception occurred: " + t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithThrow() {
        // Create a FailableRunnable for action that will throw an exception
        FailableRunnable<Throwable> action = () -> {
            throw new IllegalArgumentException("Test Exception");
        };

        // Create a FailableConsumer for error handling that will handle the throwable
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            if (throwable instanceof IllegalArgumentException) {
                System.out.println("Caught an IllegalArgumentException: " + throwable.getMessage());
            } else {
                throw new RuntimeException(throwable);
            }
        };

        // Create an array of FailableRunnable for resources
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Resource logic here (no exception thrown)
            }
        };

        try {
            // Execute the tryWithResources method
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handling the thrown exception if it occurs
            System.err.println("Exception occurred: " + t.getMessage());
        }
    }


}