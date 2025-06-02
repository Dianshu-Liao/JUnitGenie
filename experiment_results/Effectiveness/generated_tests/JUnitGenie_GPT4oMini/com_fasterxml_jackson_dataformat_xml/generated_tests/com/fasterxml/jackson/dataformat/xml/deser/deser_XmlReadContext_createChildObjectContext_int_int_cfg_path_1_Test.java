package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class deser_XmlReadContext_createChildObjectContext_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateChildObjectContext() {
        // Arrange
        XmlReadContext parentContext = null; // _child is initially null
        int lineNr = 1; // valid integer value
        int colNr = 2; // valid integer value
        XmlReadContext context = new XmlReadContext(parentContext, 0, 0, 0, 0); // Create parent context

        // Act
        XmlReadContext childContext = context.createChildObjectContext(lineNr, colNr);

        // Assert
        assertNotNull("Child context should not be null", childContext);
    }

}