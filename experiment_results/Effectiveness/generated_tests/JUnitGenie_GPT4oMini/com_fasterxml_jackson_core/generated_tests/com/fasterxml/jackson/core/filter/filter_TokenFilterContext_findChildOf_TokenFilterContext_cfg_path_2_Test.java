package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class filter_TokenFilterContext_findChildOf_TokenFilterContext_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFindChildOfReturnsNullWhenNoChildFound() {
        try {
            // Create a parent TokenFilterContext
            TokenFilterContext parent = new TokenFilterContext(0, null, null, false);
            // Create a TokenFilterContext with a different parent
            TokenFilterContext child = new TokenFilterContext(1, null, null, false);
            // Call the method under test
            TokenFilterContext result = child.findChildOf(parent);
            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}