package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class AndPredicate_test_2_0_Test {

    private Predicate<String> predicate1;

    private Predicate<String> predicate2;

    private AndPredicate andPredicate;

    @BeforeEach
    public void setUp() {
        predicate1 = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                // Example condition
                return object != null && object.length() > 3;
            }
        };
        predicate2 = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                // Example condition
                return object != null && object.startsWith("A");
            }
        };
        andPredicate = new AndPredicate(predicate1, predicate2);
    }

    @Test
    public void testBothPredicatesTrue() {
        assertTrue(andPredicate.test("Apple"));
    }

    @Test
    public void testFirstPredicateFalse() {
        assertFalse(andPredicate.test("Cat"));
    }

    @Test
    public void testSecondPredicateFalse() {
        assertFalse(andPredicate.test("Ant"));
    }

    @Test
    public void testBothPredicatesFalse() {
        assertFalse(andPredicate.test("Dog"));
    }

    @Test
    public void testNullInput() {
        assertFalse(andPredicate.test(null));
    }

    @Test
    public void testGetPredicates() {
        Predicate<? super String>[] predicates = andPredicate.getPredicates();
        assertEquals(2, predicates.length);
        assertSame(predicate1, predicates[0]);
        assertSame(predicate2, predicates[1]);
    }

    @Test
    public void testPrivateMethodReflection() throws Exception {
        Method testMethod = AndPredicate.class.getDeclaredMethod("test", Object.class);
        testMethod.setAccessible(true);
        // Testing with reflection
        assertTrue((Boolean) testMethod.invoke(andPredicate, "Apple"));
        assertFalse((Boolean) testMethod.invoke(andPredicate, "Cat"));
    }
}
