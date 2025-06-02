package org.apache.commons.collections4.map;

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

public class SingletonMap_toString_26_0_Test {

    @Test
    public void testToString_WithNullKeyAndValue() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>(null, null);
        assertEquals("{key=null=value=null}", singletonMap.toString());
    }

    @Test
    public void testToString_WithNonNullKeyAndValue() {
        SingletonMap<String, String> singletonMap = new SingletonMap<>("key", "value");
        assertEquals("{key=key=value=value}", singletonMap.toString());
    }

    @Test
    public void testToString_WithSelfReferencingKey() {
        SingletonMap<Object, Object> tempMap = new SingletonMap<>(null, "value");
        SingletonMap<SingletonMap<Object, Object>, Object> singletonMap = new SingletonMap<>(tempMap, "value");
        assertEquals("{key=(this Map)=value=value}", singletonMap.toString());
    }

    @Test
    public void testToString_WithSelfReferencingValue() {
        SingletonMap<Object, Object> tempMap = new SingletonMap<>(new Object(), null);
        SingletonMap<Object, SingletonMap<Object, Object>> singletonMap = new SingletonMap<>(new Object(), tempMap);
        assertEquals("{key=key=(this Map)}", singletonMap.toString());
    }
}
