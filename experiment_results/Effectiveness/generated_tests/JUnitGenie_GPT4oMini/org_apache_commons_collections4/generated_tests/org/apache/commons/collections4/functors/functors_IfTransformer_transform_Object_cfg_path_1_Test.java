package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.IfTransformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class functors_IfTransformer_transform_Object_cfg_path_1_Test {

    private static class AlwaysFalsePredicate implements Predicate<Object> {
        @Override
        public boolean evaluate(Object input) { // Changed from test to evaluate
            return false; // Always returns false for evaluate
        }
    }

    private static class IdentityTransformer implements Transformer<Object, Object> {
        @Override
        public Object transform(Object input) {
            return input; // Simply returns the input
        }
    }

    @Test(timeout = 4000)
    public void testTransformWhenPredicateIsFalse() {
        Predicate<Object> predicate = new AlwaysFalsePredicate();
        Transformer<Object, Object> trueTransformer = new IdentityTransformer();
        Transformer<Object, Object> falseTransformer = new IdentityTransformer();

        IfTransformer<Object, Object> ifTransformer = new IfTransformer<>(predicate, trueTransformer, falseTransformer);

        Object input = new Object(); // Input can be any object
        Object result = ifTransformer.transform(input);

        assertEquals(input, result); // Since predicate is false, falseTransformer should be applied
    }


}