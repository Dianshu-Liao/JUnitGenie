package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.NopIndenter;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class util_DefaultXmlPrettyPrinter_indentArraysWith_Indenter_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIndentArraysWith_NullIndenter() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        Indenter indenter = null;

        try {
            printer.indentArraysWith(indenter);
            // Verify that the _arrayIndenter is set to an instance of NopIndenter
            assertTrue(printer._arrayIndenter instanceof NopIndenter);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIndentArraysWith_ValidIndenter() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        Indenter indenter = new Indenter() {
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
        };

        try {
            printer.indentArraysWith(indenter);
            // Verify that the _arrayIndenter is set to the provided indenter
            assertTrue(printer._arrayIndenter == indenter);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}