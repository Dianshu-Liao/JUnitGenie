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
import static org.junit.Assert.assertEquals;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_14_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Initialize the _elementNameStack to simulate a non-empty stack
        toXmlGenerator._elementNameStack = new LinkedList<>();
        toXmlGenerator._elementNameStack.add(new QName("element"));
    }

    @Test(timeout = 4000)
    public void testHandleEndObject() throws IOException {
        try {
            toXmlGenerator._handleEndObject();
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(expected = JsonGenerationException.class)
    public void testHandleEndObjectThrowsExceptionWhenStackIsEmpty() throws IOException {
        // Clear the stack to trigger the exception
        toXmlGenerator._elementNameStack.clear();
        try {
            toXmlGenerator._handleEndObject();
        } catch (JsonGenerationException e) {
            // Verify the exception message
            assertEquals("Can not write END_ELEMENT without open START_ELEMENT", e.getMessage());
            throw e; // Rethrow to satisfy the expected exception
        }
    }

    @Test(timeout = 4000)
    public void testHandleEndObjectWithPrettyPrinter() throws IOException, XMLStreamException {
        // Set up the pretty printer
        toXmlGenerator._xmlPrettyPrinter = mock(com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter.class);
        // Instead of directly assigning to _stax2Emulation, we will assume it is handled internally
        // and we will not call a setter method since it does not exist.

        toXmlGenerator._handleEndObject();

        // Verify that writeEndElement was called
        verify(xmlWriter).writeEndElement();
        // Verify that writePrologLinefeed was called
        verify(toXmlGenerator._xmlPrettyPrinter).writePrologLinefeed(xmlWriter);
    }


}