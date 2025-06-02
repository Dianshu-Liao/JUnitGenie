package org.apache.commons.lang3.reflect;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.lang3.BooleanUtils;

public class InheritanceUtils_distance_0_0_Test {

    // Test classes for testing
    private static class Grandparent {
    }

    private static class Parent extends Grandparent {
    }

    private static class Child extends Parent {
    }

    private static class Sibling extends Parent {
    }

    private static class Unrelated {
    }

    @Test
    public void testDistance_SameClass() {
        assertEquals(0, InheritanceUtils.distance(Child.class, Child.class));
    }

    @Test
    public void testDistance_ParentToChild() {
        assertEquals(1, InheritanceUtils.distance(Child.class, Parent.class));
    }

    @Test
    public void testDistance_GrandparentToChild() {
        assertEquals(2, InheritanceUtils.distance(Child.class, Grandparent.class));
    }

    @Test
    public void testDistance_ParentToGrandparent() {
        assertEquals(1, InheritanceUtils.distance(Parent.class, Grandparent.class));
    }

    @Test
    public void testDistance_UnrelatedClasses() {
        assertEquals(-1, InheritanceUtils.distance(Child.class, Unrelated.class));
    }

    @Test
    public void testDistance_NullChild() {
        assertEquals(-1, InheritanceUtils.distance(null, Parent.class));
    }

    @Test
    public void testDistance_NullParent() {
        assertEquals(-1, InheritanceUtils.distance(Child.class, null));
    }

    @Test
    public void testDistance_SiblingClasses() {
        assertEquals(1, InheritanceUtils.distance(Sibling.class, Parent.class));
        assertEquals(-1, InheritanceUtils.distance(Sibling.class, Grandparent.class));
    }

    @Test
    public void testDistance_SiblingToChild() {
        assertEquals(-1, InheritanceUtils.distance(Sibling.class, Child.class));
    }

    @Test
    public void testDistance_ChildToUnrelated() {
        assertEquals(-1, InheritanceUtils.distance(Child.class, Unrelated.class));
    }

    @Test
    public void testDistance_GrandchildToSibling() {
        assertEquals(-1, InheritanceUtils.distance(Child.class, Sibling.class));
    }

    @Test
    public void testDistance_SiblingToGrandchild() {
        assertEquals(-1, InheritanceUtils.distance(Sibling.class, Child.class));
    }

    @Test
    public void testDistance_ParentToSelf() {
        assertEquals(0, InheritanceUtils.distance(Parent.class, Parent.class));
    }

    @Test
    public void testDistance_GrandparentToSelf() {
        assertEquals(0, InheritanceUtils.distance(Grandparent.class, Grandparent.class));
    }
}
