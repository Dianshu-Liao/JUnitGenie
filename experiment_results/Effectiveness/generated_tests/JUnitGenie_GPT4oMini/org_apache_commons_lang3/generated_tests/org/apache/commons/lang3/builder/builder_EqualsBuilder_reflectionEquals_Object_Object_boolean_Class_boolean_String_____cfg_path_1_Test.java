package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class builder_EqualsBuilder_reflectionEquals_Object_Object_boolean_Class_boolean_String_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReflectionEquals_SameObjects() {
        Object obj = new Object();
        boolean result = EqualsBuilder.reflectionEquals(obj, obj, false, null, false);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testReflectionEquals_NullAndNonNull() {
        Object obj = new Object();
        boolean result = EqualsBuilder.reflectionEquals(obj, null, false, null, false);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testReflectionEquals_NullAndNull() {
        boolean result = EqualsBuilder.reflectionEquals(null, null, false, null, false);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testReflectionEquals_DifferentObjects() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        boolean result = EqualsBuilder.reflectionEquals(obj1, obj2, false, null, false);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testReflectionEquals_WithExcludeFields() {
        Object obj1 = new TestClass("value1", "value2");
        Object obj2 = new TestClass("value1", "value3");
        boolean result = EqualsBuilder.reflectionEquals(obj1, obj2, false, TestClass.class, false, "field2");
        assertTrue(result);
    }

    private static class TestClass {
        private String field1;
        private String field2;

        public TestClass(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }
    }

}