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

public class OrPredicate_test_2_0_Test {

    private Predicate<String> predicate1;

    private Predicate<String> predicate2;

    private OrPredicate<String> orPredicate;

    @BeforeEach
    public void setUp() {
        predicate1 = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return "test".equals(object);
            }
        };
        predicate2 = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return "example".equals(object);
            }
        };
        orPredicate = new OrPredicate<>(predicate1, predicate2);
    }

    @Test
    public void testPredicate1True() {
        assertTrue(orPredicate.test("test"));
    }

    @Test
    public void testPredicate2True() {
        assertTrue(orPredicate.test("example"));
    }

    @Test
    public void testBothPredicatesFalse() {
        assertFalse(orPredicate.test("notMatching"));
    }

    @Test
    public void testNullInput() {
        assertFalse(orPredicate.test(null));
    }

    @Test
    public void testGetPredicates() {
        Predicate<? super String>[] predicates = orPredicate.getPredicates();
        assertEquals(2, predicates.length);
        assertSame(predicate1, predicates[0]);
        assertSame(predicate2, predicates[1]);
    }

    @Test
    public void testPrivateMethodReflection() throws Exception {
        Method testMethod = OrPredicate.class.getDeclaredMethod("test", Object.class);
        testMethod.setAccessible(true);
        // Testing with reflection
        assertTrue((Boolean) testMethod.invoke(orPredicate, "test"));
        assertTrue((Boolean) testMethod.invoke(orPredicate, "example"));
        assertFalse((Boolean) testMethod.invoke(orPredicate, "notMatching"));
        assertFalse((Boolean) testMethod.invoke(orPredicate, null));
    }
}
