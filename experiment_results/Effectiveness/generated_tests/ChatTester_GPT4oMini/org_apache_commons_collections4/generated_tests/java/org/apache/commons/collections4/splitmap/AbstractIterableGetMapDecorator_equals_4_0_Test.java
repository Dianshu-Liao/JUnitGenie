// Test method
package org.apache.commons.collections4.splitmap;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.IterableGet;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractIterableGetMapDecorator_equals_4_0_Test {

    private AbstractIterableGetMapDecorator<String, String> decorator;

    private Map<String, String> testMap;

    @BeforeEach
    public void setUp() {
        testMap = new HashMap<>();
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
        decorator = new // Fixed the buggy line
        // Fixed the buggy line
        AbstractIterableGetMapDecorator<String, String>(testMap) {

            @Override
            protected Map<String, String> decorated() {
                return testMap;
            }
        };
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(decorator.equals(decorator), "An object should be equal to itself.");
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(decorator.equals(null), "An object should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentType() {
        assertFalse(decorator.equals("Some String"), "An object should not be equal to a different type.");
    }

    @Test
    public void testEquals_EqualDecoratedObject() {
        AbstractIterableGetMapDecorator<String, String> anotherDecorator = new // Fixed the buggy line
        // Fixed the buggy line
        AbstractIterableGetMapDecorator<String, String>(testMap) {

            @Override
            protected Map<String, String> decorated() {
                return testMap;
            }
        };
        assertTrue(decorator.equals(anotherDecorator), "Two decorators with the same underlying map should be equal.");
    }

    @Test
    public void testEquals_DifferentDecoratedObject() {
        Map<String, String> anotherMap = new HashMap<>();
        anotherMap.put("key1", "value1");
        anotherMap.put("key3", "value3");
        AbstractIterableGetMapDecorator<String, String> anotherDecorator = new // Fixed the buggy line
        // Fixed the buggy line
        AbstractIterableGetMapDecorator<String, String>(anotherMap) {

            @Override
            protected Map<String, String> decorated() {
                return anotherMap;
            }
        };
        assertFalse(decorator.equals(anotherDecorator), "Two decorators with different underlying maps should not be equal.");
    }
}
