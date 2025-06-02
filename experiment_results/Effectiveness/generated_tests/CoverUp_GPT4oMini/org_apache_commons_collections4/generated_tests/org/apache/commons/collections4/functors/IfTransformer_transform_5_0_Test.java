package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class IfTransformer_transform_5_0_Test {

    private IfTransformer<String, String> ifTransformer;

    private Predicate<String> predicate;

    private Transformer<String, String> trueTransformer;

    private Transformer<String, String> falseTransformer;

    @BeforeEach
    public void setUp() {
        predicate = mock(Predicate.class);
        trueTransformer = mock(Transformer.class);
        falseTransformer = mock(Transformer.class);
        ifTransformer = new IfTransformer<>(predicate, trueTransformer, falseTransformer);
    }

    @Test
    public void testTransformWhenPredicateIsTrue() {
        String input = "testInput";
        when(predicate.test(input)).thenReturn(true);
        when(trueTransformer.apply(input)).thenReturn("trueOutput");
        String result = ifTransformer.transform(input);
        assertEquals("trueOutput", result);
        verify(predicate).test(input);
        verify(trueTransformer).apply(input);
        verify(falseTransformer, never()).apply(any());
    }

    @Test
    public void testTransformWhenPredicateIsFalse() {
        String input = "testInput";
        when(predicate.test(input)).thenReturn(false);
        when(falseTransformer.apply(input)).thenReturn("falseOutput");
        String result = ifTransformer.transform(input);
        assertEquals("falseOutput", result);
        verify(predicate).test(input);
        verify(falseTransformer).apply(input);
        verify(trueTransformer, never()).apply(any());
    }

    @Test
    public void testTransformWithNullInput() {
        String input = null;
        when(predicate.test(input)).thenReturn(true);
        when(trueTransformer.apply(input)).thenReturn("trueOutput");
        String result = ifTransformer.transform(input);
        assertEquals("trueOutput", result);
        verify(predicate).test(input);
        verify(trueTransformer).apply(input);
        verify(falseTransformer, never()).apply(any());
    }

    @Test
    public void testTransformWithNullInputFalsePredicate() {
        String input = null;
        when(predicate.test(input)).thenReturn(false);
        when(falseTransformer.apply(input)).thenReturn("falseOutput");
        String result = ifTransformer.transform(input);
        assertEquals("falseOutput", result);
        verify(predicate).test(input);
        verify(falseTransformer).apply(input);
        verify(trueTransformer, never()).apply(any());
    }
}
