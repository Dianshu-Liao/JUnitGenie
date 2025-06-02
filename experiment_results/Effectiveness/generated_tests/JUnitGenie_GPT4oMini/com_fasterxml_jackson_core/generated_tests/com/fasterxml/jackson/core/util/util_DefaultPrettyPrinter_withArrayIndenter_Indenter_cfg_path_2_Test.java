package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class util_DefaultPrettyPrinter_withArrayIndenter_Indenter_cfg_path_2_Test {

    private class TestIndenter implements Indenter {
        @Override
        public boolean isInline() {
            return false;
        }

        @Override
        public void writeIndentation(com.fasterxml.jackson.core.JsonGenerator jg, int level) {
            // Implementation for testing purposes
        }
    }

    @Test(timeout = 4000)
    public void testWithArrayIndenter() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Indenter indenter = new TestIndenter();

        // Test case where i is not null and different from _arrayIndenter
        DefaultPrettyPrinter result = printer.withArrayIndenter(indenter);
        assertSame("Expected a new instance of DefaultPrettyPrinter", indenter, result._arrayIndenter);
    }

    @Test(timeout = 4000)
    public void testWithArrayIndenter_NullIndenter() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();

        // Test case where i is null
        DefaultPrettyPrinter result = printer.withArrayIndenter(null);
        assertSame("Expected the default NopIndenter instance", DefaultPrettyPrinter.NopIndenter.instance, result._arrayIndenter);
    }

    @Test(timeout = 4000)
    public void testWithArrayIndenter_SameIndenter() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Indenter indenter = new TestIndenter();
        printer.withArrayIndenter(indenter);

        // Test case where i is the same as _arrayIndenter
        DefaultPrettyPrinter result = printer.withArrayIndenter(indenter);
        assertSame("Expected the same instance of DefaultPrettyPrinter", printer, result);
    }

}