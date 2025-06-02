package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import javax.xml.namespace.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Map;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;

public class XmlSerializerProvider__shouldUnwrapObjectNode_11_0_Test {

    private XmlRootNameLookup rootNameLookup;

    private XmlSerializerProvider xmlSerializerProvider;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() {
        rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        // Mocked parameters
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, null, null);
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenFeatureEnabledAndValueIsObjectNodeWithOneField_ReturnsTrue() {
        // Simulating the feature being enabled
        toXmlGenerator.setNextIsUnwrapped(true);
        // Creating an ObjectNode
        ObjectNode objectNode = new ObjectNode(null);
        // Adding one field
        objectNode.put("field", "value");
        boolean result = xmlSerializerProvider._shouldUnwrapObjectNode(toXmlGenerator, objectNode);
        assertTrue(result, "Expected to return true when feature is enabled and ObjectNode has one field.");
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenFeatureEnabledAndValueIsObjectNodeWithMultipleFields_ReturnsFalse() {
        // Simulating the feature being enabled
        toXmlGenerator.setNextIsUnwrapped(true);
        // Creating an ObjectNode
        ObjectNode objectNode = new ObjectNode(null);
        // Adding multiple fields
        objectNode.put("field1", "value1");
        objectNode.put("field2", "value2");
        boolean result = xmlSerializerProvider._shouldUnwrapObjectNode(toXmlGenerator, objectNode);
        assertFalse(result, "Expected to return false when ObjectNode has multiple fields.");
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenFeatureDisabled_ReturnsFalse() {
        // Simulating the feature being disabled
        toXmlGenerator.setNextIsUnwrapped(false);
        // Creating an ObjectNode
        ObjectNode objectNode = new ObjectNode(null);
        // Adding one field
        objectNode.put("field", "value");
        boolean result = xmlSerializerProvider._shouldUnwrapObjectNode(toXmlGenerator, objectNode);
        assertFalse(result, "Expected to return false when feature is disabled.");
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenValueIsNotObjectNode_ReturnsFalse() {
        // Simulating the feature being enabled
        toXmlGenerator.setNextIsUnwrapped(true);
        // Not an ObjectNode
        String notAnObjectNode = "This is not an ObjectNode";
        boolean result = xmlSerializerProvider._shouldUnwrapObjectNode(toXmlGenerator, notAnObjectNode);
        assertFalse(result, "Expected to return false when value is not an ObjectNode.");
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenValueIsNull_ReturnsFalse() {
        // Simulating the feature being enabled
        toXmlGenerator.setNextIsUnwrapped(true);
        boolean result = xmlSerializerProvider._shouldUnwrapObjectNode(toXmlGenerator, null);
        assertFalse(result, "Expected to return false when value is null.");
    }
}
