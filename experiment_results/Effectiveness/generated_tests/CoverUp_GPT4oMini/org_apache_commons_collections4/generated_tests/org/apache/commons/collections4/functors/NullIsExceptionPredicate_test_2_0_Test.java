package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class NullIsExceptionPredicate_test_2_0_Test {

    private Predicate<Object> mockPredicate;

    private NullIsExceptionPredicate nullIsExceptionPredicate;

    @BeforeEach
    public void setUp() {
        mockPredicate = mock(Predicate.class);
        nullIsExceptionPredicate = new NullIsExceptionPredicate(mockPredicate);
    }

    @Test
    public void testWithNonNullInput() {
        Object input = new Object();
        when(mockPredicate.test(input)).thenReturn(true);
        boolean result = nullIsExceptionPredicate.test(input);
        assertTrue(result);
        verify(mockPredicate).test(input);
    }

    @Test
    public void testWithNullInput() {
        Exception exception = assertThrows(FunctorException.class, () -> {
            nullIsExceptionPredicate.test(null);
        });
        assertEquals("Input Object must not be null", exception.getMessage());
    }

    @Test
    public void testWithNonNullInputFalse() {
        Object input = new Object();
        when(mockPredicate.test(input)).thenReturn(false);
        boolean result = nullIsExceptionPredicate.test(input);
        assertFalse(result);
        verify(mockPredicate).test(input);
    }
}
