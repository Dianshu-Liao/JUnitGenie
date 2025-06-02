package org.apache.commons.collections4.functors;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public class IfTransformer_transform_5_0_Test {

    private Predicate<Object> predicateTrue;

    private Predicate<Object> predicateFalse;

    private Transformer<Object, String> trueTransformer;

    private Transformer<Object, String> falseTransformer;

    private IfTransformer<Object, String> ifTransformer;

    @BeforeEach
    public void setUp() {
        predicateTrue = mock(Predicate.class);
        predicateFalse = mock(Predicate.class);
        trueTransformer = mock(Transformer.class);
        falseTransformer = mock(Transformer.class);
        ifTransformer = new IfTransformer<>(predicateTrue, trueTransformer, falseTransformer);
    }

    @Test
    public void testTransform_WhenPredicateIsTrue_ShouldApplyTrueTransformer() {
        Object input = new Object();
        when(predicateTrue.test(input)).thenReturn(true);
        when(trueTransformer.apply(input)).thenReturn("True Result");
        String result = ifTransformer.transform(input);
        assertEquals("True Result", result);
    }

    @Test
    public void testTransform_WhenPredicateIsFalse_ShouldApplyFalseTransformer() {
        Object input = new Object();
        when(predicateTrue.test(input)).thenReturn(false);
        when(falseTransformer.apply(input)).thenReturn("False Result");
        String result = ifTransformer.transform(input);
        assertEquals("False Result", result);
    }

    @Test
    public void testTransform_WhenPredicateIsTrue_ShouldNotApplyFalseTransformer() {
        Object input = new Object();
        when(predicateTrue.test(input)).thenReturn(true);
        when(trueTransformer.apply(input)).thenReturn("True Result");
        when(falseTransformer.apply(input)).thenReturn("Should Not Be Called");
        String result = ifTransformer.transform(input);
        assertEquals("True Result", result);
    }

    @Test
    public void testTransform_WhenPredicateIsFalse_ShouldNotApplyTrueTransformer() {
        Object input = new Object();
        when(predicateTrue.test(input)).thenReturn(false);
        when(falseTransformer.apply(input)).thenReturn("False Result");
        when(trueTransformer.apply(input)).thenReturn("Should Not Be Called");
        String result = ifTransformer.transform(input);
        assertEquals("False Result", result);
    }
}
