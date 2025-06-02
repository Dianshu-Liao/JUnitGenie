package com.fasterxml.jackson.dataformat.xml.util;

import java.lang.reflect.Field;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.databind.util.LRUMap;
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

public class XmlRootNameLookup_readResolve_0_1_Test {

    private XmlRootNameLookup xmlRootNameLookup;

    @BeforeEach
    public void setUp() {
        xmlRootNameLookup = new XmlRootNameLookup();
    }

    @Test
    public void testReadResolve_NullRootNames() {
        // Simulate _rootNames being null by not initializing it
        XmlRootNameLookup result = (XmlRootNameLookup) xmlRootNameLookup.readResolve();
        assertNotNull(result, "Expected result should not be null when _rootNames is null");
    }

    @Test
    public void testReadResolve_NonNullRootNames() throws Exception {
        // Use reflection to set the final _rootNames field
        Field rootNamesField = XmlRootNameLookup.class.getDeclaredField("_rootNames");
        rootNamesField.setAccessible(true);
        // Fix: Provide both parameters
        rootNamesField.set(xmlRootNameLookup, new LRUMap<ClassKey, QName>(10, 10));
        XmlRootNameLookup result = (XmlRootNameLookup) xmlRootNameLookup.readResolve();
        assertNotNull(result, "Expected result should not be null when _rootNames is initialized");
    }
}
