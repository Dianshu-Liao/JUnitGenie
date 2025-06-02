package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertSame;

public class util_DefaultPrettyPrinter__withSpaces_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void test_withSpaces_changesState() {
        try {
            // Create an instance of DefaultPrettyPrinter
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter();

            // Access the protected method _withSpaces using reflection
            Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
            method.setAccessible(true);

            // Initial state
            boolean initialState = true;
            boolean newState = false;

            // Call the method with a new state
            DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, newState);

            // Assert that the returned object is not the same as the original
            assertSame("The returned printer should not be the same as the original printer.", printer, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}