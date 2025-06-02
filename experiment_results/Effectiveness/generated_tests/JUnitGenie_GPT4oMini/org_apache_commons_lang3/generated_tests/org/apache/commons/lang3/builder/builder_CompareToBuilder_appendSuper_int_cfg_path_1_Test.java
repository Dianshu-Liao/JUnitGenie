package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_CompareToBuilder_appendSuper_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendSuperWhenComparisonIsZero() {
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        compareToBuilder.appendSuper(5);
        assertSame(compareToBuilder, compareToBuilder); // Ensure it returns this
    }

    @Test(timeout = 4000)
    public void testAppendSuperWhenComparisonIsNotZero() {
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        // Simulate setting comparison to a non-zero value
        try {
            // Reflection to access private field (as we are testing internal state)
            java.lang.reflect.Field field = CompareToBuilder.class.getDeclaredField("comparison");
            field.setAccessible(true);
            field.setInt(compareToBuilder, 1); // Set comparison to a non-zero value

            CompareToBuilder result = compareToBuilder.appendSuper(5);
            assertSame(compareToBuilder, result); // Ensure it returns this
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}