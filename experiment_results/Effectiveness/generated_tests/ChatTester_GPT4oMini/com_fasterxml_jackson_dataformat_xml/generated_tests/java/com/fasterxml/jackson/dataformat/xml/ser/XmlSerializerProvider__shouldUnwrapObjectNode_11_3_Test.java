package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
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
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;

public class XmlSerializerProvider__shouldUnwrapObjectNode_11_3_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private ToXmlGenerator mockToXmlGenerator;

    @BeforeEach
    public void setUp() {
        // Mock the XmlRootNameLookup and other dependencies as needed
        XmlRootNameLookup mockRootNameLookup = Mockito.mock(XmlRootNameLookup.class);
        xmlSerializerProvider = new XmlSerializerProvider(mockRootNameLookup);
        mockToXmlGenerator = Mockito.mock(ToXmlGenerator.class);
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenEnabledAndObjectNodeWithOneChild_ReturnsTrue() throws Exception {
        // Arrange
        Mockito.when(mockToXmlGenerator.isEnabled(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE)).thenReturn(true);
        ObjectNode objectNode = Mockito.mock(ObjectNode.class);
        Mockito.when(objectNode.size()).thenReturn(1);
        // Act
        boolean result = invokeShouldUnwrapObjectNode(mockToXmlGenerator, objectNode);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenNotEnabled_ReturnsFalse() throws Exception {
        // Arrange
        Mockito.when(mockToXmlGenerator.isEnabled(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE)).thenReturn(false);
        ObjectNode objectNode = Mockito.mock(ObjectNode.class);
        Mockito.when(objectNode.size()).thenReturn(1);
        // Act
        boolean result = invokeShouldUnwrapObjectNode(mockToXmlGenerator, objectNode);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenNotObjectNode_ReturnsFalse() throws Exception {
        // Arrange
        Mockito.when(mockToXmlGenerator.isEnabled(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE)).thenReturn(true);
        String notAnObjectNode = "Not an ObjectNode";
        // Act
        boolean result = invokeShouldUnwrapObjectNode(mockToXmlGenerator, notAnObjectNode);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testShouldUnwrapObjectNode_WhenObjectNodeWithZeroChildren_ReturnsFalse() throws Exception {
        // Arrange
        Mockito.when(mockToXmlGenerator.isEnabled(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE)).thenReturn(true);
        ObjectNode objectNode = Mockito.mock(ObjectNode.class);
        Mockito.when(objectNode.size()).thenReturn(0);
        // Act
        boolean result = invokeShouldUnwrapObjectNode(mockToXmlGenerator, objectNode);
        // Assert
        assertFalse(result);
    }

    private boolean invokeShouldUnwrapObjectNode(ToXmlGenerator xgen, Object value) throws Exception {
        Method method = XmlSerializerProvider.class.getDeclaredMethod("_shouldUnwrapObjectNode", ToXmlGenerator.class, Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(xmlSerializerProvider, xgen, value);
    }
}
