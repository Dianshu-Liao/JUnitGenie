package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class TransformedCollection_transform_5_1_Test {

    private TransformedCollection<String> transformedCollection;

    private Transformer<String, String> transformer;

    @BeforeEach
    public void setUp() {
        transformer = Mockito.mock(Transformer.class);
        // Create a Collection
        Collection<String> collection = new ArrayList<>();
        // Pass Collection and Transformer
        transformedCollection = new TransformedCollection<>(collection, transformer);
    }

    @Test
    public void testTransformWithNonNullInput() {
        String input = "test";
        String expectedOutput = "TEST";
        Mockito.when(transformer.apply(input)).thenReturn(expectedOutput);
        // Cast to String
        String result = (String) transformedCollection.transform(input);
        assertEquals(expectedOutput, result);
        Mockito.verify(transformer).apply(input);
    }

    @Test
    public void testTransformWithNullInput() {
        String input = null;
        Mockito.when(transformer.apply(input)).thenReturn(null);
        // Cast to String
        String result = (String) transformedCollection.transform(input);
        assertNull(result);
        Mockito.verify(transformer).apply(input);
    }

    @Test
    public void testTransformWithEmptyString() {
        String input = "";
        String expectedOutput = "";
        Mockito.when(transformer.apply(input)).thenReturn(expectedOutput);
        // Cast to String
        String result = (String) transformedCollection.transform(input);
        assertEquals(expectedOutput, result);
        Mockito.verify(transformer).apply(input);
    }

    @Test
    public void testTransformWithDifferentInput() {
        String input = "example";
        String expectedOutput = "EXAMPLE";
        Mockito.when(transformer.apply(input)).thenReturn(expectedOutput);
        // Cast to String
        String result = (String) transformedCollection.transform(input);
        assertEquals(expectedOutput, result);
        Mockito.verify(transformer).apply(input);
    }
}
