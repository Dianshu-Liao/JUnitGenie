package org.apache.commons.collections4.list;

import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Predicate;

class UnmodifiableList_unmodifiableList_0_0_Test {

    @Test
    void testUnmodifiableListWithUnmodifiableInput() {
        List<String> originalList = new ArrayList<>();
        originalList.add("A");
        originalList.add("B");
        List<String> unmodifiableList = Collections.unmodifiableList(originalList);
        List<String> result = UnmodifiableList.unmodifiableList(unmodifiableList);
        assertSame(unmodifiableList, result);
    }

    @Test
    void testUnmodifiableListWithModifiableInput() {
        List<String> originalList = new ArrayList<>();
        originalList.add("A");
        originalList.add("B");
        List<String> result = UnmodifiableList.unmodifiableList(originalList);
        assertNotSame(originalList, result);
        assertEquals(originalList.size(), result.size());
        assertEquals(originalList.get(0), result.get(0));
        assertEquals(originalList.get(1), result.get(1));
    }

    @Test
    void testUnmodifiableListWithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableList.unmodifiableList(null);
        });
    }

    @Test
    void testUnmodifiableListWithEmptyList() {
        List<String> emptyList = new ArrayList<>();
        List<String> result = UnmodifiableList.unmodifiableList(emptyList);
        assertNotSame(emptyList, result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testUnmodifiableListWithSingleElementList() {
        List<String> singleElementList = new ArrayList<>();
        singleElementList.add("A");
        List<String> result = UnmodifiableList.unmodifiableList(singleElementList);
        assertNotSame(singleElementList, result);
        assertEquals(1, result.size());
        assertEquals("A", result.get(0));
    }

    @Test
    void testUnmodifiableListPrivateConstructor() throws Exception {
        Constructor<UnmodifiableList> constructor = UnmodifiableList.class.getDeclaredConstructor(List.class);
        constructor.setAccessible(true);
        List<String> originalList = new ArrayList<>();
        originalList.add("A");
        UnmodifiableList unmodifiableList = constructor.newInstance(originalList);
        assertNotNull(unmodifiableList);
    }
}
