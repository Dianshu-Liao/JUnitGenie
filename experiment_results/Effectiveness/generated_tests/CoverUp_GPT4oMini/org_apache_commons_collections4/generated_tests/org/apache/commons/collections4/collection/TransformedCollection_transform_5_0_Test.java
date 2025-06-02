package org.apache.commons.collections4.collection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class TransformedCollection_transform_5_0_Test {

    private TransformedCollection<String> transformedCollection;

    private static class TestTransformer implements Transformer<String, String> {

        @Override
        public String transform(String input) {
            return input == null ? null : input.toUpperCase();
        }
    }

    @BeforeEach
    void setUp() {
        Collection<String> collection = new ArrayList<>();
        collection.add("test");
        collection.add("example");
        transformedCollection = new TransformedCollection<>(collection, new TestTransformer());
    }

    @Test
    void testTransformValidInput() throws Exception {
        Method method = TransformedCollection.class.getDeclaredMethod("transform", Object.class);
        method.setAccessible(true);
        String result = (String) method.invoke(transformedCollection, "hello");
        assertEquals("HELLO", result);
    }

    @Test
    void testTransformNullInput() throws Exception {
        Method method = TransformedCollection.class.getDeclaredMethod("transform", Object.class);
        method.setAccessible(true);
        String result = (String) method.invoke(transformedCollection, null);
        assertEquals(null, result);
    }

    @Test
    void testTransformEmptyString() throws Exception {
        Method method = TransformedCollection.class.getDeclaredMethod("transform", Object.class);
        method.setAccessible(true);
        String result = (String) method.invoke(transformedCollection, "");
        assertEquals("", result);
    }

    @Test
    void testTransformWithInvalidInput() throws Exception {
        Method method = TransformedCollection.class.getDeclaredMethod("transform", Object.class);
        method.setAccessible(true);
        Exception exception = assertThrows(ClassCastException.class, () -> {
            method.invoke(transformedCollection, new Object());
        });
        assertEquals("java.lang.String cannot be cast to java.lang.String", exception.getMessage());
    }
}
