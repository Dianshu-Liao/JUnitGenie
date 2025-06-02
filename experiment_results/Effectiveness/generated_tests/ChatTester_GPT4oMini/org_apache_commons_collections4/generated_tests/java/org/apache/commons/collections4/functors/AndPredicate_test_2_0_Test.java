package org.apache.commons.collections4.functors;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

@ExtendWith(MockitoExtension.class)
public class AndPredicate_test_2_0_Test {

    private AndPredicate<String> andPredicate;

    private org.apache.commons.collections4.Predicate<String> predicate1;

    private org.apache.commons.collections4.Predicate<String> predicate2;

    @BeforeEach
    public void setUp() {
        // Predicate that checks if string is not null and length > 3
        predicate1 = s -> s != null && s.length() > 3;
        predicate2 = s -> s.contains("test");
        andPredicate = new AndPredicate<>(predicate1, predicate2);
    }

    @Test
    public void testBothPredicatesTrue() {
        assertTrue(andPredicate.test("testing"));
    }

    @Test
    public void testFirstPredicateFalse() {
        assertFalse(andPredicate.test("test"));
    }

    @Test
    public void testSecondPredicateFalse() {
        assertFalse(andPredicate.test("abcd"));
    }

    @Test
    public void testBothPredicatesFalse() {
        assertFalse(andPredicate.test("abc"));
    }

    @Test
    public void testNullInput() {
        assertFalse(andPredicate.test(null));
    }
}
