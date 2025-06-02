package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class filter_TokenFilterContext_findChildOf_TokenFilterContext_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testFindChildOf() {
        try {
            // Create parent and child TokenFilterContext instances
            TokenFilterContext parent = new TokenFilterContext(0, null, null, false);
            TokenFilterContext child = new TokenFilterContext(1, parent, null, false);
            
            // Test the findChildOf method
            TokenFilterContext result = child.findChildOf(parent);
            
            // Assert that the result is the parent
            assertEquals(parent, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}