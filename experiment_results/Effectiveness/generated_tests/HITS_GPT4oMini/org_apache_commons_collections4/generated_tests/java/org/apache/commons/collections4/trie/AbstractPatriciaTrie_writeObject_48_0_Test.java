package org.apache.commons.collections4.trie;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectInputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;

class AbstractPatriciaTrie_writeObject_48_0_Test {

    private AbstractPatriciaTrie<String, String> trie;

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(null) {

            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new HashMap<String, String>() {

                    {
                        put("key1", "value1");
                        put("key2", "value2");
                    }
                }.entrySet();
            }
        };
    }

    @Test
    void testWriteObject() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        // Use reflection to access the private writeObject method
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
        method.setAccessible(true);
        method.invoke(trie, objectOutputStream);
        objectOutputStream.flush();
        assertEquals(37, byteArrayOutputStream.size());
    }

    @Test
    void testWriteObjectWithEmptyTrie() throws Exception {
        trie = new AbstractPatriciaTrie<String, String>(null) {

            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new HashMap<String, String>().entrySet();
            }
        };
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
        method.setAccessible(true);
        method.invoke(trie, objectOutputStream);
        objectOutputStream.flush();
        assertEquals(4, byteArrayOutputStream.size());
    }

    @Test
    void testWriteObjectThrowsIOException() {
        assertThrows(IOException.class, () -> {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream()) {

                // Simulate IOException without overriding final method
                @Override
                public void write(int b) throws IOException {
                    throw new IOException("Forced IOException");
                }
            };
            Method method = AbstractPatriciaTrie.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            method.setAccessible(true);
            method.invoke(trie, objectOutputStream);
        });
    }
}
