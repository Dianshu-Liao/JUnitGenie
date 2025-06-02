package org.apache.commons.collections4.map;

import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedMap_firstKey_4_0_Test {

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    public void setUp() {
        listOrderedMap = new ListOrderedMap<>();
    }

    @Test
    public void testFirstKey_whenMapIsEmpty_shouldThrowNoSuchElementException() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            listOrderedMap.firstKey();
        });
        assertEquals("Map is empty", exception.getMessage());
    }

    @Test
    public void testFirstKey_whenMapHasElements_shouldReturnFirstKey() {
        listOrderedMap.put("first", "value1");
        listOrderedMap.put("second", "value2");
        String firstKey = listOrderedMap.firstKey();
        assertEquals("first", firstKey);
    }

    @Test
    public void testFirstKey_whenMapHasSingleElement_shouldReturnThatKey() {
        listOrderedMap.put("onlyKey", "onlyValue");
        String firstKey = listOrderedMap.firstKey();
        assertEquals("onlyKey", firstKey);
    }

    @Test
    public void testFirstKey_afterRemovingFirstElement_shouldReturnNewFirstKey() {
        listOrderedMap.put("first", "value1");
        listOrderedMap.put("second", "value2");
        listOrderedMap.remove("first");
        String firstKey = listOrderedMap.firstKey();
        assertEquals("second", firstKey);
    }

    @Test
    public void testFirstKey_afterClearingMap_shouldThrowNoSuchElementException() {
        listOrderedMap.put("first", "value1");
        listOrderedMap.clear();
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            listOrderedMap.firstKey();
        });
        assertEquals("Map is empty", exception.getMessage());
    }
}
