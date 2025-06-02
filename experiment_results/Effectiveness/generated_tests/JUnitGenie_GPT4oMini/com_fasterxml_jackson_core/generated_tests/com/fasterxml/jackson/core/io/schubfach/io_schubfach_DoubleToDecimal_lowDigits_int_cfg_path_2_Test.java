package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class io_schubfach_DoubleToDecimal_lowDigits_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testLowDigitsWithZero() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<?> clazz = DoubleToDecimal.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            DoubleToDecimal instance = (DoubleToDecimal) constructor.newInstance();

            // Invoke the private method lowDigits with 0
            Method lowDigitsMethod = clazz.getDeclaredMethod("lowDigits", int.class);
            lowDigitsMethod.setAccessible(true);
            lowDigitsMethod.invoke(instance, 0);

            // Since the method cannot execute successfully with the current constraints,
            // we expect no exceptions to be thrown, but we cannot assert any specific behavior.
            // If the method does not throw an exception, the test passes.
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }


}