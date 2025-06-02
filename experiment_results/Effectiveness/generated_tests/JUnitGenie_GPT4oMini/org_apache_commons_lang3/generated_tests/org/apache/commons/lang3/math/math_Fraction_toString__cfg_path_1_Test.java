package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_Fraction_toString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToString() {
        try {
            // Create an instance of Fraction using reflection to access the private constructor
            java.lang.reflect.Constructor<Fraction> constructor = Fraction.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            Fraction fraction = constructor.newInstance(1, 2); // Example values for numerator and denominator

            // Call the toString method
            String result = fraction.toString();

            // Verify the output
            assertEquals("1/2", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}