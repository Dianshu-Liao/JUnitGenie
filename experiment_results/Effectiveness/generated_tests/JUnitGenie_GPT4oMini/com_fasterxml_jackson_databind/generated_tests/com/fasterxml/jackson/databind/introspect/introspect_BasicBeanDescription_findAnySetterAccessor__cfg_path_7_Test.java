package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.lang.reflect.Constructor;

public class introspect_BasicBeanDescription_findAnySetterAccessor__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testFindAnySetterAccessorWithValidAnySetterMethod() {
        // Arrange
        POJOPropertiesCollector mockCollector = mock(POJOPropertiesCollector.class);
        AnnotatedMethod mockAnnotatedMethod = mock(AnnotatedMethod.class);
        
        when(mockAnnotatedMethod.getRawParameterType(0)).thenReturn((Class) String.class);
        when(mockCollector.getAnySetterMethod()).thenReturn(mockAnnotatedMethod);
        
        // Use reflection to create an instance of BasicBeanDescription
        BasicBeanDescription beanDescription = null;
        try {
            Constructor<BasicBeanDescription> constructor = BasicBeanDescription.class.getDeclaredConstructor(POJOPropertiesCollector.class);
            constructor.setAccessible(true);
            beanDescription = constructor.newInstance(mockCollector);
        } catch (Exception e) {
            fail("Failed to create BasicBeanDescription instance");
        }

        // Act
        AnnotatedMember result = null;
        try {
            result = beanDescription.findAnySetterAccessor();
        } catch (IllegalArgumentException e) {
            fail("Method threw IllegalArgumentException: " + e.getMessage());
        }

        // Assert
        assertEquals(mockAnnotatedMethod, result);
    }

    @Test(timeout = 4000)
    public void testFindAnySetterAccessorWithInvalidAnySetterMethod() {
        // Arrange
        POJOPropertiesCollector mockCollector = mock(POJOPropertiesCollector.class);
        AnnotatedMethod mockAnnotatedMethod = mock(AnnotatedMethod.class);
        
        when(mockAnnotatedMethod.getRawParameterType(0)).thenReturn((Class) Integer.class);
        when(mockCollector.getAnySetterMethod()).thenReturn(mockAnnotatedMethod);
        
        // Use reflection to create an instance of BasicBeanDescription
        BasicBeanDescription beanDescription = null;
        try {
            Constructor<BasicBeanDescription> constructor = BasicBeanDescription.class.getDeclaredConstructor(POJOPropertiesCollector.class);
            constructor.setAccessible(true);
            beanDescription = constructor.newInstance(mockCollector);
        } catch (Exception e) {
            fail("Failed to create BasicBeanDescription instance");
        }

        // Act
        try {
            beanDescription.findAnySetterAccessor();
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Assert
            assertTrue(e.getMessage().contains("Invalid 'any-setter' annotation on method"));
        }
    }

    @Test(timeout = 4000)
    public void testFindAnySetterAccessorWhenNoAnySetterMethod() {
        // Arrange
        POJOPropertiesCollector mockCollector = mock(POJOPropertiesCollector.class);
        when(mockCollector.getAnySetterMethod()).thenReturn(null);
        when(mockCollector.getAnySetterField()).thenReturn(null);
        
        // Use reflection to create an instance of BasicBeanDescription
        BasicBeanDescription beanDescription = null;
        try {
            Constructor<BasicBeanDescription> constructor = BasicBeanDescription.class.getDeclaredConstructor(POJOPropertiesCollector.class);
            constructor.setAccessible(true);
            beanDescription = constructor.newInstance(mockCollector);
        } catch (Exception e) {
            fail("Failed to create BasicBeanDescription instance");
        }

        // Act
        AnnotatedMember result = beanDescription.findAnySetterAccessor();

        // Assert
        assertNull(result);
    }


}