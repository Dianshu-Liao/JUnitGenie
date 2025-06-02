package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.AllPredicate;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.Arrays;
import java.util.Collection;

public class functors_AllPredicate_allPredicate_Predicate_____cfg_path_3_Test {


    @Test(timeout = 4000)
    public void testAllPredicateWithSinglePredicate() {
        Predicate<String> singlePredicate = s -> s.length() > 0;
        Predicate<String>[] predicates = new Predicate[]{singlePredicate}; 
        Predicate<String> result = AllPredicate.allPredicate(Arrays.asList(predicates));
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAllPredicateWithMultiplePredicates() {
        Predicate<String> predicate1 = s -> s.length() > 0;
        Predicate<String> predicate2 = s -> s.startsWith("A");
        Predicate<String>[] predicates = new Predicate[]{predicate1, predicate2}; 
        Predicate<String> result = AllPredicate.allPredicate(Arrays.asList(predicates));
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAllPredicateWithNullArray() {
        try {
            AllPredicate.allPredicate((Collection<? extends Predicate<String>>) null);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}
