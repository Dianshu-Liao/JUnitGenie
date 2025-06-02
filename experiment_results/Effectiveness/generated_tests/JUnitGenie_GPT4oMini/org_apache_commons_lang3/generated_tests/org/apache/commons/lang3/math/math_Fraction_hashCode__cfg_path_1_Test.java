package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_Fraction_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCodeWhenHashCodeIsZero() {
        try {
            // Create an instance of Fraction using reflection
            java.lang.reflect.Constructor<Fraction> constructor = Fraction.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            Fraction fraction = constructor.newInstance(1, 2); // Example values for numerator and denominator
            
            // Initially, hashCode should be 0
            assertEquals(0, fraction.hashCode());
            
            // Call hashCode to trigger the computation
            int computedHashCode = fraction.hashCode();
            
            // Verify the computed hash code
            int expectedHashCode = 37 * (37 * 17 + 1) + 2; // 1 is numerator, 2 is denominator
            assertEquals(expectedHashCode, computedHashCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}