package org.apache.commons.collections4.map;

import java.io.ByteArrayOutputStream;
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

public class Flat3Map_writeObject_20_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    public void testWriteObject_EmptyMap() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        Method writeObjectMethod = Flat3Map.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
        // Allow access to the private method
        writeObjectMethod.setAccessible(true);
        writeObjectMethod.invoke(flat3Map, objectOutputStream);
        objectOutputStream.flush();
        byte[] serializedData = byteArrayOutputStream.toByteArray();
        assertEquals(4, serializedData.length);
    }

    @Test
    public void testWriteObject_NonEmptyMap() throws Exception {
        flat3Map.put("key1", "value1");
        flat3Map.put("key2", "value2");
        flat3Map.put("key3", "value3");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        Method writeObjectMethod = Flat3Map.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
        writeObjectMethod.setAccessible(true);
        writeObjectMethod.invoke(flat3Map, objectOutputStream);
        objectOutputStream.flush();
        byte[] serializedData = byteArrayOutputStream.toByteArray();
        assertEquals(4 + (3 * 2 * 4), serializedData.length);
    }
}
