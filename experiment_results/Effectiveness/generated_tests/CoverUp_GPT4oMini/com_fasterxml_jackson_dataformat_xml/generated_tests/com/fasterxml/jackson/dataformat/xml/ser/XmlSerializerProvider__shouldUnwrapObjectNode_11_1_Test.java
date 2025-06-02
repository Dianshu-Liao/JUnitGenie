package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;

class XmlSerializerProvider__shouldUnwrapObjectNode_11_1_Test {

    private XmlRootNameLookup rootNameLookup;

    private XmlSerializerProvider xmlSerializerProvider;

    private ToXmlGenerator mockToXmlGenerator;

    @BeforeEach
    void setUp() {
        rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        mockToXmlGenerator = mock(ToXmlGenerator.class);
    }

    @Test
    void testShouldUnwrapObjectNode_WhenFeatureEnabledAndSingleNode() {
        ObjectNode singleNode = mock(ObjectNode.class);
        when(singleNode.size()).thenReturn(1);
        when(mockToXmlGenerator.isEnabled(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE)).thenReturn(true);
        boolean result = invokeShouldUnwrapObjectNode(mockToXmlGenerator, singleNode);
        assertTrue(result);
    }

    @Test
    void testShouldUnwrapObjectNode_WhenFeatureEnabledAndNotSingleNode() {
        ObjectNode multipleNode = mock(ObjectNode.class);
        when(multipleNode.size()).thenReturn(2);
        when(mockToXmlGenerator.isEnabled(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE)).thenReturn(true);
        boolean result = invokeShouldUnwrapObjectNode(mockToXmlGenerator, multipleNode);
        assertFalse(result);
    }

    @Test
    void testShouldUnwrapObjectNode_WhenFeatureDisabled() {
        ObjectNode singleNode = mock(ObjectNode.class);
        when(singleNode.size()).thenReturn(1);
        when(mockToXmlGenerator.isEnabled(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE)).thenReturn(false);
        boolean result = invokeShouldUnwrapObjectNode(mockToXmlGenerator, singleNode);
        assertFalse(result);
    }

    @Test
    void testShouldUnwrapObjectNode_WhenValueIsNotObjectNode() {
        String nonObjectNodeValue = "not an ObjectNode";
        boolean result = invokeShouldUnwrapObjectNode(mockToXmlGenerator, nonObjectNodeValue);
        assertFalse(result);
    }

    private boolean invokeShouldUnwrapObjectNode(ToXmlGenerator xgen, Object value) {
        try {
            return (boolean) XmlSerializerProvider.class.getDeclaredMethod("_shouldUnwrapObjectNode", ToXmlGenerator.class, Object.class).invoke(xmlSerializerProvider, xgen, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
