package org.apache.commons.collections4.functors;

import java.util.Arrays;
import java.util.Collection;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.collections4.Predicate;

@ExtendWith(MockitoExtension.class)
public class AnyPredicate_anyPredicate_0_0_Test {

    @Test
    public void testAnyPredicateWithEmptyCollection() {
        Collection<org.apache.commons.collections4.Predicate<Object>> predicates = Arrays.asList();
        org.apache.commons.collections4.Predicate<Object> result = AnyPredicate.anyPredicate(predicates);
        Assertions.assertFalse(result.test(new Object()), "Expected false predicate to return false for any input.");
    }

    @Test
    public void testAnyPredicateWithSinglePredicate() {
        org.apache.commons.collections4.Predicate<Object> singlePredicate = obj -> obj != null;
        Collection<org.apache.commons.collections4.Predicate<Object>> predicates = Arrays.asList(singlePredicate);
        org.apache.commons.collections4.Predicate<Object> result = AnyPredicate.anyPredicate(predicates);
        Assertions.assertTrue(result.test(new Object()), "Expected single predicate to return true for non-null input.");
        Assertions.assertFalse(result.test(null), "Expected single predicate to return false for null input.");
    }

    @Test
    public void testAnyPredicateWithMultiplePredicates() {
        org.apache.commons.collections4.Predicate<Object> predicate1 = obj -> obj instanceof String;
        org.apache.commons.collections4.Predicate<Object> predicate2 = obj -> obj instanceof Integer;
        Collection<org.apache.commons.collections4.Predicate<Object>> predicates = Arrays.asList(predicate1, predicate2);
        org.apache.commons.collections4.Predicate<Object> result = AnyPredicate.anyPredicate(predicates);
        Assertions.assertTrue(result.test("test"), "Expected composite predicate to return true for String input.");
        Assertions.assertTrue(result.test(123), "Expected composite predicate to return true for Integer input.");
        Assertions.assertFalse(result.test(45.67), "Expected composite predicate to return false for Double input.");
    }

    @Test
    public void testAnyPredicateWithNullCollection() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            AnyPredicate.anyPredicate((Collection<? extends org.apache.commons.collections4.Predicate<Object>>) null);
        }, "Expected NullPointerException for null collection.");
    }
}
