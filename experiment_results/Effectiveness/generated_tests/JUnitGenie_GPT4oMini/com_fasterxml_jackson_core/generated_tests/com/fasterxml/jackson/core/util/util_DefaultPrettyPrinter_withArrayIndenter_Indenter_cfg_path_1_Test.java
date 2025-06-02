package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_DefaultPrettyPrinter_withArrayIndenter_Indenter_cfg_path_1_Test {

    private class TestIndenter implements Indenter {
        @Override
        public boolean isInline() {
            return false;
        }

        @Override
        public void writeIndentation(com.fasterxml.jackson.core.JsonGenerator jsonGenerator, int level) {
            // Implementation for testing purposes
        }
    }

    @Test(timeout = 4000)
    public void testWithArrayIndenter() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        TestIndenter indenter = new TestIndenter();

        DefaultPrettyPrinter result = printer.withArrayIndenter(indenter);
        
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testWithArrayIndenterNull() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        
        DefaultPrettyPrinter result = printer.withArrayIndenter(null);
        
        assertNotNull(result);
    }

}