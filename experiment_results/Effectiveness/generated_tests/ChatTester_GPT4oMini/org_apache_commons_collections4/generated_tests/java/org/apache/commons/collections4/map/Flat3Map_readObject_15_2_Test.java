package org.apache.commons.collections4.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
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

public class Flat3Map_readObject_15_2_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    public void testReadObjectWithLessThanThreeElements() throws Exception {
        // Prepare the serialized object
        HashMap<String, String> originalMap = new HashMap<>();
        originalMap.put("key1", "value1");
        originalMap.put("key2", "value2");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeInt(originalMap.size());
        for (String key : originalMap.keySet()) {
            oos.writeObject(key);
            oos.writeObject(originalMap.get(key));
        }
        oos.flush();
        oos.close();
        // Deserialize and invoke the private method
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Method readObjectMethod = Flat3Map.class.getDeclaredMethod("readObject", ObjectInputStream.class);
        readObjectMethod.setAccessible(true);
        readObjectMethod.invoke(flat3Map, ois);
        // Verify the results
        assertEquals(2, flat3Map.size());
        assertEquals("value1", flat3Map.get("key1"));
        assertEquals("value2", flat3Map.get("key2"));
    }

    @Test
    public void testReadObjectWithMoreThanThreeElements() throws Exception {
        // Prepare the serialized object
        HashMap<String, String> originalMap = new HashMap<>();
        originalMap.put("key1", "value1");
        originalMap.put("key2", "value2");
        originalMap.put("key3", "value3");
        originalMap.put("key4", "value4");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeInt(originalMap.size());
        for (String key : originalMap.keySet()) {
            oos.writeObject(key);
            oos.writeObject(originalMap.get(key));
        }
        oos.flush();
        oos.close();
        // Deserialize and invoke the private method
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Method readObjectMethod = Flat3Map.class.getDeclaredMethod("readObject", ObjectInputStream.class);
        readObjectMethod.setAccessible(true);
        readObjectMethod.invoke(flat3Map, ois);
        // Verify the results
        assertEquals(4, flat3Map.size());
        assertEquals("value1", flat3Map.get("key1"));
        assertEquals("value2", flat3Map.get("key2"));
        assertEquals("value3", flat3Map.get("key3"));
        assertEquals("value4", flat3Map.get("key4"));
    }
}
