package org.apache.commons.lang3.reflect;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.lang3.BooleanUtils;

public class InheritanceUtils_distance_0_0_Test {

    // Test with two identical classes
    @Test
    public void testDistance_SameClass() {
        assertEquals(0, InheritanceUtils.distance(String.class, String.class));
    }

    // Test with child and parent class
    @Test
    public void testDistance_ChildToParent() {
        assertEquals(1, InheritanceUtils.distance(String.class, Object.class));
    }

    // Test with grandparent class
    @Test
    public void testDistance_ChildToGrandparent() {
        assertEquals(2, InheritanceUtils.distance(String.class, CharSequence.class));
    }

    // Test with unrelated classes
    @Test
    public void testDistance_UnrelatedClasses() {
        assertEquals(-1, InheritanceUtils.distance(String.class, Integer.class));
    }

    // Test with null child class
    @Test
    public void testDistance_NullChild() {
        assertEquals(-1, InheritanceUtils.distance(null, Object.class));
    }

    // Test with null parent class
    @Test
    public void testDistance_NullParent() {
        assertEquals(-1, InheritanceUtils.distance(String.class, null));
    }

    // Test with both null classes
    @Test
    public void testDistance_BothNull() {
        assertEquals(-1, InheritanceUtils.distance(null, null));
    }

    // Test with a class and its direct superclass
    @Test
    public void testDistance_DirectSuperclass() {
        assertEquals(1, InheritanceUtils.distance(Exception.class, Throwable.class));
    }

    // Test with a class and a superclass that is not direct
    @Test
    public void testDistance_NonDirectSuperclass() {
        assertEquals(2, InheritanceUtils.distance(IllegalArgumentException.class, Throwable.class));
    }
}
