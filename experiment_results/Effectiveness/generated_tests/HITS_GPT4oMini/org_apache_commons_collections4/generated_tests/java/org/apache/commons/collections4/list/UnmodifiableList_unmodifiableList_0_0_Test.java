package org.apache.commons.collections4.list;

import java.util.Arrays;
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
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;

public class UnmodifiableList_unmodifiableList_0_0_Test {

    @Test
    public void testUnmodifiableList_WithModifiableList() {
        List<String> modifiableList = Arrays.asList("A", "B", "C");
        List<String> unmodifiableList = UnmodifiableList.unmodifiableList(modifiableList);
        // Verify that the returned list is unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableList.add("D"));
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableList.remove("A"));
    }

    @Test
    public void testUnmodifiableList_WithUnmodifiableList() {
        List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList("X", "Y", "Z"));
        List<String> result = UnmodifiableList.unmodifiableList(unmodifiableList);
        // Verify that the returned list is the same instance as the input
        assertSame(unmodifiableList, result);
    }

    @Test
    public void testUnmodifiableList_WithEmptyList() {
        List<String> emptyList = Collections.emptyList();
        List<String> unmodifiableList = UnmodifiableList.unmodifiableList(emptyList);
        // Verify that the returned list is unmodifiable and empty
        assertTrue(unmodifiableList.isEmpty());
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableList.add("D"));
    }

    @Test
    public void testUnmodifiableList_WithNullList() {
        assertThrows(NullPointerException.class, () -> UnmodifiableList.unmodifiableList(null));
    }
}
