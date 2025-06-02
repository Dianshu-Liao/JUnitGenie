package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
import java.util.*;
// Added import for Collectors
import java.util.stream.Collectors;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TransformedSortedMap_transformedSortedMap_0_0_Test {

    private SortedMap<String, Integer> mockSortedMap;

    private Transformer<String, String> keyTransformer;

    private Transformer<Integer, Integer> valueTransformer;

    @BeforeEach
    public void setUp() {
        mockSortedMap = mock(SortedMap.class);
        keyTransformer = mock(Transformer.class);
        valueTransformer = mock(Transformer.class);
    }

    @Test
    public void testTransformedSortedMap_EmptyMap() {
        when(mockSortedMap.isEmpty()).thenReturn(true);
        TransformedSortedMap<String, Integer> result = TransformedSortedMap.transformedSortedMap(mockSortedMap, keyTransformer, valueTransformer);
        assertNotNull(result);
        verify(mockSortedMap, times(1)).isEmpty();
        verify(mockSortedMap, never()).putAll(anyMap());
    }

    @Test
    public void testTransformedSortedMap_NonEmptyMap() {
        when(mockSortedMap.isEmpty()).thenReturn(false);
        when(mockSortedMap.size()).thenReturn(1);
        when(mockSortedMap.entrySet()).thenReturn(new HashSet<>(Collections.singletonList(new AbstractMap.SimpleEntry<>("key", 1))).stream().collect(Collectors.toSet()));
        // Mock transformations
        when(keyTransformer.transform("key")).thenReturn("transformedKey");
        when(valueTransformer.transform(1)).thenReturn(2);
        TransformedSortedMap<String, Integer> result = TransformedSortedMap.transformedSortedMap(mockSortedMap, keyTransformer, valueTransformer);
        assertNotNull(result);
        verify(mockSortedMap, times(1)).isEmpty();
        verify(mockSortedMap, times(1)).entrySet();
        verify(mockSortedMap, times(1)).clear();
        // Use reflection to access the private method 'decorated'
        try {
            Method decoratedMethod = result.getClass().getDeclaredMethod("decorated");
            decoratedMethod.setAccessible(true);
            SortedMap<String, Integer> decoratedMap = (SortedMap<String, Integer>) decoratedMethod.invoke(result);
            // Verify that the transformed entries are put into the decorated map
            Map<String, Integer> expectedMap = new HashMap<>();
            expectedMap.put("transformedKey", 2);
            verify(decoratedMap).putAll(expectedMap);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    // Utility method to invoke private methods using reflection
    private Object invokePrivateMethod(Object obj, String methodName, Class<?>[] paramTypes, Object... params) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, paramTypes);
        method.setAccessible(true);
        return method.invoke(obj, params);
    }
}
