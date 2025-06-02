package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        // Create a FailableRunnable that will throw an exception
        FailableRunnable<Throwable> action = () -> {
            throw new RuntimeException("Action failed");
        };

        // Create a FailableConsumer that handles the exception
        FailableConsumer<Throwable, Throwable> errorHandler = (Throwable th) -> {
            // Handle the error
            System.out.println("Error handled: " + th.getMessage());
        };

        // Create a FailableRunnable resource that will run successfully
        FailableRunnable<Throwable> resource = () -> {
            System.out.println("Resource executed successfully");
        };

        // Call the tryWithResources method with the resource and action
        try {
            Failable.tryWithResources(resource, action);
        } catch (Throwable t) {
            // Handle the rethrown exception
            System.out.println("Exception rethrown: " + t.getMessage());
        }
    }

}