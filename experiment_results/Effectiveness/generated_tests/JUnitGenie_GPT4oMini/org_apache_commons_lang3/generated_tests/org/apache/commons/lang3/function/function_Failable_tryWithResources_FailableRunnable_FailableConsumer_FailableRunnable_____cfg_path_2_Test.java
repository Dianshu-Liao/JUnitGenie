package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Implementation of FailableRunnable that does not throw an exception
        FailableRunnable<Throwable> action = () -> {
            // Action code here
            System.out.println("Action executed successfully.");
        };

        // Implementation of FailableConsumer that processes the Throwable
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            // Handle the exception
            System.out.println("Handling error: " + throwable.getMessage());
        };

        // Implementation of FailableRunnable that can be used in resources
        FailableRunnable<Throwable> resource = () -> {
            // Resource cleanup code here
            System.out.println("Resource cleaned up.");
        };

        // Create an array of resources
        FailableRunnable<Throwable>[] resources = new FailableRunnable[] {resource};

        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // handle or assert here if needed
            System.out.println("Exception caught during execution: " + t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithError() {
        // FailableRunnable that throws an exception
        FailableRunnable<Throwable> actionWithError = () -> {
            throw new RuntimeException("Intentional failure in action.");
        };

        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            System.out.println("Caught an error: " + throwable.getMessage());
        };

        FailableRunnable<Throwable> resource = () -> {
            System.out.println("Resource cleaned up after error.");
        };

        FailableRunnable<Throwable>[] resources = new FailableRunnable[] {resource};

        try {
            Failable.tryWithResources(actionWithError, errorHandler, resources);
        } catch (Throwable t) {
            System.out.println("Exception caught during execution: " + t.getMessage());
        }
    }


}