package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

class TransformerPredicate_test_2_0_Test {

    private TransformerPredicate<String> transformerPredicate;

    @BeforeEach
    void setUp() {
        Transformer<String, Boolean> transformer = new Transformer<String, Boolean>() {

            @Override
            public Boolean transform(String input) {
                // Example logic
                return input != null && input.length() > 3;
            }
        };
        transformerPredicate = new TransformerPredicate<>(transformer);
    }

    @Test
    void testValidInputReturnsTrue() {
        assertTrue(transformerPredicate.test("Hello"));
    }

    @Test
    void testValidInputReturnsFalse() {
        assertFalse(transformerPredicate.test("Hi"));
    }

    @Test
    void testNullInputReturnsFalse() {
        assertFalse(transformerPredicate.test(null));
    }

    @Test
    void testTransformerReturnsNullThrowsException() {
        Transformer<String, Boolean> nullReturningTransformer = new Transformer<String, Boolean>() {

            @Override
            public Boolean transform(String input) {
                // Intentional null return
                return null;
            }
        };
        transformerPredicate = new TransformerPredicate<>(nullReturningTransformer);
        FunctorException exception = assertThrows(FunctorException.class, () -> {
            transformerPredicate.test("Test");
        });
        assertEquals("Transformer must return an instanceof Boolean, it was a null object", exception.getMessage());
    }

    @Test
    void testGetTransformer() {
        assertNotNull(transformerPredicate.getTransformer());
    }
}
