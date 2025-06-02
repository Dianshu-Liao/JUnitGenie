package com.fasterxml.jackson.databind.deser;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;

public class deser_BeanDeserializerFactory_isIgnorableType_DeserializationConfig_BeanPropertyDefinition_Class_Map_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsIgnorableTypeWithString() {
        try {
            BeanDeserializerFactory factory = new BeanDeserializerFactory(null);
            DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
            BeanPropertyDefinition propDef = new TestBeanPropertyDefinition();
            Class<?> type = String.class;
            Map<Class<?>, Boolean> ignoredTypes = new HashMap<>();

            Method method = BeanDeserializerFactory.class.getDeclaredMethod("isIgnorableType",
                    DeserializationConfig.class, BeanPropertyDefinition.class, Class.class, Map.class);
            method.setAccessible(true);

            boolean result = (boolean) method.invoke(factory, config, propDef, type, ignoredTypes);
            assertFalse(result); // String should not be an ignorable type

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsIgnorableTypeWithPrimitive() {
        try {
            BeanDeserializerFactory factory = new BeanDeserializerFactory(null);
            DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
            BeanPropertyDefinition propDef = new TestBeanPropertyDefinition();
            Class<?> type = int.class; // primitive type
            Map<Class<?>, Boolean> ignoredTypes = new HashMap<>();

            Method method = BeanDeserializerFactory.class.getDeclaredMethod("isIgnorableType",
                    DeserializationConfig.class, BeanPropertyDefinition.class, Class.class, Map.class);
            method.setAccessible(true);

            boolean result = (boolean) method.invoke(factory, config, propDef, type, ignoredTypes);
            assertFalse(result); // Primitive type should not be an ignorable type

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dummy implementation of BeanPropertyDefinition for testing
    private static class TestBeanPropertyDefinition extends BeanPropertyDefinition {
        @Override public boolean hasField() { return false; }
        @Override public AnnotatedParameter getConstructorParameter() { return null; }
        @Override public boolean hasGetter() { return false; }
        @Override public AnnotatedMethod getSetter() { return null; }
        @Override public boolean hasConstructorParameter() { return false; }
        @Override public boolean hasSetter() { return false; }
        @Override public AnnotatedMember getPrimaryMember() { return null; }
        @Override public BeanPropertyDefinition withSimpleName(String name) { return null; }
        @Override public BeanPropertyDefinition withName(PropertyName name) { return null; }
        @Override public JavaType getPrimaryType() { return null; }
        @Override public String getInternalName() { return null; }
        @Override public boolean isExplicitlyIncluded() { return false; }
        @Override public String getName() { return null; }
        @Override public Class<?> getRawPrimaryType() { return null; }
        @Override public PropertyName getWrapperName() { return null; }
        @Override public PropertyName getFullName() { return null; }
        @Override public AnnotatedField getField() { return null; }
        @Override public PropertyMetadata getMetadata() { return null; }
        @Override public JsonInclude.Value findInclusion() { return null; }
        @Override public AnnotatedMethod getGetter() { return null; }
    }

}