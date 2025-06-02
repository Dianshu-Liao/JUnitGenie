package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Create a FailableRunnable that simulates an action
        FailableRunnable<Throwable> action = () -> {
            // Simulate some action that could throw an exception
            System.out.println("Executing action...");
            throw new RuntimeException("Action failed");
        };

        // Create a FailableConsumer that handles the exception
        FailableConsumer<Throwable, Throwable> errorHandler = (Throwable t) -> {
            System.out.println("Handling error: " + t.getMessage());
        };

        // Create an array of FailableRunnable resources
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> System.out.println("Resource 1 cleaned up"),
            () -> System.out.println("Resource 2 cleaned up")
        };

        try {
            // Call the focal method
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle the rethrown exception
            System.out.println("Caught rethrown exception: " + t.getMessage());
        }
    }


}