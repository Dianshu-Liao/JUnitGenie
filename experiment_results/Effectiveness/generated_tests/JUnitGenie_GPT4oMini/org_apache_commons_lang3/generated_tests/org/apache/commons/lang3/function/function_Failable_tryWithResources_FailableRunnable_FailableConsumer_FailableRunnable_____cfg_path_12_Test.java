package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate some action that does not throw an exception
            System.out.println("Action executed successfully.");
        };

        FailableConsumer<Throwable, Throwable> errorHandler = (Throwable t) -> {
            // Handle the error
            System.err.println("Error occurred: " + t.getMessage());
        };

        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup that does not throw an exception
                System.out.println("Resource cleaned up successfully.");
            }
        };

        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            System.err.println("Unexpected exception: " + t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithException() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate an action that throws an exception
            throw new RuntimeException("Simulated action exception");
        };

        FailableConsumer<Throwable, Throwable> errorHandler = (Throwable t) -> {
            // Handle the error
            System.err.println("Error occurred: " + t.getMessage());
        };

        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup that throws an exception
                throw new RuntimeException("Simulated resource cleanup exception");
            }
        };

        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            System.err.println("Unexpected exception: " + t.getMessage());
        }
    }


}