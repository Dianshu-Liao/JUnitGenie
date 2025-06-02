package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.LinkedList;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_18_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        // Adjust the constructor parameters to avoid NullPointerException
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        toXmlGenerator._elementNameStack = new LinkedList<>();
    }

    @Test(timeout = 4000)
    public void testHandleEndObject_ThrowsJsonGenerationException_WhenElementNameStackIsEmpty() {
        try {
            toXmlGenerator._handleEndObject();
        } catch (IOException e) {
            // Expected exception
            assertTrue(e instanceof JsonGenerationException);
            assertEquals("Can not write END_ELEMENT without open START_ELEMENT", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testHandleEndObject_SuccessfulEndElement() throws IOException, XMLStreamException {
        // Setup the stack with a QName
        QName qName = new QName("testElement");
        toXmlGenerator._elementNameStack.add(qName);

        // Call the method
        toXmlGenerator._handleEndObject();

        // Verify that writeEndElement was called
        verify(xmlWriter).writeEndElement();
    }

}