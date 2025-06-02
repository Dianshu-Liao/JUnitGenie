package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

public class SingletonMap_toString_26_1_Test {

    private SingletonMap<String, String> singletonMap;

    @BeforeEach
    public void setUp() {
        singletonMap = new SingletonMap<>("key", "value");
    }

    @Test
    public void testToString() throws Exception {
        // Invoke the private toString method using reflection
        Method toStringMethod = SingletonMap.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String result = (String) toStringMethod.invoke(singletonMap);
        String expected = "{key=value}";
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithSelfReferenceKey() throws Exception {
        SingletonMap<SingletonMap<String, String>, String> selfReferencingMap = new SingletonMap<>(singletonMap, "value");
        Method toStringMethod = SingletonMap.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String result = (String) toStringMethod.invoke(selfReferencingMap);
        String expected = "{(this Map)=value}";
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithSelfReferenceValue() throws Exception {
        SingletonMap<String, SingletonMap<String, String>> selfReferencingMap = new SingletonMap<>("key", singletonMap);
        Method toStringMethod = SingletonMap.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String result = (String) toStringMethod.invoke(selfReferencingMap);
        String expected = "{key=(this Map)}";
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithNullKeyAndValue() throws Exception {
        SingletonMap<String, String> nullMap = new SingletonMap<>(null, null);
        Method toStringMethod = SingletonMap.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String result = (String) toStringMethod.invoke(nullMap);
        String expected = "{null=null}";
        assertEquals(expected, result);
    }
}
