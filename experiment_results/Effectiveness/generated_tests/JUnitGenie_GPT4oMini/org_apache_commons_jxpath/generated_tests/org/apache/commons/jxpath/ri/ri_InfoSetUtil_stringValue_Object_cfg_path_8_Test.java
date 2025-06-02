package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.Pointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testStringValueWithEvalContext() {
        // Arrange
        EvalContext mockEvalContext = mock(EvalContext.class);
        Pointer mockPointer = mock(Pointer.class);
        
        // Setting up the mock behavior
        when(mockEvalContext.getSingleNodePointer()).thenReturn(mockPointer);
        when(mockPointer.getValue()).thenReturn("mockValue");
        when(mockEvalContext.nextSet()).thenReturn(true); // Ensure nextSet() returns true
        when(mockEvalContext.nextNode()).thenReturn(true); // Ensure nextNode() returns true

        // Act
        String result = InfoSetUtil.stringValue(mockEvalContext);

        // Assert
        assertEquals("mockValue", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithNull() {
        // Act
        String result = InfoSetUtil.stringValue(null);

        // Assert
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanTrue() {
        // Act
        String result = InfoSetUtil.stringValue(Boolean.TRUE);

        // Assert
        assertEquals("true", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanFalse() {
        // Act
        String result = InfoSetUtil.stringValue(Boolean.FALSE);

        // Assert
        assertEquals("false", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithNumber() {
        // Act
        String result = InfoSetUtil.stringValue(123.45);

        // Assert
        assertEquals("123.45", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithString() {
        // Act
        String result = InfoSetUtil.stringValue("testString");

        // Assert
        assertEquals("testString", result);
    }



}
