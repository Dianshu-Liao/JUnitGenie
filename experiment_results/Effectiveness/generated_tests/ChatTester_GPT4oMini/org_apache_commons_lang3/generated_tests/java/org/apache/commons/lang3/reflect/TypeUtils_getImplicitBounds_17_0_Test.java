package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.AppendableJoiner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

public class TypeUtils_getImplicitBounds_17_0_Test {

    private TypeUtils typeUtils;

    @BeforeEach
    public void setUp() {
        typeUtils = new TypeUtils();
    }

    @Test
    public void testGetImplicitBounds_WithNonEmptyBounds() throws Exception {
        // Arrange
        TypeVariable<Class<SampleClass>> typeVariable = SampleClass.class.getTypeParameters()[0];
        // Act
        Type[] result = invokeGetImplicitBounds(typeVariable);
        // Assert
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals(Number.class, result[0]);
    }

    @Test
    public void testGetImplicitBounds_WithEmptyBounds() throws Exception {
        // Arrange
        TypeVariable<Class<AnotherSampleClass>> typeVariable = AnotherSampleClass.class.getTypeParameters()[0];
        // Act
        Type[] result = invokeGetImplicitBounds(typeVariable);
        // Assert
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals(Object.class, result[0]);
    }

    @Test
    public void testGetImplicitBounds_WithNullTypeVariable() {
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            typeUtils.getImplicitBounds(null);
        });
        assertEquals("typeVariable", exception.getMessage());
    }

    private Type[] invokeGetImplicitBounds(TypeVariable<?> typeVariable) throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("getImplicitBounds", TypeVariable.class);
        method.setAccessible(true);
        return (Type[]) method.invoke(null, typeVariable);
    }

    // Sample classes to provide type variables for testing
    class SampleClass<T extends Number> {
    }

    class AnotherSampleClass<T> {
    }
}
