package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Predicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FilterListIterator_hasNext_5_1_Test {

    private ListIterator<String> mockIterator;

    private Predicate<String> mockPredicate;

    private FilterListIterator<String> filterListIterator;

    @BeforeEach
    void setUp() {
        mockIterator = mock(ListIterator.class);
        mockPredicate = mock(Predicate.class);
        filterListIterator = new FilterListIterator<>(mockIterator, mockPredicate);
    }

    @Test
    void testHasNext_WhenNextObjectSet_ReturnsTrue() throws Exception {
        setPrivateField(filterListIterator, "nextObjectSet", true);
        assertTrue(filterListIterator.hasNext());
    }

//    @Test
//    void testHasNext_WhenNextObjectNotSet_CallsSetNextObject() throws Exception {
//        setPrivateField(filterListIterator, "nextObjectSet", false);
//        when(mockIterator.hasNext()).thenReturn(true);
//        when(mockIterator.next()).thenReturn("item");
//        when(mockPredicate.evaluate("item")).thenReturn(true);
//        assertTrue(filterListIterator.hasNext());
//        verify(mockIterator).next();
//    }

    @Test
    void testHasNext_WhenNoNextObject_ReturnsFalse() throws Exception {
        setPrivateField(filterListIterator, "nextObjectSet", false);
        when(mockIterator.hasNext()).thenReturn(false);
        assertFalse(filterListIterator.hasNext());
    }

//    @Test
//    void testHasNext_WhenPredicateFails_ReturnsFalse() throws Exception {
//        setPrivateField(filterListIterator, "nextObjectSet", false);
//        when(mockIterator.hasNext()).thenReturn(true);
//        when(mockIterator.next()).thenReturn("item");
//        when(mockPredicate.evaluate("item")).thenReturn(false);
//        assertFalse(filterListIterator.hasNext());
//    }

    @Test
    void testHasNext_WhenNoMoreElements_ThrowsNoSuchElementException() throws Exception {
        setPrivateField(filterListIterator, "nextObjectSet", false);
        when(mockIterator.hasNext()).thenReturn(true);
        when(mockIterator.next()).thenThrow(new NoSuchElementException());
        assertThrows(NoSuchElementException.class, () -> filterListIterator.hasNext());
    }

    @Test
    void testHasNext_WhenPredicateSucceedsWithMultipleElements() throws Exception {
        setPrivateField(filterListIterator, "nextObjectSet", false);
        when(mockIterator.hasNext()).thenReturn(true, true, false);
        when(mockIterator.next()).thenReturn("item1", "item2");
        when(mockPredicate.evaluate("item1")).thenReturn(false);
        when(mockPredicate.evaluate("item2")).thenReturn(true);
        assertTrue(filterListIterator.hasNext());
        verify(mockIterator, times(2)).next();
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
