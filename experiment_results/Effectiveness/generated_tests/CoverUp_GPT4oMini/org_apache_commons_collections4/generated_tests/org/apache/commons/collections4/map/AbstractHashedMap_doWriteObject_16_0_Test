package org.apache.commons.collections4.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class AbstractHashedMap_doWriteObject_16_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new AbstractHashedMap<>(16, 0.75f);
        map.put("key1", "value1");
        map.put("key2", "value2");
    }

    @Test
    void testDoWriteObject() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        // Use reflection to call the private method
        try {
            Method method = AbstractHashedMap.class.getDeclaredMethod("doWriteObject", ObjectOutputStream.class);
            method.setAccessible(true);
            method.invoke(map, objectOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] serializedData = byteArrayOutputStream.toByteArray();
        // Now we will read back the data to verify it
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        float loadFactor = objectInputStream.readFloat();
        int dataLength = objectInputStream.readInt();
        int size = objectInputStream.readInt();
        assertEquals(0.75f, loadFactor);
        assertEquals(16, dataLength);
        assertEquals(2, size);
        String key1 = (String) objectInputStream.readObject();
        String value1 = (String) objectInputStream.readObject();
        String key2 = (String) objectInputStream.readObject();
        String value2 = (String) objectInputStream.readObject();
        assertEquals("key1", key1);
        assertEquals("value1", value1);
        assertEquals("key2", key2);
        assertEquals("value2", value2);
    }
}
