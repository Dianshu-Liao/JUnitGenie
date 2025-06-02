package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import org.apache.commons.collections4.collection.PredicatedCollection;

public class PredicatedBag_equals_3_0_Test {

    private Bag<String> mockBag;

    private Predicate<String> mockPredicate;

    private PredicatedBag predicatedBag;

    @BeforeEach
    public void setUp() {
        mockBag = Mockito.mock(Bag.class);
        mockPredicate = Mockito.mock(Predicate.class);
        predicatedBag = new PredicatedBag(mockBag, mockPredicate);
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(predicatedBag.equals(predicatedBag), "Expected equals to return true for the same instance.");
    }

    @Test
    public void testEquals_Null() {
        assertFalse(predicatedBag.equals(null), "Expected equals to return false for null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        Object differentClassObject = new Object();
        assertFalse(predicatedBag.equals(differentClassObject), "Expected equals to return false for different class.");
    }

    @Test
    public void testEquals_EqualBag() {
        Bag<String> anotherMockBag = Mockito.mock(Bag.class);
        Predicate<String> anotherMockPredicate = Mockito.mock(Predicate.class);
        PredicatedBag anotherPredicatedBag = new PredicatedBag(anotherMockBag, anotherMockPredicate);
        Mockito.when(mockBag.equals(anotherMockBag)).thenReturn(true);
        assertTrue(predicatedBag.equals(anotherPredicatedBag), "Expected equals to return true for equal bags.");
    }

    @Test
    public void testEquals_NotEqualBag() {
        Bag<String> anotherMockBag = Mockito.mock(Bag.class);
        Predicate<String> anotherMockPredicate = Mockito.mock(Predicate.class);
        PredicatedBag anotherPredicatedBag = new PredicatedBag(anotherMockBag, anotherMockPredicate);
        Mockito.when(mockBag.equals(anotherMockBag)).thenReturn(false);
        assertFalse(predicatedBag.equals(anotherPredicatedBag), "Expected equals to return false for not equal bags.");
    }
}
