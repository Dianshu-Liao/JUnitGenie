package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_24_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Create a FailableRunnable that does not throw any exceptions
        FailableRunnable action = () -> {
            // Action code here
            System.out.println("Action executed successfully.");
        };

        // Create a FailableConsumer that handles exceptions
        FailableConsumer<Throwable, Exception> errorHandler = throwable -> {
            // Handle the exception
            System.err.println("Error occurred: " + throwable.getMessage());
        };

        // Create an array of FailableRunnable resources
        FailableRunnable[] resources = new FailableRunnable[]{
            () -> {
                // Resource code here
                System.out.println("Resource executed successfully.");
            }
        };

        try {
            // Call the focal method
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            System.err.println("Unexpected error: " + t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithException() {
        // Create a FailableRunnable that throws a RuntimeException
        FailableRunnable action = () -> {
            throw new RuntimeException("Test RuntimeException");
        };

        // Create a FailableConsumer that handles exceptions
        FailableConsumer<Throwable, Exception> errorHandler = throwable -> {
            // Handle the exception
            System.err.println("Error occurred: " + throwable.getMessage());
        };

        // Create an array of FailableRunnable resources
        FailableRunnable[] resources = new FailableRunnable[]{
            () -> {
                // Resource code here
                System.out.println("Resource executed successfully.");
            }
        };

        try {
            // Call the focal method
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            System.err.println("Unexpected error: " + t.getMessage());
        }
    }

}