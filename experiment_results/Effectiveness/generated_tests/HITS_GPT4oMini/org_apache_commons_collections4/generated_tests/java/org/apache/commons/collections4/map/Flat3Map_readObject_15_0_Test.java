package org.apache.commons.collections4.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class Flat3Map_readObject_15_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    public void testReadObject_withThreeElements() throws IOException, ClassNotFoundException {
        // Prepare a Flat3Map with three entries
        flat3Map.put("key1", "value1");
        flat3Map.put("key2", "value2");
        flat3Map.put("key3", "value3");
        // Serialize the Flat3Map
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(flat3Map);
        objectOutputStream.close();
        // Deserialize the Flat3Map
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Flat3Map<String, String> deserializedMap = (Flat3Map<String, String>) objectInputStream.readObject();
        // Verify the contents of the deserialized map
        assertNotNull(deserializedMap);
        assertEquals(3, deserializedMap.size());
        assertEquals("value1", deserializedMap.put("key1", "value1"));
        assertEquals("value2", deserializedMap.put("key2", "value2"));
        assertEquals("value3", deserializedMap.put("key3", "value3"));
    }

    @Test
    public void testReadObject_withLessThanThreeElements() throws IOException, ClassNotFoundException {
        // Prepare a Flat3Map with two entries
        flat3Map.put("key1", "value1");
        flat3Map.put("key2", "value2");
        // Serialize the Flat3Map
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(flat3Map);
        objectOutputStream.close();
        // Deserialize the Flat3Map
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Flat3Map<String, String> deserializedMap = (Flat3Map<String, String>) objectInputStream.readObject();
        // Verify the contents of the deserialized map
        assertNotNull(deserializedMap);
        assertEquals(2, deserializedMap.size());
        assertEquals("value1", deserializedMap.put("key1", "value1"));
        assertEquals("value2", deserializedMap.put("key2", "value2"));
    }

    @Test
    public void testReadObject_withNoElements() throws IOException, ClassNotFoundException {
        // Serialize an empty Flat3Map
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(flat3Map);
        objectOutputStream.close();
        // Deserialize the Flat3Map
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Flat3Map<String, String> deserializedMap = (Flat3Map<String, String>) objectInputStream.readObject();
        // Verify the contents of the deserialized map
        assertNotNull(deserializedMap);
        assertEquals(0, deserializedMap.size());
    }
}
