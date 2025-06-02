package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class concurrent_BackgroundInitializer_isStarted__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsStartedWhenFutureIsNull() {
        try {
            // Use reflection to access the protected constructor
            BackgroundInitializer<Object> initializer = 
                (BackgroundInitializer<Object>) BackgroundInitializer.class
                .getDeclaredConstructor().newInstance();

            // Call the isStarted method
            boolean result = initializer.isStarted();

            // Assert that the result is false since future is null
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}