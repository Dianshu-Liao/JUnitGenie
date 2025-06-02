package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

class InheritanceUtils_distance_0_0_Test {

    @Test
    void testDistanceWithNullChild() {
        assertEquals(-1, InheritanceUtils.distance(null, Object.class));
    }

    @Test
    void testDistanceWithNullParent() {
        assertEquals(-1, InheritanceUtils.distance(String.class, null));
    }

    @Test
    void testDistanceWithSameClass() {
        assertEquals(0, InheritanceUtils.distance(String.class, String.class));
    }

    @Test
    void testDistanceWithDirectParent() {
        assertEquals(1, InheritanceUtils.distance(String.class, Object.class));
    }

    @Test
    void testDistanceWithIndirectParent() {
        assertEquals(2, InheritanceUtils.distance(String.class, CharSequence.class));
    }

    @Test
    void testDistanceWithNonRelatedClasses() {
        assertEquals(-1, InheritanceUtils.distance(String.class, Integer.class));
    }

    @Test
    void testDistanceWithParentOfParent() {
        assertEquals(3, InheritanceUtils.distance(ArrayList.class, List.class));
    }

    @Test
    void testDistanceWithSameParent() {
        assertEquals(1, InheritanceUtils.distance(ArrayList.class, Collection.class));
    }
}
