package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class concurrent_BackgroundInitializer_isStarted__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsStartedWhenFutureIsNull() {
        try {
            // Using reflection to access the protected constructor
            BackgroundInitializer<Object> initializer = 
                (BackgroundInitializer<Object>) BackgroundInitializer.class
                .getDeclaredConstructor().newInstance();

            // Testing the isStarted method when future is null
            boolean result = initializer.isStarted();
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}