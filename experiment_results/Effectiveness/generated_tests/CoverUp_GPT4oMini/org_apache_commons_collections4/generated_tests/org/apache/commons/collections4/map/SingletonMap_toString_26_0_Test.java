package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.DefaultKeyValue;
import org.apache.commons.collections4.map.SingletonMap;
import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonMap_toString_26_0_Test {

    @Test
    public void testToStringWithNullKeyAndValue() throws Exception {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<Object, Object>(null, null);
        String expected = "{key=null=value=null}";
        String actual = invokeToString(singletonMap);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithNonNullKeyAndValue() throws Exception {
        SingletonMap<String, String> singletonMap = new SingletonMap<String, String>("key", "value");
        String expected = "{key=key=value=value}";
        String actual = invokeToString(singletonMap);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithKeyAsSelfReference() throws Exception {
        SingletonMap<SingletonMap<Object, Object>, SingletonMap<Object, Object>> singletonMap = new SingletonMap<>(new SingletonMap<Object, Object>(null, null), new SingletonMap<Object, Object>(null, null));
        String expected = "{key=(this Map)=value=(this Map)}";
        String actual = invokeToString(singletonMap);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithValueAsSelfReference() throws Exception {
        SingletonMap<Object, SingletonMap<Object, Object>> singletonMap = new SingletonMap<>(new Object(), new SingletonMap<Object, Object>(null, null));
        String expected = "{key=java.lang.Object@" + Integer.toHexString(System.identityHashCode(new Object())) + "=value=(this Map)}";
        String actual = invokeToString(singletonMap);
        assertEquals(expected, actual);
    }

    private String invokeToString(SingletonMap<?, ?> singletonMap) throws Exception {
        Method toStringMethod = SingletonMap.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        return (String) toStringMethod.invoke(singletonMap);
    }
}
