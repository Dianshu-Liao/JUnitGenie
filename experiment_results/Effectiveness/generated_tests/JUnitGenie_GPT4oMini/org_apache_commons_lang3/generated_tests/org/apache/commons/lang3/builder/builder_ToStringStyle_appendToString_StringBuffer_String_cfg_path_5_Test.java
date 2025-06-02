package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_appendToString_StringBuffer_String_cfg_path_5_Test extends ToStringStyle {
    
    private String contentStart = "[";
    private String contentEnd = "]";

    @Test(timeout = 4000)
    public void testAppendToString() {
        StringBuffer buffer = new StringBuffer();
        String toString = "[value1,value2]";
        
        // Call the method under test
        appendToString(buffer, toString);
        
        // Validate the result
        String expected = "value1,value2";
        assertEquals(expected, buffer.toString());
    }
    
    @Test(timeout = 4000)
    public void testAppendToStringWithNullToString() {
        StringBuffer buffer = new StringBuffer();
        String toString = null;
        
        // Call the method under test
        appendToString(buffer, toString);
        
        // Validate the result
        String expected = "";
        assertEquals(expected, buffer.toString());
    }
    
    @Test(timeout = 4000)
    public void testAppendToStringWithNoContent() {
        StringBuffer buffer = new StringBuffer();
        String toString = "[,]";
        
        // Call the method under test
        appendToString(buffer, toString);
        
        // Validate the result
        String expected = "";
        assertEquals(expected, buffer.toString());
    }

}