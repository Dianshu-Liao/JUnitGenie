package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.SwitchTransformer;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class functors_SwitchTransformer_transform_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTransformWithMatchingPredicate() {
        // Arrange
        Predicate<Object> predicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object input) {
                return input.equals("test");
            }
        };

        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "transformed: " + input;
            }
        };

        Transformer<Object, Object> defaultTransformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "default: " + input;
            }
        };

        Predicate<Object>[] predicates = new Predicate[]{predicate};
        Transformer<Object, Object>[] transformers = new Transformer[]{transformer};

        SwitchTransformer switchTransformer = new SwitchTransformer(predicates, transformers, defaultTransformer);

        // Act
        Object result = switchTransformer.transform("test");

        // Assert
        assertEquals("transformed: test", result);
    }

    @Test(timeout = 4000)
    public void testTransformWithNoMatchingPredicate() {
        // Arrange
        Predicate<Object> predicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object input) {
                return input.equals("not_test");
            }
        };

        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "transformed: " + input;
            }
        };

        Transformer<Object, Object> defaultTransformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "default: " + input;
            }
        };

        Predicate<Object>[] predicates = new Predicate[]{predicate};
        Transformer<Object, Object>[] transformers = new Transformer[]{transformer};

        SwitchTransformer switchTransformer = new SwitchTransformer(predicates, transformers, defaultTransformer);

        // Act
        Object result = switchTransformer.transform("test");

        // Assert
        assertEquals("default: test", result);
    }


}