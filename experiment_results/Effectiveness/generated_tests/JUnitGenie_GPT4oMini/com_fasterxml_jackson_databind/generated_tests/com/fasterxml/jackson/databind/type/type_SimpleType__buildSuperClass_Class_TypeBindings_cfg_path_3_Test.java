package com.fasterxml.jackson.databind.type;
import org.junit.Test;
import org.junit.Assert;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.reflect.Method;
import java.util.Collections;

public class type_SimpleType__buildSuperClass_Class_TypeBindings_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testBuildSuperClassWithNullSuperClass() {
        try {
            Class<?> superClass = null;
            TypeBindings b = TypeBindings.create(Collections.emptyList(), Collections.emptyList());
            Method method = SimpleType.class.getDeclaredMethod("_buildSuperClass", Class.class, TypeBindings.class);
            method.setAccessible(true);
            JavaType result = (JavaType) method.invoke(null, superClass, b);
            Assert.assertNull(result);
        } catch (Exception e) {
            Assert.fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testBuildSuperClassWithObjectSuperClass() {
        try {
            Class<?> superClass = Object.class;
            TypeBindings b = TypeBindings.create(Collections.emptyList(), Collections.emptyList());
            Method method = SimpleType.class.getDeclaredMethod("_buildSuperClass", Class.class, TypeBindings.class);
            method.setAccessible(true);
            JavaType result = (JavaType) method.invoke(null, superClass, b);
            Assert.assertNotNull(result);
            // Additional assertions can be performed based on the expected behavior
        } catch (Exception e) {
            Assert.fail("Exception thrown: " + e.getMessage());
        }
    }

}