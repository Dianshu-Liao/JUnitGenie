package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.apache.commons.lang3.builder.DiffExclude;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import static org.junit.Assert.assertFalse;

public class builder_ReflectionDiffBuilder_accept_Field_cfg_path_1_Test {

    private ReflectionDiffBuilder builder;

    @org.junit.Before
    public void setUp() {
        // Initialize ReflectionDiffBuilder with an excludeFieldsNames array
        builder = new ReflectionDiffBuilder(new Object(), new Object(), null);
        setExcludeFieldNames(builder, new String[]{"excludedField"});
    }

    // This test ensures that a field is excluded based on the name present in excludeFieldNames
    @org.junit.Test
    public void testAcceptFieldIsExcluded() {
        try {
            Field field = TestClass.class.getDeclaredField("excludedField");
            Method acceptMethod = ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class);
            acceptMethod.setAccessible(true);

            boolean result = (Boolean) acceptMethod.invoke(builder, field);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Additional tests can be added to test other conditions

    private void setExcludeFieldNames(ReflectionDiffBuilder builder, String[] excludeFieldNames) {
        try {
            Field field = ReflectionDiffBuilder.class.getDeclaredField("excludeFieldNames");
            field.setAccessible(true);
            field.set(builder, excludeFieldNames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class TestClass {
        private String excludedField;
    }

}