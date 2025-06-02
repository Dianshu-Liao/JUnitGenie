package org.apache.commons.collections4.functors;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public class SwitchTransformer_transform_5_0_Test {

    private SwitchTransformer<String, String> switchTransformer;

    private Predicate<String>[] predicates;

    private Transformer<String, String>[] transformers;

    private Transformer<String, String> defaultTransformer;

    @SuppressWarnings("unchecked")
    @BeforeEach
    public void setUp() {
        predicates = new Predicate[3];
        transformers = new Transformer[3];
        predicates[0] = input -> input.equals("A");
        transformers[0] = input -> "Transformed A";
        predicates[1] = input -> input.equals("B");
        transformers[1] = input -> "Transformed B";
        predicates[2] = input -> input.equals("C");
        transformers[2] = input -> "Transformed C";
        defaultTransformer = input -> "Default Transformation";
        switchTransformer = new SwitchTransformer<>(predicates, transformers, defaultTransformer);
    }

    @Test
    public void testTransform_WithPredicateA_ShouldReturnTransformedA() {
        String result = switchTransformer.transform("A");
        assertEquals("Transformed A", result);
    }

    @Test
    public void testTransform_WithPredicateB_ShouldReturnTransformedB() {
        String result = switchTransformer.transform("B");
        assertEquals("Transformed B", result);
    }

    @Test
    public void testTransform_WithPredicateC_ShouldReturnTransformedC() {
        String result = switchTransformer.transform("C");
        assertEquals("Transformed C", result);
    }

    @Test
    public void testTransform_WithNoMatchingPredicate_ShouldReturnDefaultTransformation() {
        String result = switchTransformer.transform("D");
        assertEquals("Default Transformation", result);
    }

    @Test
    public void testTransform_WithNullInput_ShouldReturnDefaultTransformation() {
        String result = switchTransformer.transform(null);
        assertEquals("Default Transformation", result);
    }
}
