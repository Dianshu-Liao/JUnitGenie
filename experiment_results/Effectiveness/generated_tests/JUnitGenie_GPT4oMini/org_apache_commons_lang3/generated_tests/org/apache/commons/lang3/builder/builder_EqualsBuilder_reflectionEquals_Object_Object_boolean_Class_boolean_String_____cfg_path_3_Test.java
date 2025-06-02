package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class builder_EqualsBuilder_reflectionEquals_Object_Object_boolean_Class_boolean_String_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testReflectionEquals_SameObjects() {
        Object obj = new Object();
        boolean result = EqualsBuilder.reflectionEquals(obj, obj, false, null, false);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testReflectionEquals_NullLhs() {
        Object lhs = null;
        Object rhs = new Object();
        boolean result = EqualsBuilder.reflectionEquals(lhs, rhs, false, null, false);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testReflectionEquals_NullRhs() {
        Object lhs = new Object();
        Object rhs = null;
        boolean result = EqualsBuilder.reflectionEquals(lhs, rhs, false, null, false);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testReflectionEquals_DifferentObjects() {
        Object lhs = new Object();
        Object rhs = new Object();
        boolean result = EqualsBuilder.reflectionEquals(lhs, rhs, false, null, false);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testReflectionEquals_ExcludeFields() {
        Object lhs = new TestClass("value1");
        Object rhs = new TestClass("value2");
        boolean result = EqualsBuilder.reflectionEquals(lhs, rhs, false, TestClass.class, false, "fieldToExclude");
        assertFalse(result);
    }

    private static class TestClass {
        private String fieldToExclude;

        public TestClass(String fieldToExclude) {
            this.fieldToExclude = fieldToExclude;
        }
    }

}