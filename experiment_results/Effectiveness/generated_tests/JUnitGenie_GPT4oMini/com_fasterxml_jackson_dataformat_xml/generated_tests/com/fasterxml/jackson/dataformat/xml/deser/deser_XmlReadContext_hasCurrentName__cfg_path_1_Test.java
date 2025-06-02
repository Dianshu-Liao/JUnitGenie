package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class deser_XmlReadContext_hasCurrentName__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasCurrentNameWhenCurrentNameIsNull() {
        // Arrange
        XmlReadContext context = new XmlReadContext(null, 0, 0, 0, 0);
        
        // Act
        boolean result = context.hasCurrentName();
        
        // Assert
        assertFalse(result);
    }

}