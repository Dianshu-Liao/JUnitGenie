package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class deser_XmlReadContext_shouldWrap_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testShouldWrapWhenNamesToWrapIsNull() {
        // Arrange
        XmlReadContext context = new XmlReadContext(null, 0, 0, 0, 0);
        
        // Act
        boolean result = context.shouldWrap("someName");
        
        // Assert
        assertFalse(result);
    }

}