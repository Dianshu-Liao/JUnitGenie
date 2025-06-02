package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import java.util.LinkedList;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_9_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;


    @Test(timeout = 4000)
    public void testHandleEndObject() {
        try {
            toXmlGenerator._handleEndObject();
        } catch (IOException e) {
            // Handle the IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(expected = JsonGenerationException.class)
    public void testHandleEndObjectThrowsExceptionWhenStackIsEmpty() throws IOException {
        // Clear the stack to trigger the exception
        toXmlGenerator._elementNameStack.clear();
        toXmlGenerator._handleEndObject();
    }

    @Test(timeout = 4000)
    public void testHandleEndObjectWithXMLStreamException() {
        // Prepare the _elementNameStack with a QName
        toXmlGenerator._elementNameStack.add(new QName("testElement"));
        
        // Mock the behavior of xmlWriter to throw XMLStreamException
        try {
            doThrow(new XMLStreamException("Test Exception")).when(xmlWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle the XMLStreamException if it occurs
            e.printStackTrace();
        }
        
        try {
            toXmlGenerator._handleEndObject();
        } catch (IOException e) {
            // Handle the IOException if it occurs
            e.printStackTrace();
        }
    }


}
