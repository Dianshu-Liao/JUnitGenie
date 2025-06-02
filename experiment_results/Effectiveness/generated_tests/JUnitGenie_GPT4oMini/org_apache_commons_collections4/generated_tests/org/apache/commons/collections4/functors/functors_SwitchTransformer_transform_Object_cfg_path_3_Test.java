package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.SwitchTransformer;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class functors_SwitchTransformer_transform_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testTransformWithMatchingPredicate() {
        // Arrange
        Predicate<Object> predicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object input) {
                return "test".equals(input); // This will return true for the input "test"
            }
        };

        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "transformed"; // This will be the output when the predicate matches
            }
        };

        Transformer<Object, Object> defaultTransformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "default"; // This will be the output when no predicates match
            }
        };

        Predicate<Object>[] predicates = new Predicate[] { predicate };
        SwitchTransformer switchTransformer = new SwitchTransformer(predicates, new Transformer[] { transformer }, defaultTransformer);

        // Act
        Object result = switchTransformer.transform("test");

        // Assert
        assertEquals("transformed", result);
    }

    @Test(timeout = 4000)
    public void testTransformWithNoMatchingPredicate() {
        // Arrange
        Predicate<Object> predicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object input) {
                return "test".equals(input); // This will return true for the input "test"
            }
        };

        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "transformed"; // This will be the output when the predicate matches
            }
        };

        Transformer<Object, Object> defaultTransformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "default"; // This will be the output when no predicates match
            }
        };

        Predicate<Object>[] predicates = new Predicate[] { predicate };
        SwitchTransformer switchTransformer = new SwitchTransformer(predicates, new Transformer[] { transformer }, defaultTransformer);

        // Act
        Object result = switchTransformer.transform("not_test");

        // Assert
        assertEquals("default", result);
    }


}