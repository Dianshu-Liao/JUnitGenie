package org.apache.commons.collections4.map;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class Flat3Map_readObject_15_3_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
    }

    private String serializeMap(String[] keys, String[] values) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeInt(keys.length);
            for (int i = 0; i < keys.length; i++) {
                oos.writeObject(keys[i]);
                oos.writeObject(values[i]);
            }
            oos.flush();
            return baos.toString("ISO-8859-1");
        }
    }

    private void invokeReadObject(ObjectInputStream ois) throws Exception {
        Method method = Flat3Map.class.getDeclaredMethod("readObject", ObjectInputStream.class);
        method.setAccessible(true);
        method.invoke(flat3Map, ois);
    }

    @Test
    public void testReadObject_withThreeEntries() throws Exception {
        String serializedMap = serializeMap(new String[] { "key1", "key2", "key3" }, new String[] { "value1", "value2", "value3" });
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializedMap.getBytes("ISO-8859-1")))) {
            invokeReadObject(ois);
        }
        assertEquals("value1", flat3Map.put("key1", "value1"));
        assertEquals("value2", flat3Map.put("key2", "value2"));
        assertEquals("value3", flat3Map.put("key3", "value3"));
    }

    @Test
    public void testReadObject_withMoreThanThreeEntries() throws Exception {
        String serializedMap = serializeMap(new String[] { "key1", "key2", "key3", "key4" }, new String[] { "value1", "value2", "value3", "value4" });
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializedMap.getBytes("ISO-8859-1")))) {
            invokeReadObject(ois);
        }
        assertEquals("value1", flat3Map.put("key1", "value1"));
        assertEquals("value2", flat3Map.put("key2", "value2"));
        assertEquals("value3", flat3Map.put("key3", "value3"));
        assertEquals("value4", flat3Map.put("key4", "value4"));
    }

    @Test
    public void testReadObject_withEmptyMap() throws Exception {
        String serializedMap = serializeMap(new String[] {}, new String[] {});
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializedMap.getBytes("ISO-8859-1")))) {
            invokeReadObject(ois);
        }
        assertEquals(0, flat3Map.size());
    }
}
