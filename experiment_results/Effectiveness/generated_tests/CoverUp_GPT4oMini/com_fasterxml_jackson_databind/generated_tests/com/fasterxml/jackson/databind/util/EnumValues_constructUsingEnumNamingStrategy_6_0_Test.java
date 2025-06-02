package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.EnumValues;
import com.fasterxml.jackson.core.SerializableString;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.EnumFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;

class EnumValues_constructUsingEnumNamingStrategy_6_0_Test {

    private enum TestEnum {

        VALUE1, VALUE2
    }

    private static class TestEnumNamingStrategy implements EnumNamingStrategy {

        @Override
        public String convertEnumToExternalName(String name) {
            return name.toLowerCase();
        }
    }

    @Test
    void testConstructUsingEnumNamingStrategy() throws Exception {
        MapperConfig<?> config = Mockito.mock(MapperConfig.class);
        // Change to Class<TestEnum>
        Class<TestEnum> enumClass = TestEnum.class;
        EnumNamingStrategy namingStrategy = new TestEnumNamingStrategy();
        // Invoke the method using reflection
        Method method = EnumValues.class.getDeclaredMethod("constructUsingEnumNamingStrategy", MapperConfig.class, Class.class, EnumNamingStrategy.class);
        method.setAccessible(true);
        EnumValues enumValues = (EnumValues) method.invoke(null, config, enumClass, namingStrategy);
        assertNotNull(enumValues);
        assertEquals(enumClass, enumValues.getEnumClass());
    }
}
