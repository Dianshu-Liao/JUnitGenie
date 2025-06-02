package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.FunctorUtils;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

class SwitchTransformer_transform_5_0_Test {

    private SwitchTransformer<String, String> switchTransformer;

    @BeforeEach
    void setUp() {
        Predicate<? super String>[] predicates = new Predicate[] { input -> input.equals("A"), input -> input.equals("B") };
        Transformer<? super String, ? extends String>[] transformers = new Transformer[] { input -> "Transformed A", input -> "Transformed B" };
        Transformer<? super String, ? extends String> defaultTransformer = new ConstantTransformer<>("Default Value");
        switchTransformer = new SwitchTransformer<>(predicates, transformers, defaultTransformer);
    }

    @Test
    void testTransformWithPredicateA() {
        String result = switchTransformer.transform("A");
        assertEquals("Transformed A", result);
    }

    @Test
    void testTransformWithPredicateB() {
        String result = switchTransformer.transform("B");
        assertEquals("Transformed B", result);
    }

    @Test
    void testTransformWithNoMatchingPredicate() {
        String result = switchTransformer.transform("C");
        assertEquals("Default Value", result);
    }

    @Test
    void testGetDefaultTransformer() {
        Transformer<? super String, ? extends String> defaultTransformer = switchTransformer.getDefaultTransformer();
        assertNotNull(defaultTransformer);
        assertEquals("Default Value", defaultTransformer.apply("C"));
    }

    @Test
    void testGetPredicates() {
        Predicate<? super String>[] predicates = switchTransformer.getPredicates();
        assertNotNull(predicates);
        assertEquals(2, predicates.length);
    }

    @Test
    void testGetTransformers() {
        Transformer<? super String, ? extends String>[] transformers = switchTransformer.getTransformers();
        assertNotNull(transformers);
        assertEquals(2, transformers.length);
    }

    // Reflection test for private constructor
    @Test
    void testPrivateConstructor() throws Exception {
        Class<?> clazz = switchTransformer.getClass();
        Method privateConstructor = clazz.getDeclaredMethod("SwitchTransformer", boolean.class, Predicate[].class, Transformer[].class, Transformer.class);
        privateConstructor.setAccessible(true);
        SwitchTransformer<String, String> instance = (SwitchTransformer<String, String>) privateConstructor.invoke(null, false, null, null, null);
        assertNotNull(instance);
    }
}
