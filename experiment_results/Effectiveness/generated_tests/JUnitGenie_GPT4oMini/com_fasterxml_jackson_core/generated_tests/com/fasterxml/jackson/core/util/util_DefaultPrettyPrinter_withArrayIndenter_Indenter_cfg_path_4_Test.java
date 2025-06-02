package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_DefaultPrettyPrinter_withArrayIndenter_Indenter_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWithArrayIndenter_NullIndenter() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Indenter result = printer.withArrayIndenter(null)._arrayIndenter;
        assertEquals(NopIndenter.instance, result);
    }

    @Test(timeout = 4000)
    public void testWithArrayIndenter_SameIndenter() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Indenter indenter = new Indenter() {
            @Override
            public boolean isInline() {
                return false;
            }

            @Override
            public void writeIndentation(JsonGenerator jsonGenerator, int level) {
                // Implementation can be empty for test purposes
            }
        };
        printer.withArrayIndenter(indenter);
        DefaultPrettyPrinter result = printer.withArrayIndenter(indenter);
        assertSame(printer, result);
    }

    @Test(timeout = 4000)
    public void testWithArrayIndenter_DifferentIndenter() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Indenter indenter1 = new Indenter() {
            @Override
            public boolean isInline() {
                return false;
            }
            @Override
            public void writeIndentation(JsonGenerator jsonGenerator, int level) {
                // Implementation can be empty for test purposes
            }
        };
        Indenter indenter2 = new Indenter() {
            @Override
            public boolean isInline() {
                return false;
            }
            @Override
            public void writeIndentation(JsonGenerator jsonGenerator, int level) {
                // Implementation can be empty for test purposes
            }
        };
        
        DefaultPrettyPrinter result1 = printer.withArrayIndenter(indenter1);
        DefaultPrettyPrinter result2 = result1.withArrayIndenter(indenter2);
        
        assertNotSame(result1, result2);
        assertEquals(indenter2, result2._arrayIndenter);
    }


}