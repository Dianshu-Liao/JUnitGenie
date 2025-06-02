package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_Fraction_toString__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToString() {
        try {
            // Create an instance of Fraction using reflection
            java.lang.reflect.Constructor<Fraction> constructor = Fraction.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            Fraction fraction = constructor.newInstance(1, 2); // numerator 1, denominator 2
            
            // Call toString method and assert the expected output
            String result = fraction.toString();
            assertEquals("1/2", result);
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
    }

}