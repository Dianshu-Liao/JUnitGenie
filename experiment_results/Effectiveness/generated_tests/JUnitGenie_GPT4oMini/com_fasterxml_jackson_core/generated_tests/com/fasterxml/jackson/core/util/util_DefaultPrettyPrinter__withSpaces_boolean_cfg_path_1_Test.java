package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Separators;
import com.fasterxml.jackson.core.util.Separators.Spacing;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class util_DefaultPrettyPrinter__withSpaces_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void test_withSpaces() {
        try {
            // Create an instance of DefaultPrettyPrinter
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter();

            // Create a valid instance of Separators
            Separators separators = new Separators();

            // Set the _separators field using reflection
            java.lang.reflect.Field separatorsField = DefaultPrettyPrinter.class.getDeclaredField("_separators");
            separatorsField.setAccessible(true);
            separatorsField.set(printer, separators);

            // Call the _withSpaces method using reflection
            Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
            method.setAccessible(true);

            // Test with state = true
            DefaultPrettyPrinter resultTrue = (DefaultPrettyPrinter) method.invoke(printer, true);
            assertNotNull(resultTrue);
            assertTrue(resultTrue._spacesInObjectEntries);

            // Test with state = false
            DefaultPrettyPrinter resultFalse = (DefaultPrettyPrinter) method.invoke(printer, false);
            assertNotNull(resultFalse);
            assertFalse(resultFalse._spacesInObjectEntries);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    }

}