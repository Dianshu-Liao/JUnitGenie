package org.apache.commons.collections4.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class AbstractHashedMap_doWriteObject_16_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<String, String>() {

            @Override
            public MapIterator<String, String> mapIterator() {
                return super.mapIterator();
            }
        };
        map.loadFactor = 0.75f;
        map.size = 0;
        map.data = new AbstractHashedMap.HashEntry[AbstractHashedMap.DEFAULT_CAPACITY];
    }

    @Test
    public void testDoWriteObject_WritesLoadFactor() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        map.doWriteObject(objectOutputStream);
        // Now read back the values
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        float loadFactor = objectInputStream.readFloat();
        assertEquals(0.75f, loadFactor, "Load factor written to output stream should match the expected value.");
        int dataLength = objectInputStream.readInt();
        assertEquals(AbstractHashedMap.DEFAULT_CAPACITY, dataLength, "Data length should match the default capacity.");
        int size = objectInputStream.readInt();
        assertEquals(0, size, "Size should be initialized to zero.");
    }
}
