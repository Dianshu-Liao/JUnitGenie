package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.namespace.QName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.LRUMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;

public class XmlRootNameLookup_findRootName_1_3_Test {

    private XmlRootNameLookup xmlRootNameLookup;

    @BeforeEach
    public void setUp() {
        xmlRootNameLookup = new XmlRootNameLookup();
    }

    @Test
    public void testFindRootNameWithNullJavaType() {
        JavaType nullJavaType = null;
        MapperConfig<?> config = mock(MapperConfig.class);
        QName result = xmlRootNameLookup.findRootName(nullJavaType, config);
        assertEquals(XmlRootNameLookup.ROOT_NAME_FOR_NULL, result);
    }

    @Test
    public void testFindRootNameWithValidJavaType() {
        JavaType javaType = createMockJavaType(String.class);
        MapperConfig<?> config = mock(MapperConfig.class);
        QName expectedQName = new QName("example");
        xmlRootNameLookup._rootNames.put(new ClassKey(String.class), expectedQName);
        QName result = xmlRootNameLookup.findRootName(javaType, config);
        assertEquals(expectedQName, result);
    }

    @Test
    public void testFindRootNameWithUnknownJavaType() {
        JavaType javaType = createMockJavaType(Integer.class);
        MapperConfig<?> config = mock(MapperConfig.class);
        QName result = xmlRootNameLookup.findRootName(javaType, config);
        assertNull(result);
    }

    private JavaType createMockJavaType(Class<?> clazz) {
        return mock(JavaType.class, withSettings().useConstructor(clazz).defaultAnswer(CALLS_REAL_METHODS));
    }
}
