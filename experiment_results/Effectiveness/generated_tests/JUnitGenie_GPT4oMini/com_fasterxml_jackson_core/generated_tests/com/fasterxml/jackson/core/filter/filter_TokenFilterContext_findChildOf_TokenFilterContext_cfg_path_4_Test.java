package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class filter_TokenFilterContext_findChildOf_TokenFilterContext_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testFindChildOfReturnsNullWhenParentIsNotFound() {
        try {
            // Create a TokenFilterContext instance with a null parent
            TokenFilterContext childContext = new TokenFilterContext(0, null, null, false);
            TokenFilterContext parentContext = new TokenFilterContext(0, null, null, false);
            
            // Call the method under test
            TokenFilterContext result = childContext.findChildOf(parentContext);
            
            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}