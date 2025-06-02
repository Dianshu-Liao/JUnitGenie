package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.stream.Streams;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate action that does not throw an exception
            System.out.println("Action executed.");
        };

        FailableConsumer<Throwable, Throwable> errorHandler = (error) -> {
            // Handle the error by printing
            System.err.println("Error handled: " + error);
        };

        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup that does not throw an exception
                System.out.println("Resource cleaned up.");
            }
        };

        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle the exception thrown from tryWithResources
            System.err.println("Exception caught: " + t);
        }
    }

    @Test(timeout = 4000)
    public void testTryWithResourcesWithError() {
        FailableRunnable<Throwable> action = () -> {
            // Simulate action that throws an unchecked exception
            throw new IllegalArgumentException("Simulated exception in action.");
        };

        FailableConsumer<Throwable, Throwable> errorHandler = (error) -> {
            // Handle the error by printing
            System.err.println("Error handled: " + error);
        };

        FailableRunnable<Throwable>[] resources = new FailableRunnable[]{
            () -> {
                // Simulate resource cleanup that throws an unchecked exception
                throw new RuntimeException("Simulated exception during cleanup.");
            }
        };

        try {
            Failable.tryWithResources(action, errorHandler, resources);
        } catch (Throwable t) {
            // Handle the exception thrown from tryWithResources
            System.err.println("Exception caught: " + t);
        }
    }


}