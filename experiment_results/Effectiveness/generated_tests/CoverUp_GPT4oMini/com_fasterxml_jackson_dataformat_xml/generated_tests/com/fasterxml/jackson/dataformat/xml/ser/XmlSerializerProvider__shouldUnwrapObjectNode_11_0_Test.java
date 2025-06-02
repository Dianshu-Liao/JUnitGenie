package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import javax.xml.namespace.QName;
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

    private XmlSerializerProvider xmlSerializerProvider;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() {
        XmlRootNameLookup rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        toXmlGenerator = new DummyToXmlGenerator();
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenEnabledAndSingleFieldObjectNode_ReturnsTrue() throws Exception {
        toXmlGenerator.enable(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE);
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode().put("field", "value");
        boolean result = invokeShouldUnwrapObjectNode(xmlSerializerProvider, toXmlGenerator, objectNode);
        assertTrue(result);
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenEnabledAndMultipleFieldObjectNode_ReturnsFalse() throws Exception {
        toXmlGenerator.enable(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE);
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode().put("field1", "value1").put("field2", "value2");
        boolean result = invokeShouldUnwrapObjectNode(xmlSerializerProvider, toXmlGenerator, objectNode);
        assertFalse(result);
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenDisabled_ReturnsFalse() throws Exception {
        toXmlGenerator.disable(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE);
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode().put("field", "value");
        boolean result = invokeShouldUnwrapObjectNode(xmlSerializerProvider, toXmlGenerator, objectNode);
        assertFalse(result);
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenNotObjectNode_ReturnsFalse() throws Exception {
        toXmlGenerator.enable(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE);
        String nonObjectNode = "Not an ObjectNode";
        boolean result = invokeShouldUnwrapObjectNode(xmlSerializerProvider, toXmlGenerator, nonObjectNode);
        assertFalse(result);
    }

    private boolean invokeShouldUnwrapObjectNode(XmlSerializerProvider provider, ToXmlGenerator xgen, Object value) throws Exception {
        Method method = XmlSerializerProvider.class.getDeclaredMethod("_shouldUnwrapObjectNode", ToXmlGenerator.class, Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(provider, xgen, value);
    }

    private static class DummyToXmlGenerator extends ToXmlGenerator {

        public DummyToXmlGenerator() {
            super(null, 0, 0, null, null, null);
        }
    }
}
