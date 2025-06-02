package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class Flat3Map_writeObject_20_0_Test {

    private Flat3Map<String, String> flat3Map;

    private ObjectOutputStream objectOutputStream;

    @BeforeEach
    void setUp() throws Exception {
        flat3Map = new Flat3Map<>(new HashMap<>());
        objectOutputStream = mock(ObjectOutputStream.class);
    }

    @Test
    void testWriteObject() throws Exception {
        // Setup the internal state of Flat3Map
        flat3Map.put("key1", "value1");
        flat3Map.put("key2", "value2");
        flat3Map.put("key3", "value3");
        // Use reflection to access the private method
        Method writeObjectMethod = Flat3Map.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
        writeObjectMethod.setAccessible(true);
        // Invoke the method
        writeObjectMethod.invoke(flat3Map, objectOutputStream);
        // Verify interactions with ObjectOutputStream
        verify(objectOutputStream).defaultWriteObject();
        // Assuming size() returns 3
        verify(objectOutputStream).writeInt(3);
        verify(objectOutputStream).writeObject("key1");
        verify(objectOutputStream).writeObject("value1");
        verify(objectOutputStream).writeObject("key2");
        verify(objectOutputStream).writeObject("value2");
        verify(objectOutputStream).writeObject("key3");
        verify(objectOutputStream).writeObject("value3");
    }

    @Test
    void testWriteObjectWithEmptyMap() throws Exception {
        // Use reflection to access the private method
        Method writeObjectMethod = Flat3Map.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
        writeObjectMethod.setAccessible(true);
        // Invoke the method
        writeObjectMethod.invoke(flat3Map, objectOutputStream);
        // Verify interactions with ObjectOutputStream
        verify(objectOutputStream).defaultWriteObject();
        // Assuming size() returns 0
        verify(objectOutputStream).writeInt(0);
    }
}
