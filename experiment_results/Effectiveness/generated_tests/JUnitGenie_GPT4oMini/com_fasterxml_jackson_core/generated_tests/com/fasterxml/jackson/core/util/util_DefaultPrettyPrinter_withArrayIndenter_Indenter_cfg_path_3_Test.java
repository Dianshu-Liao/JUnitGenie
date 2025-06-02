package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_DefaultPrettyPrinter_withArrayIndenter_Indenter_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithArrayIndenter() {
        // Arrange
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Indenter indenter = new Indenter() {
            @Override
            public boolean isInline() {
                return false;
            }

            @Override
            public void writeIndentation(JsonGenerator jg, int level) {
                // Custom indentation logic can be added here
            }
        };

        // Act
        DefaultPrettyPrinter result = printer.withArrayIndenter(indenter);

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testWithArrayIndenter_NullIndenter() {
        // Arrange
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();

        // Act
        DefaultPrettyPrinter result = printer.withArrayIndenter(null);

        // Assert
        assertNotNull(result);
    }


}