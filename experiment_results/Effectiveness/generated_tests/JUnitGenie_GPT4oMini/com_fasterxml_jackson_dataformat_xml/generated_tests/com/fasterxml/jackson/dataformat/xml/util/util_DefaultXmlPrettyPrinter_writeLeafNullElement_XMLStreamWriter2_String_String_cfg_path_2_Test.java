package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import static org.mockito.Mockito.*;

public class util_DefaultXmlPrettyPrinter_writeLeafNullElement_XMLStreamWriter2_String_String_cfg_path_2_Test {
    private XMLStreamWriter2 mockWriter;
    private DefaultXmlPrettyPrinter prettyPrinter;

    @Before
    public void setUp() throws Exception {
        mockWriter = mock(XMLStreamWriter2.class);
        prettyPrinter = new DefaultXmlPrettyPrinter();
    }

    @Test(timeout = 4000)
    public void testWriteLeafNullElementNoInline() {
        try {
            // Assuming _objectIndenter.isInline() returns false
            DefaultXmlPrettyPrinter.Indenter mockIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
            when(mockIndenter.isInline()).thenReturn(false);
            // Use reflection to set _objectIndenter
            java.lang.reflect.Field indenterField = DefaultXmlPrettyPrinter.class.getDeclaredField("_objectIndenter");
            indenterField.setAccessible(true);
            indenterField.set(prettyPrinter, mockIndenter);

            // Set parameters
            String nsURI = "http://example.com/ns";
            String localName = "testElement";

            // Invoke the method
            prettyPrinter.writeLeafNullElement(mockWriter, nsURI, localName);

            // Verify interactions
            verify(mockWriter).writeEmptyElement(nsURI, localName);
            // Verify _justHadStartElement state
            java.lang.reflect.Field justHadStartElementField = DefaultXmlPrettyPrinter.class.getDeclaredField("_justHadStartElement");
            justHadStartElementField.setAccessible(true);
            boolean justHadStartElement = (boolean) justHadStartElementField.get(prettyPrinter);
            assert !justHadStartElement;
        } catch (XMLStreamException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}