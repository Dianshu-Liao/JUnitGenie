package org.apache.commons.collections4.functors;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.collections4.Predicate;

@ExtendWith(MockitoExtension.class)
public final class NullIsExceptionPredicate_test_2_1_Test {

    private NullIsExceptionPredicate<String> nullIsExceptionPredicate;

    private org.apache.commons.collections4.Predicate<String> mockPredicate;

    @BeforeEach
    public void setUp() {
        mockPredicate = mock(org.apache.commons.collections4.Predicate.class);
        nullIsExceptionPredicate = new NullIsExceptionPredicate<>(mockPredicate);
    }

    @Test
    public void testWithNullInputShouldThrowFunctorException() {
        Exception exception = assertThrows(FunctorException.class, () -> {
            nullIsExceptionPredicate.test(null);
        });
        assertEquals("Input Object must not be null", exception.getMessage());
    }

    @Test
    public void testWithNonNullInputShouldReturnPredicateResult() {
        String input = "test";
        when(mockPredicate.evaluate(input)).thenReturn(true);
        boolean result = nullIsExceptionPredicate.test(input);
        assertTrue(result);
        verify(mockPredicate).evaluate(input);
    }

    @Test
    public void testWithNonNullInputShouldReturnFalseWhenPredicateReturnsFalse() {
        String input = "test";
        when(mockPredicate.evaluate(input)).thenReturn(false);
        boolean result = nullIsExceptionPredicate.test(input);
        assertFalse(result);
        verify(mockPredicate).evaluate(input);
    }
}
