package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.junit.Test;

public class function_Failable_tryWithResources_FailableRunnable_FailableConsumer_FailableRunnable_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testTryWithResources() {
        FailableRunnable<Throwable> action = new FailableRunnable<Throwable>() {
            @Override
            public void run() throws Throwable {
                // Simulate action that does not throw an exception
                System.out.println("Action is executed successfully.");
            }
        };

        FailableConsumer<Throwable, Throwable> errorHandler = new FailableConsumer<Throwable, Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                // Handle exceptions, this should not throw
                System.err.println("Handled exception: " + throwable.getMessage());
            }
        };

        FailableRunnable<Throwable> resource1 = new FailableRunnable<Throwable>() {
            @Override
            public void run() throws Throwable {
                // Simulate a resource cleanup that does not throw an exception
                System.out.println("Resource 1 cleaned up.");
            }
        };

        FailableRunnable<Throwable> resource2 = new FailableRunnable<Throwable>() {
            @Override
            public void run() throws Throwable {
                // Simulate a resource cleanup that does throw an exception
                throw new RuntimeException("Resource 2 cleanup failed.");
            }
        };

        // Execute tryWithResources with an action, errorHandler, and cleanup resources
        try {
            Failable.tryWithResources(action, errorHandler, resource1, resource2);
        } catch (Throwable t) {
            System.err.println("Caught exception: " + t.getMessage());
        }
    }


}