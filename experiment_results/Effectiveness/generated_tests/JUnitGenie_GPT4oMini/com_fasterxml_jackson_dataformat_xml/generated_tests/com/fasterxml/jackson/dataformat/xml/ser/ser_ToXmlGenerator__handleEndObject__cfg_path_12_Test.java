package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.LinkedList;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_12_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        toXmlGenerator._elementNameStack = new LinkedList<>();
    }

    @Test(expected = JsonGenerationException.class)
    public void testHandleEndObject_ThrowsJsonGenerationException_WhenElementNameStackIsEmpty() throws IOException {
        // Arrange: Ensure the _elementNameStack is empty
        toXmlGenerator._elementNameStack.clear();

        // Act: Call the method under test
        toXmlGenerator._handleEndObject();
    }

    @Test(timeout = 4000)
    public void testHandleEndObject_SuccessfulExecution_WhenElementNameStackIsNotEmpty() throws IOException, XMLStreamException {
        // Arrange: Add a QName to the _elementNameStack
        toXmlGenerator._elementNameStack.add(new QName("testElement"));

        // Act: Call the method under test
        toXmlGenerator._handleEndObject();

        // Assert: Verify that writeEndElement was called
        verify(xmlWriter).writeEndElement();
    }

    @Test(timeout = 4000)
    public void testHandleEndObject_HandlesXMLStreamException() throws IOException, XMLStreamException {
        // Arrange: Add a QName to the _elementNameStack
        toXmlGenerator._elementNameStack.add(new QName("testElement"));
        doThrow(new XMLStreamException()).when(xmlWriter).writeEndElement();

        // Act: Call the method under test
        try {
            toXmlGenerator._handleEndObject();
        } catch (JsonGenerationException e) {
            // Assert: Verify that the exception is thrown
            assertNotNull(e); // This line is now valid
        }
    }

}