package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.FunctorException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class NullIsExceptionPredicate_test_2_0_Test {

    private NullIsExceptionPredicate<String> nullIsExceptionPredicate;

    private Predicate<String> mockPredicate;

    @BeforeEach
    public void setUp() {
        mockPredicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return "valid".equals(object);
            }
        };
        nullIsExceptionPredicate = new NullIsExceptionPredicate<>(mockPredicate);
    }

    @Test
    public void testValidInput() {
        assertTrue(nullIsExceptionPredicate.test("valid"));
    }

    @Test
    public void testInvalidInput() {
        assertFalse(nullIsExceptionPredicate.test("invalid"));
    }

    @Test
    public void testNullInputThrowsException() {
        Exception exception = assertThrows(FunctorException.class, () -> {
            nullIsExceptionPredicate.test(null);
        });
        assertEquals("Input Object must not be null", exception.getMessage());
    }
}
