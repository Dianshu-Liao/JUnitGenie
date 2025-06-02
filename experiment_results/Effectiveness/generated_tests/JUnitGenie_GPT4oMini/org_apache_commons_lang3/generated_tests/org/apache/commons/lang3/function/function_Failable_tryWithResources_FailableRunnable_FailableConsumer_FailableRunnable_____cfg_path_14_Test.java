package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Implementing FailableRunnable for the action parameter
        FailableRunnable<Throwable> action = () -> {
            // Simulate some action that does not throw an exception
            System.out.println("Action executed successfully.");
        };

        // Implementing FailableConsumer for the errorHandler parameter
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            System.err.println("Error handled: " + throwable.getMessage());
        };

        // Implementing FailableRunnable for the resources parameter
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup that does not throw an exception
                System.out.println("Resource cleanup successful.");
            }
        };

        try {
            // Calling the focal method
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable throwable) {
            // Handle unexpected exceptions
            System.err.println("Unexpected error: " + throwable.getMessage());
        }
    }
    
    @Test(timeout = 4000)
    public void testTryWithResourcesWithException() {
        // Implementing FailableRunnable for the action parameter that throws an exception
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Intentional Exception in action.");
        };

        // Implementing FailableConsumer for the errorHandler parameter
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            System.err.println("Error handled: " + throwable.getMessage());
        };

        // Resources that will execute without issue
        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup that executes successfully
                System.out.println("Resource cleanup successful.");
            }
        };

        try {
            // Calling the focal method with an action that throws an exception
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable throwable) {
            // Expect the errorHandler to run on exception, this catch block for unexpected cases
            System.err.println("Unexpected error: " + throwable.getMessage());
        }
    }


}