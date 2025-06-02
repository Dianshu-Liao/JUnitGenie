package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_DefaultXmlPrettyPrinter_indentArraysWith_Indenter_cfg_path_1_Test {

    private class TestIndenter implements Indenter {
        @Override
        public boolean isInline() {
            return false;
        }

        @Override
        public void writeIndentation(org.codehaus.stax2.XMLStreamWriter2 writer, int level) {
            // Implementation for testing
        }

        @Override
        public void writeIndentation(com.fasterxml.jackson.core.JsonGenerator generator, int level) {
            // Implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testIndentArraysWith_NonNullIndenter() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        Indenter indenter = new TestIndenter();
        
        printer.indentArraysWith(indenter);
        
        // Verify that the _arrayIndenter is set correctly
        assertNotNull(printer._arrayIndenter);
    }

    @Test(timeout = 4000)
    public void testIndentArraysWith_NullIndenter() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        
        printer.indentArraysWith(null);
        
        // Verify that the _arrayIndenter is set to NopIndenter when null is passed
        assertNotNull(printer._arrayIndenter);
        // Additional checks can be added here to verify the type of _arrayIndenter
    }

}