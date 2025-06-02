package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerationException;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_5_Test {

    private ToXmlGenerator generator;
    private XMLStreamWriter2 mockXmlWriter;

    @Before
    public void setUp() {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        // Assuming the constructor of ToXmlGenerator requires a non-null first argument
        generator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
        generator._elementNameStack = new LinkedList<>(); // Initialize the stack as empty
    }

    @Test(expected = JsonGenerationException.class)
    public void testHandleEndObject_ThrowsJsonGenerationException_WhenStackIsEmpty() throws IOException {
        // Call the method under test
        generator._handleEndObject();
    }

    @Test(timeout = 4000)
    public void testHandleEndObject_SuccessfulExecution_WhenStackIsNotEmpty() throws IOException, XMLStreamException {
        // Prepare the test data
        QName qName = new QName("testElement");
        generator._elementNameStack.add(qName); // Add an element to the stack

        // Call the method under test
        generator._handleEndObject();

        // Verify that writeEndElement was called
        verify(mockXmlWriter).writeEndElement();
    }

    @Test(timeout = 4000)
    public void testHandleEndObject_HandlesXMLStreamException() throws IOException {
        // Prepare the test data
        QName qName = new QName("testElement");
        generator._elementNameStack.add(qName); // Add an element to the stack

        // Mock the behavior of the XMLStreamWriter to throw an exception
        try {
            doThrow(new XMLStreamException("Test exception")).when(mockXmlWriter).writeEndElement();
            // Call the method under test
            generator._handleEndObject();
        } catch (XMLStreamException e) {
            throw new JsonGenerationException(e); // Wrap the exception
        }
    }

}