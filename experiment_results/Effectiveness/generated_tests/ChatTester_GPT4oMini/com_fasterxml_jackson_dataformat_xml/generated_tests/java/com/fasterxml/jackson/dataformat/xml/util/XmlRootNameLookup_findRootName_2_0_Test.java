package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.namespace.QName;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.LRUMap;

class XmlRootNameLookup_findRootName_2_0_Test {

    private XmlRootNameLookup xmlRootNameLookup;

    private LRUMap<ClassKey, QName> mockLRUMap;

    private MapperConfig<?> mockConfig;

    @BeforeEach
    void setUp() {
        xmlRootNameLookup = new XmlRootNameLookup();
        mockLRUMap = mock(LRUMap.class);
        mockConfig = mock(MapperConfig.class);
        // Using reflection to set the private field _rootNames
        try {
            Field rootNamesField = XmlRootNameLookup.class.getDeclaredField("_rootNames");
            rootNamesField.setAccessible(true);
            rootNamesField.set(xmlRootNameLookup, mockLRUMap);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set up the test: " + e.getMessage());
        }
    }

    @Test
    void testFindRootName_CacheHit() {
        Class<?> rootType = String.class;
        QName expectedQName = new QName("expected");
        ClassKey key = new ClassKey(rootType);
        when(mockLRUMap.get(key)).thenReturn(expectedQName);
        QName actualQName = xmlRootNameLookup.findRootName(rootType, mockConfig);
        assertEquals(expectedQName, actualQName);
        verify(mockLRUMap).get(key);
        verify(mockLRUMap, never()).put(any(), any());
    }

    @Test
    void testFindRootName_CacheMiss() {
        Class<?> rootType = Integer.class;
        QName expectedQName = new QName("expected");
        ClassKey key = new ClassKey(rootType);
        when(mockLRUMap.get(key)).thenReturn(null);
        // Reflectively invoke the private method _findRootName
        try {
            Method findRootNameMethod = XmlRootNameLookup.class.getDeclaredMethod("_findRootName", MapperConfig.class, Class.class);
            findRootNameMethod.setAccessible(true);
            when(findRootNameMethod.invoke(xmlRootNameLookup, mockConfig, rootType)).thenReturn(expectedQName);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Failed to set up the test: " + e.getMessage());
        }
        QName actualQName = xmlRootNameLookup.findRootName(rootType, mockConfig);
        assertEquals(expectedQName, actualQName);
        verify(mockLRUMap).get(key);
        verify(mockLRUMap).put(key, expectedQName);
    }
}
