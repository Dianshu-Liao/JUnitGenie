package org.apache.commons.lang3;
import static org.junit.Assert.*;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_removeElements_double_____double_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_NormalCase() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {2.0, 4.0};
        double[] expected = {1.0, 3.0};
        
        double[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(expected, result, 0.001);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArray() {
        double[] array = {};
        double[] values = {1.0, 2.0};
        
        double[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(array, result, 0.001);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElements_EmptyValues() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {};
        
        double[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(array, result, 0.001);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElements_NoMatches() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0, 5.0};
        double[] expected = {1.0, 2.0, 3.0};
        
        double[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(expected, result, 0.001);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElements_AllMatches() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {1.0, 2.0, 3.0};
        double[] expected = {};
        
        double[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(expected, result, 0.001);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElements_WithDuplication() {
        double[] array = {1.0, 2.0, 2.0, 3.0};
        double[] values = {2.0};
        double[] expected = {1.0, 3.0};
        
        double[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(expected, result, 0.001);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElements_NullArray() {
        double[] values = {1.0, 2.0};
        double[] result = ArrayUtils.removeElements(null, values);
        
        assertNull(result);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElements_NullValues() {
        double[] array = {1.0, 2.0, 3.0};
        double[] result = ArrayUtils.removeElements(array, null);
        
        assertArrayEquals(array, result, 0.001);
    }

}