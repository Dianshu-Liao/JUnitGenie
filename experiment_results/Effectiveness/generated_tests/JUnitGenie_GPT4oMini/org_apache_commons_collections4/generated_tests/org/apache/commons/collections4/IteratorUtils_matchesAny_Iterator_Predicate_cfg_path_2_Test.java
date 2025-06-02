package org.apache.commons.collections4;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class IteratorUtils_matchesAny_Iterator_Predicate_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMatchesAnyWithTruePredicate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 0; // Always true for positive integers
            }
        };

        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertTrue(result); // Expecting true since all elements are positive
    }

    @Test(timeout = 4000)
    public void testMatchesAnyWithFalsePredicate() {
        List<Integer> list = Arrays.asList(-1, -2, -3);
        Iterator<Integer> iterator = list.iterator();
        
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 0; // Always false for negative integers
            }
        };

        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertTrue(!result); // Expecting false since all elements are negative
    }


}