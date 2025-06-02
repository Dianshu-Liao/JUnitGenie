package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class AndPredicate_test_2_0_Test {

    private AndPredicate<String> andPredicate;

    @BeforeEach
    public void setUp() {
        Predicate<String> predicate1 = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                // Example condition
                return object != null && object.length() > 3;
            }
        };
        Predicate<String> predicate2 = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                // Example condition
                return object != null && object.contains("a");
            }
        };
        andPredicate = new AndPredicate<>(predicate1, predicate2);
    }

    @Test
    public void testBothPredicatesTrue() {
        // "apple" is > 3 and contains 'a'
        assertTrue(andPredicate.test("apple"));
    }

    @Test
    public void testFirstPredicateFalse() {
        // "cat" is <= 3
        assertFalse(andPredicate.test("cat"));
    }

    @Test
    public void testSecondPredicateFalse() {
        // "banana" is > 3 but doesn't contain 'a'
        assertFalse(andPredicate.test("banana"));
    }

    @Test
    public void testBothPredicatesFalse() {
        // "dog" is <= 3 and doesn't contain 'a'
        assertFalse(andPredicate.test("dog"));
    }

    @Test
    public void testNullInput() {
        // null input should return false
        assertFalse(andPredicate.test(null));
    }
}
