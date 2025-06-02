package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.namespace.QName;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.type.ClassKey;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;

public class XmlRootNameLookup_readResolve_0_0_Test {

    @Test
    public void testReadResolve_WhenRootNamesIsNull_ShouldReturnNewInstance() {
        // Arrange
        XmlRootNameLookup xmlRootNameLookup = new XmlRootNameLookup();
        // Simulate _rootNames being null by reflection
        try {
            java.lang.reflect.Field field = XmlRootNameLookup.class.getDeclaredField("_rootNames");
            field.setAccessible(true);
            field.set(xmlRootNameLookup, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Act
        Object result = xmlRootNameLookup.readResolve();
        // Assert
        assertNotNull(result);
        assertNotNull(((XmlRootNameLookup) result)._rootNames);
    }

    @Test
    public void testReadResolve_WhenRootNamesIsNotNull_ShouldReturnSameInstance() {
        // Arrange
        XmlRootNameLookup xmlRootNameLookup = new XmlRootNameLookup();
        // Simulate _rootNames being not null
        try {
            java.lang.reflect.Field field = XmlRootNameLookup.class.getDeclaredField("_rootNames");
            field.setAccessible(true);
            field.set(xmlRootNameLookup, new LRUMap<ClassKey, QName>(1, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Act
        Object result = xmlRootNameLookup.readResolve();
        // Assert
        assertNotNull(result);
        assertSame(xmlRootNameLookup, result);
    }
}
