package org.apache.commons.jxpath;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.net.URL;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import java.util.Objects;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class XMLDocumentContainer_getValue_0_2_Test {

    private XMLDocumentContainer xmlDocumentContainer;

    private DocumentContainer mockDocumentContainer;

    private Source mockSource;

    @BeforeEach
    public void setUp() {
        mockDocumentContainer = mock(DocumentContainer.class);
        xmlDocumentContainer = createXMLDocumentContainer(mockDocumentContainer);
    }

    private XMLDocumentContainer createXMLDocumentContainer(DocumentContainer documentContainer) {
        try {
            Constructor<XMLDocumentContainer> constructor = XMLDocumentContainer.class.getDeclaredConstructor(DocumentContainer.class);
            constructor.setAccessible(true);
            return constructor.newInstance(documentContainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetValueWithNullDocumentAndSource() {
        when(mockDocumentContainer.getValue()).thenReturn("Mock Document");
        Object value = xmlDocumentContainer.getValue();
        assertNotNull(value);
        assertEquals("Mock Document", value);
    }

    @Test
    public void testGetValueWithSource() throws Exception {
        String xml = "<root><element>value</element></root>";
        mockSource = new StreamSource(new StringReader(xml));
        xmlDocumentContainer = new XMLDocumentContainer(mockSource);
        Object result = xmlDocumentContainer.getValue();
        assertNotNull(result);
        // Additional assertions can be made based on the expected result of the transformation
    }

    @Test
    public void testGetValueWithException() {
        when(mockDocumentContainer.getValue()).thenThrow(new JXPathException("Test Exception"));
        xmlDocumentContainer = createXMLDocumentContainer(mockDocumentContainer);
        Exception exception = assertThrows(JXPathException.class, () -> {
            xmlDocumentContainer.getValue();
        });
        assertEquals("Cannot read XML from: <<undefined source>>", exception.getMessage());
    }

    @Test
    public void testGetValueWithURL() throws Exception {
        URL mockURL = new URL("http://example.com/test.xml");
        xmlDocumentContainer = new XMLDocumentContainer(mockURL);
        // Simulate DocumentContainer behavior
        when(mockDocumentContainer.getValue()).thenReturn("Document from URL");
        Object value = xmlDocumentContainer.getValue();
        assertNotNull(value);
        assertEquals("Document from URL", value);
    }

    @Test
    public void testGetValueWithNullSourceAndDelegate() {
        xmlDocumentContainer = new XMLDocumentContainer((Source) null);
        Exception exception = assertThrows(JXPathException.class, () -> {
            xmlDocumentContainer.getValue();
        });
        assertEquals("Cannot read XML from: <<undefined source>>", exception.getMessage());
    }
}
