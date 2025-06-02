package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Successful action
        FailableRunnable action = () -> {
            // Successful execution
            System.out.println("Action executed successfully.");
        };

        // Error handler that handles Throwable
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            // Handle exception (if any)
            System.out.println("Error occurred: " + throwable.getMessage());
        };

        // Resource runnable
        FailableRunnable resource = () -> {
            System.out.println("Resource cleaned up successfully.");
        };

        // Invoking the focal method
        try {
            Failable.tryWithResources(action, errorHandler, resource);
        } catch (Throwable t) {
            // Handle exception if any thrown
            System.out.println("Exception caught: " + t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithError() {
        // Action that throws an exception
        FailableRunnable actionThatThrows = () -> {
            throw new RuntimeException("Intentional error");
        };

        // Error handler
        FailableConsumer<Throwable, Throwable> errorHandler = throwable -> {
            System.out.println("Handled Error: " + throwable.getMessage());
        };

        // Resource runnable
        FailableRunnable resource = () -> {
            System.out.println("Resource cleaned up with potential errors.");
        };

        // Invoking the method to cover error throwing
        try {
            Failable.tryWithResources(actionThatThrows, errorHandler, resource);
        } catch (Throwable t) {
            // Handle the exception thrown during execution
            System.out.println("Exception caught: " + t.getMessage());
        }
    }


}