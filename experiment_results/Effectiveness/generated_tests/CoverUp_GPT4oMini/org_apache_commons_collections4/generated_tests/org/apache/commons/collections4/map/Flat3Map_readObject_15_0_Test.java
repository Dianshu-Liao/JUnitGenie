package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.Flat3Map;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

class Flat3Map_readObject_15_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    void testReadObjectWithLessThanThreeEntries() throws Exception {
        // Prepare the object stream with 2 entries
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeInt(2);
        out.writeObject("key1");
        out.writeObject("value1");
        out.writeObject("key2");
        out.writeObject("value2");
        out.close();
        // Read the object
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        invokeReadObject(flat3Map, in);
        // Verify the contents
        assertEquals(2, flat3Map.size());
        assertEquals("value1", flat3Map.put("key1", "value1"));
        assertEquals("value2", flat3Map.put("key2", "value2"));
    }

    @Test
    void testReadObjectWithThreeEntries() throws Exception {
        // Prepare the object stream with 3 entries
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeInt(3);
        out.writeObject("key1");
        out.writeObject("value1");
        out.writeObject("key2");
        out.writeObject("value2");
        out.writeObject("key3");
        out.writeObject("value3");
        out.close();
        // Read the object
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        invokeReadObject(flat3Map, in);
        // Verify the contents
        assertEquals(3, flat3Map.size());
        assertEquals("value1", flat3Map.put("key1", "value1"));
        assertEquals("value2", flat3Map.put("key2", "value2"));
        assertEquals("value3", flat3Map.put("key3", "value3"));
    }

    @Test
    void testReadObjectWithMoreThanThreeEntries() throws Exception {
        // Prepare the object stream with 4 entries
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeInt(4);
        out.writeObject("key1");
        out.writeObject("value1");
        out.writeObject("key2");
        out.writeObject("value2");
        out.writeObject("key3");
        out.writeObject("value3");
        out.writeObject("key4");
        out.writeObject("value4");
        out.close();
        // Read the object
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        invokeReadObject(flat3Map, in);
        // Verify the contents
        assertEquals(4, flat3Map.size());
        assertEquals("value1", flat3Map.put("key1", "value1"));
        assertEquals("value2", flat3Map.put("key2", "value2"));
        assertEquals("value3", flat3Map.put("key3", "value3"));
        assertEquals("value4", flat3Map.put("key4", "value4"));
    }

    private void invokeReadObject(Flat3Map<String, String> map, ObjectInputStream in) throws Exception {
        Method method = Flat3Map.class.getDeclaredMethod("readObject", ObjectInputStream.class);
        method.setAccessible(true);
        method.invoke(map, in);
    }
}
