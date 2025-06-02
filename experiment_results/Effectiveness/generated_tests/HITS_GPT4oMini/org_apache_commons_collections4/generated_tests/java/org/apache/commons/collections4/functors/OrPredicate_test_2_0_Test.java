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

public class OrPredicate_test_2_0_Test {

    private Predicate<String> predicate1;

    private Predicate<String> predicate2;

    private OrPredicate<String> orPredicate;

    @BeforeEach
    public void setUp() {
        predicate1 = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return object != null && object.length() > 3;
            }
        };
        predicate2 = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return object != null && object.startsWith("A");
            }
        };
        orPredicate = new OrPredicate<>(predicate1, predicate2);
    }

    @Test
    public void testBothPredicatesFalse() {
        assertFalse(orPredicate.test("abc"));
        assertFalse(orPredicate.test("ab"));
        assertFalse(orPredicate.test(null));
    }

    @Test
    public void testFirstPredicateTrueSecondFalse() {
        assertTrue(orPredicate.test("abcd"));
        assertFalse(orPredicate.test("Bcd"));
    }

    @Test
    public void testFirstPredicateFalseSecondTrue() {
        assertTrue(orPredicate.test("Apple"));
        assertTrue(orPredicate.test("Avocado"));
    }

    @Test
    public void testBothPredicatesTrue() {
        assertTrue(orPredicate.test("Avocado"));
        assertTrue(orPredicate.test("Applesauce"));
    }

    @Test
    public void testEdgeCases() {
        assertFalse(orPredicate.test(""));
        assertFalse(orPredicate.test("A"));
        assertTrue(orPredicate.test("Aloha"));
        assertTrue(orPredicate.test("A123"));
    }
}
