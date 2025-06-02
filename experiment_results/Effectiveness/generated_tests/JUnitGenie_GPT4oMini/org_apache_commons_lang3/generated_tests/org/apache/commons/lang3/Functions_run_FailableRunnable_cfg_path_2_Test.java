package org.apache.commons.lang3;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.Functions.FailableRunnable;
import org.junit.Test;

public class Functions_run_FailableRunnable_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRun() {
        // Implementing the FailableRunnable interface
        FailableRunnable<Throwable> runnable = new FailableRunnable<Throwable>() {
            @Override
            public void run() throws Throwable {
                // This block should execute without throwing any exceptions
                System.out.println("Runnable executed successfully.");
            }
        };

        try {
            // Calling the focal method with the implemented runnable
            Functions.run(runnable);
        } catch (Throwable t) {
            // Handle any unexpected exceptions
            t.printStackTrace();
        }
    }


}