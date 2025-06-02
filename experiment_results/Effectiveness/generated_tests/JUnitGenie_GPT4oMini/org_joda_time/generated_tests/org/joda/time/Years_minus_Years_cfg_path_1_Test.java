package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Constructor;

public class Years_minus_Years_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusWithNonNullYears() {
        try {
            // Instantiate Years using reflection
            Constructor<Years> constructor = Years.class.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            Years yearsToSubtract = constructor.newInstance(5); // Create a Years instance with value 5
            
            Years initialYears = constructor.newInstance(10); // Create a Years instance with value 10
            
            Years result = initialYears.minus(yearsToSubtract);
            Years expected = constructor.newInstance(5); // Expected result should be Years with value 5 (10 - 5)

            assertEquals(expected.getYears(), result.getYears());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMinusWithNullYears() {
        try {
            // Instantiate Years using reflection
            Constructor<Years> constructor = Years.class.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            Years initialYears = constructor.newInstance(10); // Create a Years instance with value 10
            Years result = initialYears.minus(null);
            
            // Since subtracting null should return the same instance
            assertEquals(initialYears.getYears(), result.getYears());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}