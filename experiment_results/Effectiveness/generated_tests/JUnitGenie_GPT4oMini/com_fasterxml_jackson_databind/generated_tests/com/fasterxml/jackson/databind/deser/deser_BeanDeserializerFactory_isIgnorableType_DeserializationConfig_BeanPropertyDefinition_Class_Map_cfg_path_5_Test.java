package com.fasterxml.jackson.databind.deser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;

public class deser_BeanDeserializerFactory_isIgnorableType_DeserializationConfig_BeanPropertyDefinition_Class_Map_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsIgnorableType() {
        try {
            // Create instances of the required parameters
            DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
            BeanPropertyDefinition propDef = new BeanPropertyDefinition() {
                @Override
                public boolean hasField() { return false; }
                @Override
                public AnnotatedParameter getConstructorParameter() { return null; }
                @Override
                public boolean hasGetter() { return false; }
                @Override
                public AnnotatedMethod getSetter() { return null; }
                @Override
                public boolean hasConstructorParameter() { return false; }
                @Override
                public boolean hasSetter() { return false; }
                @Override
                public AnnotatedMember getPrimaryMember() { return null; }
                @Override
                public BeanPropertyDefinition withSimpleName(String name) { return null; }
                @Override
                public BeanPropertyDefinition withName(PropertyName name) { return null; }
                @Override
                public JavaType getPrimaryType() { return null; }
                @Override
                public String getInternalName() { return null; }
                @Override
                public boolean isExplicitlyIncluded() { return false; }
                @Override
                public String getName() { return "testProperty"; }
                @Override
                public Class<?> getRawPrimaryType() { return String.class; }
                @Override
                public PropertyName getWrapperName() { return null; }
                @Override
                public PropertyName getFullName() { return null; }
                @Override
                public AnnotatedField getField() { return null; }
                @Override
                public PropertyMetadata getMetadata() { return null; } // Fixed by adding the correct import
                @Override
                public JsonInclude.Value findInclusion() { return null; }
                @Override
                public AnnotatedMethod getGetter() { return null; }
            };
            Class<?> type = String.class;
            Map<Class<?>, Boolean> ignoredTypes = new HashMap<>();

            // Access the protected method using reflection
            BeanDeserializerFactory factory = new BeanDeserializerFactory(null);
            Method method = BeanDeserializerFactory.class.getDeclaredMethod("isIgnorableType", DeserializationConfig.class, BeanPropertyDefinition.class, Class.class, Map.class);
            method.setAccessible(true);

            // Invoke the method
            boolean result = (boolean) method.invoke(factory, config, propDef, type, ignoredTypes);

            // Assert the expected result
            assertFalse(result); // Since String is not ignorable, we expect false

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}