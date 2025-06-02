package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.Pointer;
import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithEvalContext() {
        // Mocking EvalContext and Pointer for testing
        EvalContext evalContext = mock(EvalContext.class);
        Pointer pointer = mock(Pointer.class);

        // Setting up the conditions to satisfy the constraints
        when(evalContext.getSingleNodePointer()).thenReturn(pointer);
        // Removed the isActual() method call as it does not exist in Pointer class
        
        // Assuming we have mocked nextSet() and nextNode() to return true
        when(evalContext.nextSet()).thenReturn(true); // nextSet must return true
        when(evalContext.nextNode()).thenReturn(true); // nextNode must return true
        
        // Now, we can call the method using the mocked context
        boolean result = InfoSetUtil.booleanValue(evalContext);
        
        // Validate the result
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNullPointerInEvalContext() {
        // Mocking EvalContext to return null from getSingleNodePointer
        EvalContext evalContext = mock(EvalContext.class);
        when(evalContext.getSingleNodePointer()).thenReturn(null);
        
        // Now we can call the method using the mocked context
        boolean result = InfoSetUtil.booleanValue(evalContext);
        
        // Validate the result, as ptr is null, it should return false
        assertFalse(result);
    }
    
    @Test(timeout = 4000)
    public void testBooleanValueWithNonNumber() {
        // Call with an Integer which is a valid Number
        boolean result = InfoSetUtil.booleanValue(5);
        
        // Validate result (5 is not zero, so should return true)
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNumberZero() {
        // Call with Integer value 0
        boolean result = InfoSetUtil.booleanValue(0);
        
        // Validate result (0 should return false)
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNaN() {
        // Call with NaN
        boolean result = InfoSetUtil.booleanValue(Double.NaN);
        
        // Validate result (NaN should return false)
        assertFalse(result);
    }


}